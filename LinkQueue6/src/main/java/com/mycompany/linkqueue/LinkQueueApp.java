/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.linkqueue;

/**
 *
 * @author Student
 */
public class LinkQueueApp {
    public static void main(String[] args) {
        LinkQueue theQueue = new LinkQueue();

        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);

        System.out.println("Після вставки трьох елементів:");
        theQueue.displayQueue();

        theQueue.remove();
        theQueue.remove();

        System.out.println("Після видалення двох елементів:");
        theQueue.displayQueue();

        theQueue.insert(40);
        theQueue.insert(50);

        System.out.println("Після вставки ще двох елементів:");
        theQueue.displayQueue();
    }
}
