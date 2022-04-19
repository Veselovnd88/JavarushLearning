package com.mytrainings.api;

public class APIDriver {
    public static void main(String[] args) {

        GetInformation myObj = new GetInformation();
        try{
        Image im = myObj.getImageObj();
            System.out.println(im.getTitle());
            System.out.println(im.getCopyright());
            System.out.println(im.getUrl());
        }

        catch (Exception e){
            e.printStackTrace();
            }
    }
}
