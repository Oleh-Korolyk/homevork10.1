package org.example.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static void main(String[] args)  {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<User> users =  new ArrayList<>();

            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("fileNameAge.txt"));
                String textLine;
                boolean isHeaderLine = true;

                for (int i = 0; (textLine = bufferedReader.readLine()) != null; i++) {
                    if (isHeaderLine) {
                        isHeaderLine = false;
                    } else {
                        String[] text = textLine.split(" ");
                        users.add(new User(text[0], Integer.valueOf(text[1])));
                    }
                }

                List<String> userJson = new ArrayList<>();

                for (int i = 0; i < users.size(); i++) {
                    userJson.add(gson.toJson(users.get(i)));
                }

                FileWriter nFile = new FileWriter("user.json");
                nFile.write(userJson.toString());
                nFile.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
