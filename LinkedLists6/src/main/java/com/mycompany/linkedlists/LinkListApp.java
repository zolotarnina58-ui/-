/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.linkedlists;

/**
 *
 * @author Student
 */
import java.util.Random;
import java.util.Scanner;

public class LinkListApp {
    public static void main(String[] args) {
        LinkList theList = new LinkList();
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Скільки елементів вставити? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int id = rand.nextInt(100);
            double dd = rand.nextDouble() * 10;
            theList.insertFirst(id, dd);
        }

        theList.displayList();

        System.out.print("Введіть ключ для видалення: ");
        int key = sc.nextInt();
        Link deleted = theList.delete(key);
        if (deleted != null) {
            System.out.print("Видалено: ");
            deleted.displayLink();
            System.out.println();
        } else {
            System.out.println("Елемент не знайдено.");
        }

        theList.displayList();
    }
}
