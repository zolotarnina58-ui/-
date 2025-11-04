/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarytree;

/**
 *
 * @author Student
 */
public class Node {
    public int iData;
    public double dData;
    public Node leftChild;
    public Node rightChild;

    public Node() { }

    public Node(int id, double dd) {
        iData = id;
        dData = dd;
    }

    public void displayNode() {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}