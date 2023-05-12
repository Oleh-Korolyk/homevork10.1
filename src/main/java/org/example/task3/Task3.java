package org.example.task3;

import java.io.*;
import java.util.ArrayList;

public class Task3 {

    public static String sortedCountWords(File file) throws IOException  {

        StringBuilder stringBuilder = new StringBuilder();
        String text;
        ArrayList<String> wordsList = new ArrayList<>();
        ArrayList<Word> words1 = new ArrayList<>();


        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while ((text = bufferedReader.readLine()) != null) {
            stringBuilder.append(text + " ");
        }
        String[] words = stringBuilder.toString().split(" ");
        for (String word: words) {
            if(!word.isEmpty()) {
                wordsList.add(word);
            }
        }

        ArrayList<String> repetition = new ArrayList<>();

        for (String wordList: wordsList) {
            int a = 0;
            for (String word: words) {
                if(wordList.equals(word)) {
                    a++;
                }
            }
            if(!repetition.contains(wordList)) {
                words1.add(new Word(wordList, a));
                repetition.add(wordList);
            }
        }
        StringBuilder result = new StringBuilder();
        Word[] words2 = new Word[words1.size()];
        for (int i = 0; i < words2.length; i++) {
            words2[i] = words1.get(0);
            for (Word w1: words1){
                if (w1.getCount() > words2[i].getCount()) {
                    words2[i] = w1;
                }
            }
            for (Word w1: words1){
                if (words2[i].equals(w1)) {
                    words1.remove(w1);
                    break;
                }
            }
            result.append(words2[i].getName() + " " + words2[i].getCount() + "\n");
        }
        return result.toString();
    }


    public static void main(String[] args) throws IOException {

        File file = new File("words.txt");
        System.out.println(sortedCountWords(file));

    }
}
