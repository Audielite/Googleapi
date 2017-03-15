package com.lex;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;
import javafx.scene.control.TextInputControl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alexishennings on 3/1/17.
 */
public class Goog {
    static Scanner stringScanner = new Scanner(System.in);
    //static Scanner numberScanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // write your code here
        String key = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("KEY2.txt"))) {
            key = reader.readLine();
            //System.out.println(key);
        } catch (Exception ioe) {
            System.out.println("No key found");
            System.exit(-1);
        }

        System.out.println("What location would you like to find? ");
        String location = stringScanner.nextLine();

        GeoApiContext context = new GeoApiContext().setApiKey(key);
        GeocodingResult[] results = GeocodingApi.geocode(context,
                location).await();

        if (results.length > 1) {
            for (int i = 0; i < results.length; i++) {
                System.out.println(i + " " + results[i].formattedAddress);
            }

           // System.out.println();
          //  System.out.println("Which number would you like? ");
            ArrayList<Integer> city = new ArrayList<Integer>();
            //int city = numberScanner.nextInt();

            // dont forget to use this Geometry.location;
        }


    }
}