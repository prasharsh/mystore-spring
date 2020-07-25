
package com.app.mystore.service.scheduleGenerationAPIHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/*
 Author: Parth Panchal
 B00845025
 The class file uses the self-customized Nurse Scheduling Algorithm avail by Google for scheduling employees.
 The Algorithm has been customized and deployed on Google Cloud Run and accessed using the deployed Endpoint.
 Credit : Google developers

 Source of Nurse Scheduling Algorithm : https://developers.google.com/optimization/scheduling/employee_scheduling
 For reason of coomponent reusability and adhere to avoid reinveting the wheel the algorithm provided by google in python has been
 customized as per problem requirement and deployed on container registry as microservice.
 The deployed endpoint of algorithm : https://crewschedulingalgo-n7i4rbxkiq-uc.a.run.app on GCP Cloud
 * */
@Service("InvokeCrewScheduling")
public class InitiateAPIRequestImpl implements InitiateAPIRequest {
    @Override
    public String returnScheduleSuggestions(ArrayList<ArrayList<ArrayList<Integer>>> data) {
        int length = data.size();
        String collectOuput="";
        try {

            URL url = new URL("https://crewschedulingalgo-n7i4rbxkiq-uc.a.run.app");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            System.out.println("length : "+length);
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();

            Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            String prettyJson = prettyGson.toJson(data);
            System.out.println(prettyJson);

            String num_nurses = "5";

            String input = "{\n" +
                    "\t\"num_nurses\":"+String.valueOf(length)+",\n" +
                    "\t\"num_shifts\":\"4\",\n" +
                    "\t\"num_days\":\"7\",\n" +
                    "    \"shift_requests\":" +prettyJson+
                    "\n" +
                    "}";
            System.out.println("API Input");
            System.out.println(input);
            System.out.println("Length 1: "+data.get(0).size());
            System.out.println("Length 2: "+data.get(1).size());
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                collectOuput+=output;
            }
            collectOuput = collectOuput.replaceAll("\\s+", "");
            //System.out.println(collectOuput);
            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return collectOuput;
    }
}
