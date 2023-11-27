package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "c:\\temp\\";

        String[] list = new String[] {"Oi", "Tudo bem?", "Tchau!"};

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for(String str : list){
                bw.write(str);
                bw.newLine();
            }
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}