package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Task1 {

    public static void main(String[] args) throws IOException {
        File file = new File("filePhoneNumber.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String phoneNumber;
        Pattern pattern = Pattern.compile("^\\(\\d{3}\\) \\d{3}-\\d{4}$|^\\d{3}-\\d{3}-\\d{4}$");
        while ((phoneNumber = bufferedReader.readLine()) != null) {
            Matcher matcher = pattern.matcher(phoneNumber);
            if (matcher.matches()) {
                System.out.println(phoneNumber);
            }
        }
    }

}
