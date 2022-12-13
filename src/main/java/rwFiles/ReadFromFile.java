package rwFiles;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class ReadFromFile {

    public Map<String,List<String>> readFromFile(String guysPath,int brParova) throws IOException {
        List<String> result = new ArrayList<String>();

        File guysFile = new File(guysPath);
        //File girlsFile = new File(girlsPath);
        BufferedReader brGuys = new BufferedReader(new FileReader(guysFile));
       // BufferedReader brGirls = new BufferedReader(new FileReader(girlsFile));

        List<String> guysAll = new ArrayList<String>();
       // List<String> girlsAll = new ArrayList<String>();

        List<String> guys = new ArrayList<String>();
       // List<String> girls = new ArrayList<String>();

        List<String> guysGirls = new ArrayList<String>();
       // List<String> girlsGuys = new ArrayList<String>();



        Map<String,List<String>> guysRang = new HashMap<String, List<String>>();
       // Map<String,List<String>> girlsRang = new HashMap<String, List<String>>();

       // Scanner sc = new Scanner(System.in);

       // System.out.println("Unesite broj parova: ");

       // int brParova = sc.nextInt();

        System.out.println(brParova);
        int counter = 0;

        while(brGuys.ready()){
            guysAll.add(brGuys.readLine());
           // girlsAll.add(brGirls.readLine());
            counter++;
        }
        int c = 0;
        while(c<brParova){
            guys.add(guysAll.get(c));
            //girls.add(girlsAll.get(c));
            c++;
        }

        for(int i = brParova;i<brParova*brParova+brParova;i++){
            guysGirls.add(guysAll.get(i));
           // girlsGuys.add(girlsAll.get(i));
        }

        //System.out.println(guysAll);
        //System.out.println(girlsAll);


int temp = 0;
        for(int i = 0;i<brParova;i++){
            guysRang.put(guys.get(i),guysGirls.subList(temp,temp+brParova));
           // girlsRang.put(girls.get(i),girlsGuys.subList(temp,temp+brParova));
            temp = temp+brParova;
        }

       // System.out.println(guysRang);
       // System.out.println(girlsRang);

        return guysRang;
    }

}
