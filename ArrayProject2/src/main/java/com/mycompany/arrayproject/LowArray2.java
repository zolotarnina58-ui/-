/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arrayproject;

/**
 *
 * @author Student
 */
public class LowArray {
    private long[] a;

    public LowArray(int size) {
        a = new long[size];
    }

    public void setElem(int index, long value) {
        a[index] = value;
    }

    public long getElem(int index) {
        return a[index];
    }

    public int find(long value, int nElems) {
        for (int i = 0; i < nElems; i++) {
            if (a[i] == value) return i;
        }
        return -1;
    }

    public int count(long value, int nElems) {
        int count = 0;
        for (int i = 0; i < nElems; i++) {
            if (a[i] == value) count++;
        }
        return count;
    }

    public void insert(long value, int nElems) {
        a[nElems] = value;
    }

    public void delete(long value, int nElems) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (a[i] == value) break;
        }
        for (int j = i; j < nElems - 1; j++) {
            a[j] = a[j + 1];
        }
    }

    public long max(int nElems) {
        long max = a[0];
        for (int i = 1; i < nElems; i++) {
            if (a[i] > max) max = a[i];
        }
        return max;
    }

    public long min(int nElems) {
        long min = a[0];
        for (int i = 1; i < nElems; i++) {
            if (a[i] < min) min = a[i];
        }
        return min;
    }

    public double average(int nElems) {
        long sum = 0;
        for (int i = 0; i < nElems; i++) {
            sum += a[i];
        }
        return (double) sum / nElems;
    }

    public void sortAscending(int nElems) {
        for (int i = 0; i < nElems - 1; i++) {
            for (int j = i + 1; j < nElems; j++) {
                if (a[i] > a[j]) {
                    long temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public void sortDescending(int nElems) {
        for (int i = 0; i < nElems - 1; i++) {
            for (int j = i + 1; j < nElems; j++) {
                if (a[i] < a[j]) {
                    long temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}


