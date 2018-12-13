package edu.esilv.gilded;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class json {

    public static Item[] jsonrecup(String fichier) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            FileReader file = new FileReader(fichier);
            Item[] myObjects = mapper.readValue(file, Item[].class);
            for (int i = 0; i < myObjects.length; i++) {
                myObjects[i].date = LocalDateTime.now();
            }
            return myObjects;
        } catch (IOException e) {
            e.printStackTrace();

        }
        return (null);
    }
}
