package edu.esilv.gilded;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class json {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            FileReader file = new FileReader("jsn.txt");
            List<Item> myObjects = mapper.readValue(file, new TypeReference<List<Item>>(){});
            System.out.println("myObjects = " + myObjects);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}