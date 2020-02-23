package com.example.myapplication12;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

public class TextUtility {
    private ArrayList<String> myArray = new ArrayList<>();


    public void testFileFunc(){
        myArray = new ArrayList<>();
        try{
            File words = new File("/lop1v3.txt");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(words), "UTF8"));

            String str;

            while ((str = in.readLine()) != null) {
                myArray.add(str);
            }

            in.close();
        }
        catch (UnsupportedEncodingException e)
        {
            Log.e("myapp","Oshiba");
        }
        catch (IOException e)
        {
            Log.e("myapp", "2");
        }
        catch (Exception e)
        {
            Log.e("myapp","3");
        }


    }


    public void simpleArray(){
        myArray.add("кОрова");
        myArray.add("тОрты");
    }

    // ну тут лучше по-другому немного, что бы без таких циклом, а то долго
    // эта функция занимается поиском
    public String searchWord(String word){
        String result ="";
        for(int i = 0; i<myArray.size(); i++){
            if(word.toUpperCase().equals(myArray.get(i).toUpperCase())){
                result= myArray.get(i);
            }
            else{
                result = "Такого слова нет";
            }
        }
        return result;
    }

}
