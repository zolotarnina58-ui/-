/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arrayproject;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class LowArrayApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LowArray arr = new LowArray(100);
        int nElems = 0;
        int choice;

        do {
            System.out.println("\nМеню:");
            System.out.println("1. Додати елемент");
            System.out.println("2. Вивести масив");
            System.out.println("3. Знайти елемент");
            System.out.println("4. Видалити елемент");
            System.out.println("5. Максимальний елемент");
            System.out.println("6. Мінімальний елемент");
            System.out.println("7. Середнє значення");
            System.out.println("8. Сортувати за зростанням");
            System.out.println("9. Сортувати за спаданням");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введіть значення: ");
                    long val = sc.nextLong();
                    arr.insert(val, nElems++);
                    break;
                case 2:
                    for (int i = 0; i < nElems; i++)
                        System.out.print(arr.getElem(i) + " ");
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Значення для пошуку: ");
                    long key = sc.nextLong();
                    int index = arr.find(key, nElems);
                    System.out.println(index == -1 ? "Не знайдено" : "Знайдено на позиції " + index);
                    break;
                case 4:
                    System.out.print("Значення для видалення: ");
                    long del = sc.nextLong();
                    arr.delete(del, nElems);
                    nElems--;
                    break;
                case 5:
                    System.out.println("Максимум: " + arr.max(nElems));
                    break;
                case 6:
                    System.out.println("Мінімум: " + arr.min(nElems));
                    break;
                case 7:
                    System.out.println("Середнє: " + arr.average(nElems));
                    break;
                case 8:
                    arr.sortAscending(nElems);
                    System.out.println("Відсортовано за зростанням.");
                    break;
                case 9:
                    arr.sortDescending(nElems);
                    System.out.println("Відсортовано за спаданням.");
                    break;
            }
        } while (choice != 0);

        System.out.println("Завершення програми.");
    }
}


