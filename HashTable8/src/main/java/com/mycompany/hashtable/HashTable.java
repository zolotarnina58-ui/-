/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hashtable;

/**
 *
 * @author Student
 */
public class HashTable {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[size];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null && hashArray[j].getKey() != -1)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println();
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(DataItem item) {
        rehash(); // перевірка перед вставкою
        int key = item.getKey();
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arraySize;
        }

        hashArray[hashVal] = item;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }

        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            ++hashVal;
            hashVal %= arraySize;
        }

        return null;
    }

    public double calculateAverageGroupSize() {
        int totalGroups = 0;
        int totalCells = 0;
        boolean inGroup = false;

        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null && hashArray[i].getKey() != -1) {
                totalCells++;
                if (!inGroup) {
                    inGroup = true;
                    totalGroups++;
                }
            } else {
                inGroup = false;
            }
        }

        return totalGroups == 0 ? 0 : (double) totalCells / totalGroups;
    }

    public void rehash() {
        double avgGroupSize = calculateAverageGroupSize();
        if (avgGroupSize > 2.0) {
            int newSize = arraySize * 2;
            DataItem[] oldArray = hashArray;
            hashArray = new DataItem[newSize];
            arraySize = newSize;

            for (DataItem item : oldArray) {
                if (item != null && item.getKey() != -1) {
                    insert(item);
                }
            }

            System.out.println("Розмір таблиці змінено на " + newSize);
        }
    }
}
