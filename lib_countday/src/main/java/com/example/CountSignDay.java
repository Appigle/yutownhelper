package com.example;

public class CountSignDay {
    public static void main(String[] args) {
        int a = 1;
        for (int i = 0; i < 100; i++) {
            int sday;
            int eday;
            int b = (int) (a / 5);
            int c = a % 5;
            if( c > 0) {
                sday = 5 * b + 1;
                eday = 5 * b + 5;
            } else {
                sday = 5 * (b - 1) + 1;
                eday = 5 * (b - 1) + 5;
            }
            System.out.print("起始天数"+sday+"\n");
            System.out.print("结束天数"+eday+"\n");
            a++;
        }
    }
}
