package ru.job4j;

public class MemoryInfo {
    public static void main(String[] args) {
        memInfo();
        for (int i = 0; i < 20000; i++) {
          new User("name"+i, "s"+i);
        }
        memInfo();
    }
    private static void memInfo() {
        Runtime runtime = Runtime.getRuntime();

        System.out.println("used memory " + (runtime.totalMemory() - runtime.freeMemory()));

        System.out.println("free memory " + runtime.freeMemory());

        System.out.println("total memory " + runtime.totalMemory());

        System.out.println("=======================================");
    }
}
