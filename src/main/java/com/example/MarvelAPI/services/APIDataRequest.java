package com.example.MarvelAPI.services;

import com.example.MarvelAPI.repository.ICharacterRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class APIDataRequest {

    public static Connection ConnectToDB() throws Exception {
        //Registering the Driver
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://localhost:3306/marvelApi";

        Connection databaseCon = DriverManager.getConnection(mysqlUrl, "root", "12345678");
        System.out.println("Connection established......");
        return databaseCon;
    }

    HttpURLConnection conn;

    URL url = new URL("http://gateway.marvel.com/v1/public/characters?limit=100&ts=1&apikey=89c9ab3aca2e0160d0feaae4b3527845&hash=a974f8a431e9a8d6c922b5e68234d21e");

    public APIDataRequest() throws MalformedURLException {
    }

    @Autowired
    ICharacterRepository repository;

    public JSONArray getAPI() throws Exception {

        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {

            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }

            //Close the scanner
            scanner.close();

            //Using the JSON simple library parse the string into a json object
            JSONParser parse = new JSONParser();
            JSONObject data_obj = (JSONObject) parse.parse(inline);
            JSONObject obj = (JSONObject) data_obj.get("data");
            JSONArray jsonArray = (JSONArray) obj.get("results");
            return jsonArray;

//            JSONObject works = (JSONObject) jsonArray.get(6);
//            System.out.println(works);
//            System.out.println(works.get("name"));
//            System.out.println(works.get("id"));
//            System.out.println(jsonArray);

//            Connection databaseCon = ConnectToDB();
////            PreparedStatement pstmt = databaseCon.prepareStatement("INSERT INTO Character values (?, ?, ?, ? )");
//            PreparedStatement pstmt = databaseCon.prepareStatement("INSERT INTO marvelAPI.Character(id, name, description, thumbnail) VALUES (?, ?, ?, ?)");

        }

    }

}
