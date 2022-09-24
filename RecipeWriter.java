package com.company;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RecipeWriter {
    public static void main() throws IOException {
        String recipe_path = "C:\\Users\\pdene\\IdeaProjects\\recipeapp\\src\\com\\company\\recipes";      //path to file
        String instruction_path = "C:\\Users\\pdene\\IdeaProjects\\recipeapp\\src\\com\\company\\instructions";

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        File file = new File(recipe_path);
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);

        System.out.println("What is the name of the Recipe? \n");

        String recipe_name = myObj.nextLine();  // Read user input

        br.write("\n"+ recipe_name);

        System.out.println("How many servings does the recipe yield? \n");

        String servings = myObj.nextLine();  // Read user input

        br.write(","+ servings);

        int input = 1;
        while (input == 1){
            System.out.println("What is the next ingredient (if no more ingredients press enter)? ");
            String ingredient = myObj.nextLine();

            if (ingredient == ""){
                input = 0;
                break;
            }
            br.write(",");
            System.out.println("What is the measurement for the ingredient? (ex 1.5 tbs) ");
            String amount = myObj.nextLine();

            br.write(ingredient+": "+amount);
        }
        br.close();
        fr.close();

        Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
        File file2 = new File(instruction_path);
        FileWriter fr2 = new FileWriter(file2, true);
        BufferedWriter br2 = new BufferedWriter(fr2);

        br2.write("\n"+ recipe_name);
        System.out.println("what is the link to the recipe? ");
        String link = myObj2.nextLine();
        br2.write(";" + link);

        br2.close();
        fr2.close();

        System.out.println("New recipe has been added to the system");
    }
}
