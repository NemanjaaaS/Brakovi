package rwFiles;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class ReadFromFile {
    List<String> guysAll = new ArrayList<>();
    List<String> girlsAll = new ArrayList<>();
    List<String> paroviList = new ArrayList<>();

    List<String> guys = new ArrayList<>();
    List<String> girls = new ArrayList<>();

    List<String> guysGirls = new ArrayList<>();

    Map<String,List<String>> guysRang = new HashMap<>();
    Map<String,List<String>> girlsRang = new HashMap<>();
    List<String> girlsGuys = new ArrayList<>();



    public void readFromFile(String gPath,String girlsPath,String parovi) throws IOException {
        List<String> result = new ArrayList<String>();

        File guysFile = new File(gPath);
        File girlsFile = new File(girlsPath);
        File paroviFile = new File(parovi);
        BufferedReader brGuys = new BufferedReader(new FileReader(guysFile));
        BufferedReader brGirls = new BufferedReader(new FileReader(girlsFile));
        BufferedReader paroviBr = new BufferedReader(new FileReader(paroviFile));



        // Scanner sc = new Scanner(System.in);

        // System.out.println("Unesite broj parova: ");

        // int brParova = sc.nextInt();

        int counter = 0;

        while(brGuys.ready()){
            guysAll.add(brGuys.readLine());
            girlsAll.add(brGirls.readLine());
            counter++;
        }
        while(paroviBr.ready()){
            paroviList.add(paroviBr.readLine());
        }
        int brParova = paroviList.size()/2;

        System.out.println(brParova);

        for(int i = 0;i<brParova;i++){
            guys.add(guysAll.get(i));
            girls.add(girlsAll.get(i));
        }


        System.out.println("GUYS IN FUNCTION "+guys);




        for(int i = brParova;i<guysAll.size();i++){
            guysGirls.add(guysAll.get(i));
            girlsGuys.add(girlsAll.get(i));
        }

        System.out.println(guysAll);
        System.out.println(girlsAll);
        System.out.println(guysGirls);
        System.out.println(girlsGuys);


        int temp = 0;
        for(int i = 0;i<brParova;i++){
            guysRang.put(guys.get(i),guysGirls.subList(temp,temp+brParova));
            girlsRang.put(girls.get(i),girlsGuys.subList(temp,temp+brParova));
            temp = temp+brParova;
        }
        // System.out.println(guysRang);
        // System.out.println(girlsRang);
    }

    public List<String> getGuys(){

        return guys;
    }
    public List<String> getGirls(){
        return girls;
    }

    public Map<String,List<String>> getGuysRang(){
        return guysRang;
    }

    public Map<String,List<String>> getGirlsRang(){
        return girlsRang;
    }

}