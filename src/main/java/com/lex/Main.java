package com.lex;
import com.google.maps.ElevationApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.ElevationResult;
import com.google.maps.model.LatLng;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args)throws Exception {
        // write your code here
        String key = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("KEY.txt"))){
            key = reader.readLine();
            System.out.println(key);
        }catch (Exception ioe) {
            System.out.println("No key found");
            System.exit(-1);
        }

        GeoApiContext context = new GeoApiContext().setApiKey(key);

        LatLng mctcLatLng = new LatLng(44.973074, -93.283356);

        ElevationResult[] results = ElevationApi.getByPoints(context, mctcLatLng).await();

        if (results.length >= 1) {
            ElevationResult mctcElevation = results[0];
            System.out.println("The elevation of MCTC above sea level is " + mctcElevation.elevation + " meters");
            System.out.println(String.format("The elevation of MCTC above sea level is %.2f meters", mctcElevation.elevation));
        }


    }
}