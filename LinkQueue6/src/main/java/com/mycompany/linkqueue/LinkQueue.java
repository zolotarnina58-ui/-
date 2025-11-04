/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.linkqueue;

/**
 *
 * @author Student
 */
public class LinkQueue {
    private Link first;
    private Link last;

    public LinkQueue() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(long d) {
        Link newLink = new Link(d);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public long remove() {
        if (isEmpty()) {
            throw new RuntimeException("Черга порожня");
        }
        long temp = first.dData;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void displayQueue() {
        System.out.print("Queue (front → rear): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}
