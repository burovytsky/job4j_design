package ru.job4j.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.logging.UsageLog4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String msg;
                    String response = "";
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("GET /?msg=")) {
                            msg = str.replace("GET /?msg=", "").split(" ")[0];
                            if (msg.equals("Exit")) {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.flush();
                                server.close();
                                break;
                            } else if (msg.equals("Hello")) {
                                response = "Hello!";
                            } else {
                                response = msg;
                            }
                        }
                        System.out.println(str);
                    }
                    if (server.isClosed()) {
                        break;
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(response.getBytes());
                }
            }
        } catch (IOException e) {
            LOG.error("Exception in EchoServer", e);
        }
    }
}
