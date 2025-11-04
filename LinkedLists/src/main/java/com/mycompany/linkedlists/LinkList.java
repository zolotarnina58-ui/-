/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.linkedlists;

/**
 *
 * @author Student
 */
public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = null;

        while (current != null) {
            if (current.iData == key) {
                if (previous == null) {
                    first = current.next;
                } else {
                    previous.next = current.next;
                }
                return current;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public void display(int count) {
        Link current = first;
        int i = 0;
        while (current != null && i < count) {
            current.displayLink();
            current = current.next;
            i++;
        }
        System.out.println();
    }

    public void displayList() {
        System.out.print("List (first → last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}
