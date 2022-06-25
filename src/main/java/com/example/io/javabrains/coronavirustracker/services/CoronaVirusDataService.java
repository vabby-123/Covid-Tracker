package com.example.io.javabrains.coronavirustracker.services;
import com.example.io.javabrains.coronavirustracker.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


@Service
public class CoronaVirusDataService {
    private static String VIRUS_DATA_URL ="https://raw.githubusercontent.com/owid/covid-19-data/master/public/data/latest/owid-covid-latest.csv";

    public List<LocationStats> getAllStats() {
        return allStats;
    }

    private List<LocationStats>  allStats= new ArrayList<>();


    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchVirusData() throws IOException, InterruptedException {
        List<LocationStats> newStats=new ArrayList<>();
        HttpClient client =HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder()
        .uri(URI.create(VIRUS_DATA_URL ))
        .build();
       HttpResponse<String> httpResponse= (HttpResponse<String>) client.send(request, HttpResponse.BodyHandlers.ofString());


        //using Header auto detection since header is there in first line itself
        StringReader in = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);


        for (CSVRecord record : records) {
            LocationStats locationStats=new LocationStats();
            locationStats.setState(record.get("continent"));
            locationStats.setCountry(record.get("location"));
            locationStats.setLatestTotalCases(record.get("total_cases"));
            locationStats.setNew_cases((record.get("new_cases")));




            System.out.println(locationStats);
            newStats.add(locationStats);

            String s = record.get("location");
            String ss = "India";
            if (ss.equals(s)) {
                String today= record.get("new_cases");
              India_Class.India_data(today);
            }
        }


        this.allStats=newStats;



        }




    }

