package org.github.copilotx.copilotx.api;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelloResource {
    public String hello() {
        return "Hello World!";
    }

    public void calculateDaysBetweenDates(Date startDate, Date endDate) {
        long diff = endDate.getTime() - startDate.getTime();
        long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        System.out.println("Days between dates: " + days);
    }

    // call rest api using HttpsURLConnection and return response
    public void restApiCall(String url) {
        try {
            URL obj = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            //add request header
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //print result
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // quick sort
    public List<Integer> quickSort(List<Integer> integers) {
        if (integers.size() <= 1) {
            return integers;
        }
        int pivot = integers.get(0);
        List<Integer> less = new ArrayList<Integer>();
        List<Integer> greater = new ArrayList<Integer>();
        for (int i = 1; i < integers.size(); i++) {
            if (integers.get(i) <= pivot) {
                less.add(integers.get(i));
            } else {
                greater.add(integers.get(i));
            }
        }
        List<Integer> sorted = new ArrayList<Integer>();
        sorted.addAll(quickSort(less));
        sorted.add(pivot);
        sorted.addAll(quickSort(greater));
        return sorted;
    }
    // list of 100 random integers
    public List<Integer> randomIntegers() {
        List<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            integers.add((int) (Math.random() * 100));
        }
        return integers;
    }
    // array of 100 random strings
    public String[] randomStrings() {
        String[] strings = new String[100];
        for (int i = 0; i < 100; i++) {
            strings[i] = "String " + (int) (Math.random() * 100);
        }
        return strings;
    }
}
