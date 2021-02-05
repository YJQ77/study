package com.example.basic.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * Author: YinJiaqi
 * Date: 9/14/2020 4:17 PM
 * Content:
 */
public class io {
    public static void main(String[] args) {
        File file = new File("G:\\qqq.txt");
        FileInputStream stream = null;
        FileOutputStream stream1 = null;
        try {
            stream = new FileInputStream(file);
            stream1 = new FileOutputStream(file);
            InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
            OutputStreamWriter writer = new OutputStreamWriter(stream1, "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            BufferedWriter bw = new BufferedWriter(writer);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            br.close();

//            for (int i = 0;i<10;i++){
//                String s ="你好啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊"+i;
//                bw.write(s);
//                bw.newLine();
//            }
//            bw.flush();
//            bw.close();
//            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                    stream = null;
                }
                if (stream1 != null) {
                    stream1.close();
                    stream1 = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
