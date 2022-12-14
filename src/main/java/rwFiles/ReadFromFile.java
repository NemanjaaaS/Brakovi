package rwFiles;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class ReadFromFile {
    List<String> guysAll = new ArrayList<String>();
     List<String> girlsAll = new ArrayList<String>();

    List<String> guys = new ArrayList<String>();
     List<String> girls = new ArrayList<String>();

    List<String> guysGirls = new ArrayList<String>();

    Map<String,List<String>> guysRang = new HashMap<String, List<String>>();
    Map<String,List<String>> girlsRang = new HashMap<String, List<String>>();
    List<String> girlsGuys = new ArrayList<String>();



    public void readFromFile(String gPath,int brParova) throws IOException {
        List<String> result = new ArrayList<String>();

        File guysFile = new File(gPath);
        File girlsFile = new File(gPath);
        BufferedReader brGuys = new BufferedReader(new FileReader(guysFile));
        BufferedReader brGirls = new BufferedReader(new FileReader(girlsFile));



       // Scanner sc = new Scanner(System.in);

       // System.out.println("Unesite broj parova: ");

       // int brParova = sc.nextInt();

        System.out.println(brParova);
        int counter = 0;

        while(brGuys.ready()){
            guysAll.add(brGuys.readLine());
            girlsAll.add(brGirls.readLine());
            counter++;
        }

        for(int i = 0;i<brParova;i++){
            guys.add(guysAll.get(i));
            girls.add(girlsAll.get(i));
        }


        System.out.println("GUYS IN FUNCTION "+guys);




        for(int i = brParova;i<brParova*brParova+brParova;i++){
            guysGirls.add(guysAll.get(i));
            girlsGuys.add(girlsAll.get(i));
        }

        //System.out.println(guysAll);
        //System.out.println(girlsAll);


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
