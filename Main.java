package com.company;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;  // Import the Scanner class
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.print("Select an option: \n1) Random Recipe \n2) Add new recipe to collection \n3) Recipe Recommender\n");   //app options

        int option = myObj.nextInt();  // Read user input

        RecipeReader recipe = new RecipeReader();
        HashMap recipe_array = recipe.main("insert path to recipe file");  //path to file
        InstructionReader instruction = new InstructionReader();
        HashMap instruction_array = instruction.main("insert path to instruction file");  //path to file


        switch (option) {                   //read user input and run chosen function
            case 1:
                //System.out.println("Random com.company.Main.Recipe Selected");
                Recipe obj = new Recipe();

                String input = myObj.nextLine();  // Read user input

                Object selected_recipe = null;
                while (!Objects.equals(input, "n")) {
                    selected_recipe = obj.RandomRecipe(recipe_array, instruction_array, recipe_array.size() - 1);
                    System.out.println("Do you want to re-roll the recipe? y/n");

                    input = myObj.nextLine();  // Read user input
                }
                System.out.println("How many servings do you want?");

                int serving = myObj.nextInt();

                Servings servings = new Servings();
                HashMap new_recipe_array = servings.main((HashMap) selected_recipe, serving);
                System.out.println(new_recipe_array);
                break;
            case 2:
                System.out.println("Add New Recipe Selected\n");
                RecipeWriter new_recipe = new RecipeWriter();
                new_recipe.main();
                break;
            case 3:
                System.out.println("Recipe Recommender Selected\n");
                Recipe_Recommender recipe_recommender = new Recipe_Recommender();
                HashMap recommended_recipes = recipe_recommender.main(recipe_array);

                System.out.println("These are the recipes that are able to be made with your current ingredients:\n");
                for (Object i : recommended_recipes.keySet()) {
                    System.out.println("Recipe name: " + i);
                    System.out.println("Ingredients:");
                    HashMap<String, String> temp = (HashMap<String, String>) recommended_recipes.get(i);
                    for (String j : temp.keySet()) {
                        if (j != "servings") {
                            System.out.println(j + ":" + temp.get(j));
                        }
                    }
                    System.out.println("-----------------------------------");
                }
                break;
            default:
                System.out.println("Select a valid option\n");

        }
    }

    public static class Recipe {
        public static Object RandomRecipe(HashMap recipe_array, HashMap instruction_array, int max) {         //return a random recipe
            int min = 0;
            int choice =  (int)Math.floor(Math.random()*(max-min+1)+min);
            int temp = 0;
            Object recipe_name = null;

            for (Object i : recipe_array.keySet()) {
                if (temp == choice) {
                    System.out.println("The recipe chosen is: " + i + "\nThe ingredients are: "+ recipe_array.get(i));

                    HashMap temp_hash = (HashMap) recipe_array.get(i);

                    int servings = 0;

                    for (Object j : temp_hash.keySet()) {
                        if (j == "servings") {
                            servings = Integer.parseInt((String) temp_hash.get(j));
                            //System.out.println("servings");
                        }
                    }
                    System.out.println("The servings are: "+ servings);

                    System.out.println("The instructions are: "+ instruction_array.get(i));
                    //System.out.println(recipe_array.get(i));
                    return recipe_array.get(i);
                }
                else{
                    temp++;
                }
            }
            return recipe_name;
        }
    }
}

