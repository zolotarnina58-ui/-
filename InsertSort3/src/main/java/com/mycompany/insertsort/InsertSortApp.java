/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.insertsort;

/**
 *
 * @author Student
 */

public class InsertSortApp {
    public static void main(String[] args) {
        ArrayIns arr = new ArrayIns(100);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.display();

        arr.insertionSort();
        arr.display();

        System.out.println("Медіана: " + arr.median());
    }
}
