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

                //HashMap<String, String> instructions = new HashMap<>();      //inner hashmap

                String instruction_name = instruction[0];                             //get the recipe's name
                instruction_array.put(instruction[0], instruction[1]);
                /*
                for (int i = 1; i < instruction.length; i++) {                   //split up ingredients and amounts
                    //System.out.println(item);
                    String[] temp = instruction[i].split("-");
                    //System.out.println(Arrays.toString(temp));
                    String step = temp[0];
                    String instruct = temp[1];

                   instructions.put(step, instruct);                          //place ingredients and amounts as key and value in inner hashmap
                }

                instruction_array.put(instruction_name, instructions);                  //use recipe name as key and inner hashmap as value
                //System.out.println(instruction_array.get(instruction_name));

                //for (String i : instructions.keySet()) {
                //    System.out.println("step: " + i + " instruction: " + instructions.get(i));
                //}


            }

                 */



            }
            return instruction_array;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return instruction_array;}
}
