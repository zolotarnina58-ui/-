/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thirdletter;

/**
 *
 * @author Student
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ThirdLetterQueueApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть рядок: ");
        String input = sc.nextLine();

        Queue<Character> thirdLetterQueue = new LinkedList<>();

        // Додавання кожного третього символу до черги
        for (int i = 2; i < input.length(); i += 3) {
            thirdLetterQueue.add(input.charAt(i));
        }

        System.out.println("\nЧерга з кожного третього символу:");
        while (!thirdLetterQueue.isEmpty()) {
            System.out.print(thirdLetterQueue.remove() + " ");
        }
    }
}
