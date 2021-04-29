package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Phonebook {
    public void exportPhonebook(Map<String, String> contacts, String output) {
        validateParams(contacts,output);
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(output))){
            for (Map.Entry<String,String> entry : contacts.entrySet()) {
                bw.write(entry.getKey()+": " +entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validateParams(Map<String, String> contacts, String output) {
        if(contacts == null) {
            throw new IllegalArgumentException("Contact must not null!");
        }
        if (output == null || output.isBlank()) {
            throw new IllegalArgumentException("Filename must not null or empty string!");
        }
    }
}

