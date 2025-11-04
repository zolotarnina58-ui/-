/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.selectsort;

/**
 *
 * @author Student
 */
public class SelectSortApp {
    public static void main(String[] args) {
        ArraySel arr = new ArraySel(100);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(77);
        arr.insert(22);
        arr.insert(77);
        arr.display();

        arr.selectSort();
        arr.display();

        System.out.println("Мода: " + arr.moda());
    }
}
