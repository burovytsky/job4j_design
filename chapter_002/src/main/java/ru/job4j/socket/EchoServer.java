package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.equals("GET /?msg=Bye HTTP/1.1")) {
                            out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                            out.flush();
                            server.close();
                            break;
                        }
                        System.out.println(str);
                    }
                    if (server.isClosed()) {
                        break;
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                }
            }
        }
//        try (ServerSocket server = new ServerSocket(9000)) {
//            while (true) {
//                Socket socket = server.accept();
//                try (OutputStream out = socket.getOutputStream();
//                     BufferedReader in = new BufferedReader(
//                             new InputStreamReader(socket.getInputStream()))) {
//                    String str;
//                    while (!(str = in.readLine()).isEmpty()) {
//                        if (str.contains("GET")) {
//                            String msg = str.replace("GET /?msg=", "").split(" ")[0];
//                            if (msg.equals("Exit")) {
//                                out.flush();
//                                server.close();
//                                break;
//                            } else if (msg.equals("Hello")) {
//                                out.write("Hello, user".getBytes());
//                            } else {
//                                out.write(msg.getBytes());
//                            }
//                        }
//                    }
//                    if (server.isClosed()) {
//                        break;
//                    }
//                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
//                }
//            }
//        }
//    }
    }
}
