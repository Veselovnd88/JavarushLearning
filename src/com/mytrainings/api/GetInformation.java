package com.mytrainings.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.learning.javarush.st2.DebugTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class GetInformation {

    private String link = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
    private String result;

    public String getInfo(){
        if (result==null){

        try{
            URL obj = new URL(this.link);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

            conn.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String input;
            StringBuilder sb = new StringBuilder();
            while(br.ready()){
                sb.append(br.readLine());
        } result = sb.toString();}
        catch (MalformedURLException  e){
            e.printStackTrace();

            System.out.println("Что-то не так со ссылкой");

        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Что-то пошло не так");
        }
        }

        //System.out.println(sb.toString());
        return result;
    }

    public Image getImageObj() {

        ObjectMapper om = new ObjectMapper();
        try{
        Image ob = om.readValue(getInfo(), Image.class);
            return ob;}
        catch (IllegalArgumentException | JsonProcessingException e){
            System.out.println("Не удалось открыть ссылку");
            e.printStackTrace();
            }
        return null;



    }






}
