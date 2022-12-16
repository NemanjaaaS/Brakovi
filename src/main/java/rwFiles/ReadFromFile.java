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
        File guysFile = new File(gPath);
        File girlsFile = new File(girlsPath);
        File paroviFile = new File(parovi);
        BufferedReader brGuys = new BufferedReader(new FileReader(guysFile));
        BufferedReader brGirls = new BufferedReader(new FileReader(girlsFile));
        BufferedReader paroviBr = new BufferedReader(new FileReader(paroviFile));

        while(brGuys.ready()){
            guysAll.add(brGuys.readLine());
            girlsAll.add(brGirls.readLine());

        }
        while(paroviBr.ready()){
            paroviList.add(paroviBr.readLine());
        }
        int brParova = paroviList.size()/2;

        for(int i = 0;i<brParova;i++){
            guys.add(paroviList.get(i));
        }
        for(int i = brParova;i<paroviList.size();i++){
            girls.add(paroviList.get(i));
        }

        for(int i = brParova;i<guysAll.size();i++){
            guysGirls.add(guysAll.get(i));
            girlsGuys.add(girlsAll.get(i));
        }

        int temp = 0;
        for(int i = 0;i<brParova;i++){
            guysRang.put(guys.get(i),guysGirls.subList(temp,temp+brParova));
            girlsRang.put(girls.get(i),girlsGuys.subList(temp,temp+brParova));
            temp = temp+brParova;
        }
    }
    public List<String> getGuys(){return guys;}
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