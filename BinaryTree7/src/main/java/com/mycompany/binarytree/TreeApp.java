/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarytree;

/**
 *
 * @author Student
 */
public class TreeApp {
    public static void main(String[] args) {
        Tree theTree = new Tree();

        theTree.insert(50, 1.5);
        theTree.insert(25, 1.2);
        theTree.insert(75, 1.7);
        theTree.insert(12, 1.5);
        theTree.insert(37, 1.2);
        theTree.insert(62, 1.7);
        theTree.insert(87, 1.5);

        System.out.println("Обхід дерева (in-order):");
        theTree.traverseInOrder(theTree.getRoot());
        System.out.println();

        System.out.println("Виведення дерева в розгорнутій формі:");
        theTree.displayTree();

        int searchKey = 37;
        Node found = theTree.find(searchKey);
        System.out.print("Пошук елемента " + searchKey + ": ");
        if (found != null) {
            found.displayNode();
            System.out.println(" — знайдено");
        } else {
            System.out.println("не знайдено");
        }

        System.out.println("Мінімальне значення: " + findMin(theTree.getRoot()));
        System.out.println("Максимальне значення: " + findMax(theTree.getRoot()));
    }

    public static int findMin(Node root) {
        Node current = root;
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current.iData;
    }

    public static int findMax(Node root) {
        Node current = root;
        while (current.rightChild != null) {
            current = current.rightChild;
        }
        return current.iData;
    }
}