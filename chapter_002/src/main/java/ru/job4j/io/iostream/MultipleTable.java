package ru.job4j.io.iostream;

import java.io.FileOutputStream;
import java.util.Arrays;

public class MultipleTable {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("multiplication table.txt")) {
            String table = Arrays.deepToString(multiple(10));
            out.write(table.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
