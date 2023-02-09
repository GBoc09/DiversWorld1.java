package com.example.dw_1.dao;

import java.io.*;
public class CartDAO {
    public static String[] str = new String[5];
    private static String fileName = "/Users/giuli/OneDrive/Desktop/DW_1/src/main/CartInfo.txt";
    public static String readUsingFileReader(int index) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int i =0 ;
        while ((line = br.readLine()) != null) {
            str[i] = line;
            i++;
        }
        br.close();
        fr.close();
        String selezione = str[index];
        return selezione;
    }
}
