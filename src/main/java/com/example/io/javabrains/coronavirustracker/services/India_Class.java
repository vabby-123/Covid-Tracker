package com.example.io.javabrains.coronavirustracker.services;

public class India_Class {


    public static void main(String[] args)
    {
        India_Class Ind=new India_Class();

    }
    static String India_data(String today)
    {   String s="Low";
        System.out.println("found");
        if(Double.parseDouble(today)>15000)
        {
            s="High Chances bro";

        }


        return s;


    }

}
