package com.bawie.zk.newfiles;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
public class NewFileClass {


    public static String getStrings(String urlString) {

        try {
            //获取路径和地址
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //返回一个码进行判断是否成功
            int code = urlConnection.getResponseCode();
            if(code==200){
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String q1="";
                String q2="";
                while ((q1=reader.readLine())!=null){
                    q2+=q1;
                }
                return q2;

            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
