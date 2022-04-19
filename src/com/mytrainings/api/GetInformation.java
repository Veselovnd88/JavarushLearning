package com.mytrainings.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.learning.javarush.st2.DebugTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetInformation {

    private String link = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
    private String result;

    public String getInfo() throws IOException {
        if (result!=null){
        URL obj = new URL(this.link);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String input;
        StringBuilder sb = new StringBuilder();
        while(br.ready()){
            sb.append(br.readLine());
        } result = sb.toString();
        }

        //System.out.println(sb.toString());
        return result;
    }

    public Image getImageObj() throws IOException {

        ObjectMapper om = new ObjectMapper();
        Image ob = om.readValue(getInfo(), Image.class);

        return ob;

    }






}
