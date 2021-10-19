package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


/**
 * This class contains all of the methods required to take a url in and return the value of the element with
 * property=name
 */
public class Scraper {

    /**
     * This method takes a url, and attempts to scrape the html from said url by creating a connection to that URL
     * and then reading the html line by line into a string.
     * If that line of html contains property=name then we can use the index of that in the string to find the full
     * name of the user by finding the index of the closing braces around the value.
     * Once we have this value we can return it, otherwise we return a string FAILED.
     *
     * @param URLin the url that we are connecting to, and scraping the html of
     * @return the full name from the property=name element, if none was found then it will always return FAILED
     */

    public String scrapeNameFromURL(String URLin) {

        String name = "FAILED";

        try {

            URL URL = new URL(URLin);

            InputStreamReader isr = new InputStreamReader(URL.openStream());

            BufferedReader br = new BufferedReader(isr);

            String html = null;

            while ((html = br.readLine()) != null) {
                if (html.contains("property=\"name\"")) {
                    int index = html.indexOf("property=\"name\"");
                    // Find the index of the two braces around the value of the name
                    index = html.indexOf('>', index);
                    int endIndex = html.indexOf('<', index);
                    // Use the two indexes to pull the name out from the raw html
                    name = html.substring(index + 1, endIndex);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return name;

    }
}
