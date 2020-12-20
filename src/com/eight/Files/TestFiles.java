package com.eight.Files;


import java.io.BufferedReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TestFiles {
    public static void main(String[] args){
        try {
            System.out.println(System.getProperty("user.dir"));
            Path path = Paths.get("./src/com/eight/Files/TestFiles.java");
            byte[] filesContents = Files.readAllBytes(path);
            System.out.println(new String(filesContents));

            Stream<Path> stream =  Files.find(Paths.get("./src/com/eight/Files"), 10, (path1, fileAttribute)->{
                return path1.toFile().getName().equals("TestFiles.java") ? true : false;
            });
            stream.forEach(
                    System.out::println
            );
            BufferedReader reader = Files.newBufferedReader(path);
            Stream<String> content = reader.lines();
            content.forEach(
                    System.out::println
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
