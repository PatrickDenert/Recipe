package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class InstructionReader {
    public static HashMap main(String args) {
        String path = "insert path to instruction file";      //path to file
        String line = "";

        HashMap<String, String> instruction_array = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            instruction_array = new HashMap<>();

            while ((line = br.readLine()) != null) {                        //read recipe file
                String[] instruction = line.split(";");                    //split up recipes
             
                String instruction_name = instruction[0];                             //get the recipe's name
                instruction_array.put(instruction[0], instruction[1]);
                
            }
            return instruction_array;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return instruction_array;}
}
