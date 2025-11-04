/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bubblesort;

/**
 *
 * @author Student
 */

import java.util.Scanner;

public class BubbleSortApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть розмір масиву: ");
        int maxSize = sc.nextInt();

        ArrayBub arr = new ArrayBub(maxSize);
        for (int i = 0; i < maxSize; i++) {
            long n = (long)(Math.random() * (maxSize - 1));
            arr.insert(n);
        }

        System.out.println("До сортування:");
        arr.display();

        arr.bubbleSort(true); // true — за зростанням
        System.out.println("Після сортування:");
        arr.display();
    }
}

