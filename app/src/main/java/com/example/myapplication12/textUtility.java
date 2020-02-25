package com.example.myapplication12;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class textUtility {
    private ArrayList<String> myArray = new ArrayList<>();

    public void testFileFunc(Context ctx){
        myArray = new ArrayList<>();
        InputStream inputStream = ctx.getResources().openRawResource(R.raw.lop1v3);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader in = new BufferedReader(inputStreamReader);

        try{
            String str;

            while ((str = in.readLine()) != null) {
                myArray.add(str);

            }

        }
        catch (UnsupportedEncodingException e)
        {
            Log.e("myapp","Oshibka");
        }
        catch (IOException e)
        {
            Log.e("myapp", "IOException");
        }
        catch (Exception e)
        {
            Log.e("myapp","3");
        }
    }
    public String searchWord(String word){
        String result ="";

        for(int i = 0; i<myArray.size(); i++){
            String slovo = (myArray.get(i)).toUpperCase();
            if((word.toUpperCase()).equals(slovo)){
                Log.i("myApp", slovo);
                result= myArray.get(i);
                break;
            }
            else{
                result = "Такого слова нет";
            }
        }
        return result;
    }
    }

