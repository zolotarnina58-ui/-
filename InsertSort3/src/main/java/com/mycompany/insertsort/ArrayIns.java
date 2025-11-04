/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.insertsort;

/**
 *
 * @author Student
 */

public class ArrayIns {
    private long[] a;
    private int nElems;

    public ArrayIns(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems++] = value;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println();
    }

    public void insertionSort() {
        int comparisons = 0;
        int copies = 0;

        for (int i = 1; i < nElems; i++) {
            long temp = a[i];
            int in = i;
            while (in > 0 && a[in - 1] >= temp) {
                comparisons++;
                a[in] = a[in - 1];
                copies++;
                in--;
            }
            a[in] = temp;
            copies++;
        }

        System.out.println("Копіювань: " + copies);
        System.out.println("Порівнянь: " + comparisons);
    }

    public long median() {
        insertionSort();
        if (nElems % 2 == 1) {
            return a[nElems / 2];
        } else {
            return (a[nElems / 2 - 1] + a[nElems / 2]) / 2;
        }
    }
}

