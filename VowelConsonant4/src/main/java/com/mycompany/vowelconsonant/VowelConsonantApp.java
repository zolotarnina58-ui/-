/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vowelconsonant;

/**
 *
 * @author Student
 */
import java.util.Scanner;
import java.util.Stack;

public class VowelConsonantApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть рядок: ");
        String input = sc.nextLine().toLowerCase();

        Stack<Character> vowels = new Stack<>();
        Stack<Character> consonants = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiouаеєиіїоуюя".indexOf(ch) >= 0)
                    vowels.push(ch);
                else
                    consonants.push(ch);
            }
        }

        System.out.println("Голосні:");
        while (!vowels.isEmpty())
            System.out.print(vowels.pop() + " ");

        System.out.println("\nПриголосні:");
        while (!consonants.isEmpty())
            System.out.print(consonants.pop() + " ");
    }
}
