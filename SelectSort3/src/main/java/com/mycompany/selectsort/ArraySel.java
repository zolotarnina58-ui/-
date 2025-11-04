/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.selectsort;

/**
 *
 * @author Student
 */
public class ArraySel {
    private long[] a;
    private int nElems;

    public ArraySel(int max) {
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

    public void selectSort() {
        for (int out = 0; out < nElems - 1; out++) {
            int min = out;
            for (int in = out + 1; in < nElems; in++) {
                if (a[in] < a[min]) min = in;
            }
            swap(out, min);
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public long moda() {
        selectSort(); // попереднє сортування
        long mode = a[0];
        int maxCount = 1;

        for (int i = 0; i < nElems; i++) {
            int count = 1;
            for (int j = i + 1; j < nElems && a[i] == a[j]; j++) {
                count++;
            }
            if (count > maxCount) {
                maxCount = count;
                mode = a[i];
            }
        }
        return mode;
    }
}
