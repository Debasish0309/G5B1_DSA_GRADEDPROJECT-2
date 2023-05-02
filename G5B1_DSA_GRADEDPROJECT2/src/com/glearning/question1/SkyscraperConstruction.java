package com.glearning.question1;

import java.util.Scanner;
import java.util.Stack;


public class SkyscraperConstruction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of floors in the building:");
        int n = sc.nextInt();
        int[] floorSizes = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the floor size given on day " + (i+1) + ":");
            floorSizes[i] = sc.nextInt();
        }
        Stack<Integer> floors = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            while (!floors.empty() && floors.peek() < floorSizes[i]) {
                System.out.print(floors.pop() + " ");
            }
            floors.push(floorSizes[i]);
            System.out.println();
        }
        while (!floors.empty()) {
            System.out.print(floors.pop() + " ");
        }
        System.out.println();
    }
}

