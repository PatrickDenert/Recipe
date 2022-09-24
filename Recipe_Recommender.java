package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Recipe_Recommender {
    public static HashMap<Object, HashMap<String, String>> main(HashMap recipe_array){
        System.out.println("Welcome to the Recipe Recommender, please input any ingredients you have in order to filter out recipes based on what you already have");

        int input = 1;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        ArrayList<String> ingredients = new ArrayList<String>(); // Create an ArrayList object

        while (input == 1){
            System.out.println("What is the next ingredient (if no more ingredients press enter)? ");
            String ingredient = myObj.nextLine();

            if (ingredient == ""){
                input = 0;
                break;
            }

            ingredients.add(ingredient);


        }
        int add = 1;
        HashMap<Object, HashMap<String, String>> new_hashmap = new HashMap<>();

        for (Object i : recipe_array.keySet()) {
            HashMap<String,String> temp= (HashMap<String, String>) recipe_array.get(i);
            add = 1;
            for (String j : temp.keySet()) {
                if(!ingredients.contains(j) && !Objects.equals(j, "servings")){
                    add = 0;
                    break;
                }

            }

            if (add == 1){
                new_hashmap.put(i,temp);
            }
        }
        return new_hashmap;
    }
}
