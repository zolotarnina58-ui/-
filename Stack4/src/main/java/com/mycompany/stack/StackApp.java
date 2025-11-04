/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stack;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class StackApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Скільки чисел ви хочете ввести? ");
        int count = sc.nextInt();

        StackX stack = new StackX(count);
        System.out.println("Введіть числа:");

        for (int i = 0; i < count; i++) {
            long num = sc.nextLong();
            stack.push(num);
        }

        System.out.println("Числа у зворотному порядку:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}