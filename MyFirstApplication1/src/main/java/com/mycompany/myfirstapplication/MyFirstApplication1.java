/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.myfirstapplication;

/**
 *
 * @author Student
 */
import java.io.*;

public class MyFirstApplication {

    public static String getString() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
 
    public static float getFloat() throws IOException {
        return Float.parseFloat(getString());
    } 
 
    public static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }

    public static float add(float a, float b) { return a + b; }
    public static float subtract(float a, float b) { return a - b; }
    public static float multiply(float a, float b) { return a * b; }
    public static float divide(float a, float b) {
        return b != 0 ? a / b : Float.NaN;
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Число 1 (float): "); float a = getFloat();
        System.out.print("Число 2 (float): "); float b = getFloat();

        System.out.println("Множення: " + multiply(a, b));
        System.out.println("Ділення: " + (b != 0 ? divide(a, b) : "Ділення на нуль!"));

        if (a > b) System.out.println("a > b");
        else if (a < b) System.out.println("a < b");
        else System.out.println("a = b");

        System.out.print("Ціле число 1: "); int x = getInt();
        System.out.print("Ціле число 2: "); int y = getInt();

        int sum = x + y, diff = x - y;
        for (int i = 0; i < 10; i++) sum++;
        for (int i = 0; i < 5; i++) diff++;
        System.out.println("Сума +10: " + sum);
        System.out.println("Різниця +5: " + diff);

        System.out.println("\n1-Додати 2-Відняти 3-Помножити 4-Ділити");
        int choice = getInt();
        System.out.print("Число 1 (float): "); float n1 = getFloat();
        System.out.print("Число 2 (float): "); float n2 = getFloat();

        switch (choice) {
            case 1 -> System.out.println("Сума: " + add(n1, n2));
            case 2 -> System.out.println("Різниця: " + subtract(n1, n2));
            case 3 -> System.out.println("Множення: " + multiply(n1, n2));
            case 4 -> System.out.println(n2 != 0 ? "Ділення: " + divide(n1, n2) : "На 0 ділити не можна!");
            default -> System.out.println("Невірна операція.");
        }
    }
}