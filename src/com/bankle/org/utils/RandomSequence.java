package com.bankle.org.utils;


import java.io.*;
import java.util.Random;

public class RandomSequence {
    public static final int MAX20 = 1<<20;
    private static Random random = new Random();

    public static int[] retrieveSequence() {
        String path = "/home/lyf/Desktop/temp";
        String fileName = "sequence.txt";
        File file = new File(path, fileName);
        int[] s1 = new int[MAX20];

        int size =0;
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);


            String read;
            while ((read = br.readLine()) !=null) {
                int num = Integer.parseInt(read);
                int index = size++;
                s1[index] =num ;
            }

            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s1;

    }

    public static void generateSequence() {
        String path = "/home/lyf/Desktop/temp";
        String fileName = "sequence.txt";
        File file = new File(path, fileName);

        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);


            for(int i=0; i< MAX20; i++) {
                int temp = random.nextInt(MAX20);
                bw.write(temp+"\r");
            }

            bw.close();
            osw.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
