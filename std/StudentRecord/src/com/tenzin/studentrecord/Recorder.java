/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenzin.studentrecord;

import java.util.Scanner;

/**
 *
 * @author Home
 */
public class Recorder {

    String[] students = new String[10];
    int counter = 0;
    Scanner input;

    public Recorder(Scanner input) {
        this.input = input;
    }

    public void menu() {
        System.out.println("1.Add student");
        System.out.println("2.Show all");
        System.out.println("3.Search");
        System.out.println("4.Delete");
        System.out.println("5.Exit");
        System.out.println("6.What do you want to do?(1-5)");
    }

    public void addName() {
            while (true) {
                System.out.println("Enter your name here:");

                students[counter] = input.next();
                counter++;

                System.out.println("Do you want to add more?[Y/N]");
                if (input.next().equalsIgnoreCase("n")) {
                    break;
                }
            }
    }

    public void showAll() {
        System.out.println("Show all entered name");
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println(students[i]);
            }
        }
    }

    public void search() {
        while (true) {
            System.out.println("Do you want to search your name?");

            System.out.println("Enter initial letter of your name:");
            String text = input.next();
            boolean found = false;
            for (int i = 0; i < students.length; i++) {
                if (students[i] != null && students[i].startsWith(text)) {
                    System.out.println(students[i]);
                    found = true;
                }

            }
            if (!found) {
                System.out.println("Sorry.Name not found");
            }
            System.out.println("Do you want to check again?");
            if (input.next().equalsIgnoreCase("no")) {
                break;
            }
        }//while 
    }

    public void delete() {
        int counter1=0;
        while(true){
        System.out.println("Delete your name?");
        if(input.next().equalsIgnoreCase("n")){
            break;
        }
        else
        {
            System.out.println("Enter your name:");
            String delete=input.next();
            for (int i = 0; i < students.length; i++) {
               if(delete.equals(students[i])){
                   System.out.println(students[i] + " has been deleted. ");
                   students[i]=null;
                   counter=counter-1;
                   counter1=1;
                   break;
               }      
            }
        }
        if(counter1!=1){
            System.out.println("No records to delete");
        }
            System.out.println("Do you want to delete another?[Y?N]");
            if(input.next().equalsIgnoreCase("n")){
                break;
            }             
    }
    }       

    public void controller() {
        int no = input.nextInt();
        if (no == 1) {
            addName();
        } else if (no == 2) {
            showAll();
        } else if (no == 3) {
            search();
        } else if (no == 4) {
            delete();
        } else if (no == 5) {
            System.exit(0);
        }
    }
}
