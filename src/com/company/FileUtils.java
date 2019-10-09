package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static void readAllLines() {
        String fileName = "data.txt";
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeAllLines(){
        List<String> lines = new ArrayList<>();//if it is an array or something that isn't a list
        lines.add("I want to save");
        lines.add("... this data.");
        lines.add("So I'm writing some lines of stuff.");

        try {
            Path path = Paths.get("./savedData.txt");
            Files.write(path, lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeObject(Object o, String filename){
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(filename, false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(o);
            objectOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Object readObject(String fileName){
        ObjectInputStream objectinputstream = null;
        Object o = null;
        try {
            FileInputStream streamIn = new FileInputStream(fileName);
            objectinputstream = new ObjectInputStream(streamIn);
            o = (Object) objectinputstream.readObject();
            objectinputstream .close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}