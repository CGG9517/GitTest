package com.jiangchao;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IOTest {
    public static void main(String[] args) {
        List<String> book_urls = null;

        // 文件读取写入
        try (Scanner scanner = new Scanner(
                                new File("C:\\Users\\Jiang Chao\\Desktop\\douban\\经管.csv"),
                "utf-8");
             PrintWriter out = new PrintWriter("myfile.txt", "UTF-8");) {

            Date start = new Date();
            while (scanner.hasNextLine()) {
                out.write(scanner.nextLine() + "\r\n");
            }
            Date end = new Date();

            System.out.printf("耗时%dms", (end.getTime() - start.getTime()));


        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println();
        // 使用缓存

        try (BufferedReader bufReader = new BufferedReader(
                                        new InputStreamReader(
                                        new FileInputStream("C:\\Users\\Jiang Chao\\Desktop\\douban\\经管.csv")));
             BufferedWriter bufWriter = new BufferedWriter(
                                        new OutputStreamWriter(
                                        new FileOutputStream("经管.csv")))) {
            char[] buffer = new char[1024];
            long start = new Date().getTime();
            int readNum = 0;  // 返回值为读取到的字符个数
            while((readNum = bufReader.read(buffer)) != -1){
                bufWriter.write(buffer, 0, readNum);

                bufWriter.flush();
            }

            long end = new Date().getTime();
            bufReader.close();
            bufWriter.close();
            System.out.printf("缓冲法用时%dms", end-start);



        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
