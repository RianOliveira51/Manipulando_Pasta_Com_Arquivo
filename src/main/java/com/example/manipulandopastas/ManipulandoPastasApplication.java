package com.example.manipulandopastas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class ManipulandoPastasApplication {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      //indicando caminho da pasta,
        System.out.println("Enter a folder path");
        String strPath = sc.nextLine();

        //File pode ser tanto o caminho de um arquivo, quanto de uma pasta.
        File path = new File(strPath);

        //Pegando todas as pastas a partir desse caminho informado.
        //File::isDIrectory vai trazer apenas diretorios.
        File[] folders = path.listFiles(File::isDirectory);

        System.out.println("FOLDERS:");
        for(File folder : folders){
            System.out.println(folder);
        }


        //Pegando todos os arquivos a partir desse caminho informado.
        File[] files = path.listFiles(File::isFile);
        System.out.println("FILES:");
        for(File file : files){
            System.out.println(file);
        }

        //Criando sub-Pasta a partir do caminho informado.
        // true = criado subcom sucesso/ false = não criado subpasta.
        boolean sucess = new File(strPath + "\\subdir").mkdir();
        System.out.println("Directory created sucessfully: " + sucess);
      sc.close();
    }

}
