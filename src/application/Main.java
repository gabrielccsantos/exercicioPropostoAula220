package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\biels\\IdeaProjects";

        //Clica com o direito na sua pasta de arquivos de programas e libera a permissao
        //pra qualquer usuario poder ler escrecer e editar

        String[] list = new String[] {"Oi", "Tudo bem?", "Tchau!"};

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for(String str : list){
                bw.write(str);
                bw.newLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }
}