package org.example;

import rwFiles.ReadFromFile;
import stableMarriage.StableMarriage;
import workerThread.WorkerThread;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static final int MAX_TH = 3;
    public static void main(String[] args) throws IOException {

        String guysPath = "src/main/java/files/guysRang.txt";
        String girlsPath = "src/main/java/files/girlsRang.txt";
        String result = "src/main/java/files/result.txt";
        String parovi = "src/main/java/files/guysAndGirls.txt";

        String guysPath2 = "src/main/java/files/guysRang2.txt";
        String girlsPath2 = "src/main/java/files/girlsRang2.txt";
        String parovi2 = "src/main/java/files/guysAndGirls2.txt";

        String guysPath3 = "src/main/java/files/guysRang3.txt";
        String girlsPath3 = "src/main/java/files/girlsRang3.txt";
        String parovi3 = "src/main/java/files/guysAndGirls3.txt";



        Runnable rb1 = new WorkerThread(guysPath,girlsPath,parovi,result);
        Runnable rb2 = new WorkerThread(guysPath2,girlsPath2,parovi2,result);
        Runnable rb3 = new WorkerThread(guysPath3,girlsPath3,parovi3,result);

        ExecutorService pl = Executors.newFixedThreadPool(MAX_TH);

        pl.execute(rb1);
        pl.execute(rb2);
        pl.execute(rb3);

        pl.shutdown();

    }
}