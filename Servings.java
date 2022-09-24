package com.company;

import java.util.HashMap;

public class Servings {
    public static HashMap main(HashMap recipe_array, int servings) {
        HashMap<Object, String> new_recipe_array = new HashMap<>();

        float old_servings = 0;
        for (Object i : recipe_array.keySet()) {
            if (i == "servings") {
                old_servings = Integer.parseInt((String) recipe_array.get(i));
            }

        }

        for (Object i : recipe_array.keySet()) {
            if (i != "servings") {
                String ingredient = String.valueOf(recipe_array.get(i));
                String[] parts = ingredient.split(" ");

                float new_measurement = Float.parseFloat(parts[1]) * (servings/old_servings);
                new_recipe_array.put(i, " " + String.valueOf(new_measurement) + " " + parts[2]);
            }
        }
        return new_recipe_array;
    }
}
