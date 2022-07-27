package com.company;
import java.util.Scanner;  // Import the Scanner class
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.print("Select an option: \n1) Random Recipe \n2) Add new recipe to collection \n3) Recipe Recommender\n");   //app options

        int option = myObj.nextInt();  // Read user input

        CSVReader csv = new CSVReader();
        csv.main("path");  //path to file


        switch (option) {                   //read user input and run chosen function
            case 1:
                //System.out.println("Random com.company.Main.Recipe Selected");
                Recipe obj = new Recipe();
                obj.RandomRecipe();
                break;
            case 2:
                System.out.println("Add New Recipe Selected\n");
                break;
            case 3:
                System.out.println("Recipe Recommender Selected\n");
                break;
            default:
                System.out.println("Select a valid option\n");

        }
    }

    public static class Recipe {
        public static void RandomRecipe() {         //return a random recipe
            int min = 0;
            int max = 100;
            int choice =  (int)Math.floor(Math.random()*(max-min+1)+min);
            System.out.println(choice);
        }
    }
}

