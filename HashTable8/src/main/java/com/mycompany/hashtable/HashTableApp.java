/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hashtable;

/**
 *
 * @author Student
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashTableApp {
    public static void main(String[] args) throws IOException {
        int size, n, keysPerCell;
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;

        HashTable theHashTable = new HashTable(size);

        for (int j = 0; j < n; j++) {
            int aKey = (int)(Math.random() * keysPerCell * size);
            theHashTable.insert(new DataItem(aKey));
        }

        System.out.print("Enter number of manual items to insert: ");
        int manualCount = getInt();
        for (int i = 0; i < manualCount; i++) {
            System.out.print("Enter key for item " + (i + 1) + ": ");
            int key = getInt();
            theHashTable.insert(new DataItem(key));
        }

        while (true) {
            System.out.print("Enter first letter of show, insert, delete, find, or exit: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theHashTable.displayTable();
                    System.out.println("Середній розмір групи: " + theHashTable.calculateAverageGroupSize());
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    int key = getInt();
                    theHashTable.insert(new DataItem(key));
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    key = getInt();
                    theHashTable.delete(key);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    key = getInt();
                    DataItem found = theHashTable.find(key);
                    if (found != null)
                        System.out.println("Found " + key);
                    else
                        System.out.println("Could not find " + key);
                    break;
                case 'e':
                    return;
                default:
                    System.out.println("Invalid entry");
            }
        }
    }

    public static String getString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static char getChar() throws IOException {
        return getString().charAt(0);
    }

    public static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }
}
