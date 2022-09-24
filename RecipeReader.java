package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;



public class RecipeReader {
    public static HashMap main(String args) {
        String path = "insert path to recipe file";      //path to file
        String line = "";

        HashMap<String, HashMap<String, String>> recipe_array = null;
        HashMap<String, HashMap<String, String>> instruction_array = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            recipe_array = new HashMap<>();


            while ((line = br.readLine()) != null) {                        //read recipe file
                String[] recipe = line.split(",");                    //split up recipes

                HashMap<String, String> ingredients = new HashMap<>();      //inner hashmap

                String recipe_name = recipe[0];                             //get the recipe's name
                int servings = Integer.parseInt(recipe[1]);



                for (int i = 2; i < recipe.length; i++) {                   //split up ingredients and amounts
                    String[] temp = recipe[i].split(":");
                    String item = temp[0];
                    String amount = temp[1];

                    ingredients.put(item, amount);                          //place ingredients and amounts as key and value in inner hashmap
                }
                ingredients.put("servings", String.valueOf(servings));
                recipe_array.put(recipe_name, ingredients);                  //use recipe name as key and inner hashmap as value
            }
            return recipe_array;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return recipe_array;
    }

}
