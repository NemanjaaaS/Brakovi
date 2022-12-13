package org.example;

import rwFiles.ReadFromFile;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String guysPath = "src/main/java/files/guys.txt";
        String girlsPath = "src/main/java/files/girls.txt";
        Scanner sc = new Scanner(System.in);

        System.out.println("Unesite broj parova: ");

        int brParova = sc.nextInt();

        ReadFromFile rf = new ReadFromFile();
        System.out.println("GUYS RANG "+rf.readFromFile(guysPath,brParova));
        System.out.println("GIRLS RANG "+rf.readFromFile(girlsPath,brParova));
    }
}