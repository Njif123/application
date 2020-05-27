package com.example.myapplication12;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class textUtility {
    ArrayAdapter adapter;
    public ArrayList<String> myArray = new ArrayList<>();
    //чтение из файла
    public void testFileFunc(Context ctx){
        myArray = new ArrayList<>();
        InputStream inputStream = ctx.getResources().openRawResource(R.raw.lop1v4);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader in = new BufferedReader(inputStreamReader);

        try{
            String str;

            while ((str = in.readLine()) != null) {
                if(!str.isEmpty())
                myArray.add(str);

            }

        }
        catch (UnsupportedEncodingException e)
        {
            Log.e("myapp","UnsupportedEncodingException");
        }
        catch (IOException e)
        {
            Log.e("myapp", "IOException");
        }
        catch (Exception e)
        {
            Log.e("myapp","error");
        }
    }


    public ArrayAdapter arrayAdapter(Context con) {
            adapter = new ArrayAdapter(con, android.R.layout.simple_list_item_1, myArray);
        return adapter;
    }

    }

