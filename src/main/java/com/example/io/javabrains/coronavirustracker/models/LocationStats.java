package com.example.io.javabrains.coronavirustracker.models;

public class LocationStats {
    private  String State;
    private String country;
    private String latestTotalCases;

    public String getNew_cases() {
        return new_cases;
    }

    public void setNew_cases(String new_cases) {
        this.new_cases = new_cases;
    }

    private String new_cases;

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return country;
    }

    public String setCountry(String country) {
        this.country = country;
        return country;
    }

    public String getLatestTotalCases() {
        return latestTotalCases;
    }

    public void setLatestTotalCases(String latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "State='" + State + '\'' +
                ", country='" + country + '\'' +
                ", newCases='" + new_cases + '\'' +
                ", latestTotalCases=" + latestTotalCases +
                '}';
    }
}
