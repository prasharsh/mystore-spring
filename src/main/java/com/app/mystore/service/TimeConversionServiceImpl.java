package com.app.mystore.service;

import org.springframework.stereotype.Service;
/*
credit : Anant Agarwal
article author : Rahul singh
web source : https://www.geeksforgeeks.org/program-convert-time-12-hour-24-hour-format/
This code has been modified to meet the requirement of the time format conversion.
Code has been used for educational purposes only encouraging existing component re-usability.
 */
@Service("TimeFormatConversionService")
public class TimeConversionServiceImpl implements TimeConversionService {
    @Override
    public String convertto24HourFormat(String timeIn12hourFormat) {
        // Get hours
        int h1 = (int)timeIn12hourFormat.charAt(1) - '0';
        int h2 = (int)timeIn12hourFormat.charAt(0) - '0';
        int hh = (h2 * 10 + h1 % 10);
        String timings = new String();
        // If time is in "AM"
        if (timeIn12hourFormat.charAt(8) == 'A')
        {
            if (hh == 12)
            {
                System.out.print("00");
                timings = "00";
                for (int i = 2; i <= 7; i++) {
                    timings = timings + timeIn12hourFormat.charAt(i);
                }

            }
            else
            {
                for (int i = 0; i <= 7; i++) {
                    timings = timings + timeIn12hourFormat.charAt(i);
                }
            }
        }

        // If time is in "PM"
        else
        {
            if (hh == 12)
            {
                System.out.print("12");
                timings = "12";
                for (int i = 2; i <= 7; i++){
                    timings = timings + timeIn12hourFormat.charAt(i);
                }

            }
            else
            {
                hh = hh + 12;
                System.out.print(hh);
                timings = String.valueOf(hh);
                for (int i = 2; i <= 7; i++)
                    timings = timings + timeIn12hourFormat.charAt(i);
            }
        }
        return timings;
    }
}
