package org.example;

import rwFiles.ReadFromFile;
import stableMarriage.StableMarriage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String guysPath = "src/main/java/files/guysRang.txt";
        String girlsPath = "src/main/java/files/girlsRang.txt";
        String result = "src/main/java/files/result.txt";
        String parovi = "src/main/java/files/guysAndGirls.txt";
        Scanner sc = new Scanner(System.in);

        //System.out.println("Unesite broj parova: ");

        //int brParova = sc.nextInt();


        ReadFromFile rf = new ReadFromFile();
       // ReadFromFile rf2 = new ReadFromFile();
        rf.readFromFile(guysPath,girlsPath,parovi);

        // System.out.println("GUYS RANG "+rf.getGuysRang());
       // rf2.readFromFile(girlsPath,brParova);

        // System.out.println("GIRLS RANG "+rf2.getGirlsRang());
        // System.out.println("GUYS print "+rf.getGuys());
        StableMarriage st = new StableMarriage();
        BufferedWriter bw = new BufferedWriter(new FileWriter(result));

        Map<String, String> matches = st.match(rf.getGuys(), rf.getGuysRang(), rf.getGirlsRang());
        for(Map.Entry<String, String> couple:matches.entrySet()){
            System.out.println(
                    couple.getKey() + " is engaged to " + couple.getValue());
            System.out.println(couple);
            bw.write(""+couple.getValue()+","+couple.getKey()+"\n");
        }

        if(st.checkMatches(rf.getGuys(), rf.getGirls(), matches, rf.getGuysRang(),rf.getGirlsRang())){
            System.out.println("Marriages are stable");
            bw.write("Marriages are stable");
        }else{
            System.out.println("Marriages are unstable");
            bw.write("Marriages are unstable");
        }
        bw.close();
//        String tmp = matches.get(rf2.getGirls().get(0));
//        matches.put(rf2.getGirls().get(0), matches.get(rf2.getGirls().get(1)));
//        matches.put(rf2.getGirls().get(1), tmp);
//        System.out.println(
//                rf2.getGirls().get(0) +" and " + rf2.getGirls().get(1) + " have switched partners");
//        if(st.checkMatches(rf.getGuys(), rf2.getGirls(), matches, rf.getGuysRang(),rf2.getGirlsRang())){
//            System.out.println("Marriages are stable");
//        }else{
//            System.out.println("Marriages are unstable");
//        }

    }
}