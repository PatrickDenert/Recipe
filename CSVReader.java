package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap; // import the HashMap class



public class CSVReader {
    public static void main(String args) {
        String path = "path";      //path to file
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            HashMap<String, HashMap<String, String>> recipe_array = new HashMap<>();        //2d hashmap to hold recipes

            while ((line = br.readLine()) != null) {                        //read recipe file
                String[] recipe = line.split(",");                    //split up recipes

                HashMap<String, String> ingredients = new HashMap<>();      //inner hashmap

                String recipe_name = recipe[0];                             //get the recipe's name

                for (int i = 1; i < recipe.length; i++) {                   //split up ingredients and amounts
                    
                    String[] temp = recipe[i].split(":");
                    
                    String item = temp[0];
                    String amount = temp[1];
                    ingredients.put(item, amount);                          //place ingredients and amounts as key and value in inner hasmap
                }

                recipe_array.put(recipe_name,ingredients);                  //use recipe name as key and inner hashmap as value
                System.out.println(recipe_array.get(recipe_name));

                for (String i : ingredients.keySet()) {
                    System.out.println("ingredient: " + i + " amount: " + ingredients.get(i));
                }
                

            }

           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
