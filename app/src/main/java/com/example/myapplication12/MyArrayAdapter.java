package com.example.myapplication12;

import android.content.Context;
import android.database.DataSetObserver;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import static com.example.myapplication12.R.layout.layout_item_list;

public class MyArrayAdapter extends ArrayAdapter {
    Context context;
    public MyArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
        super(context, resource, objects);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String n = getItem(position).toString();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(context.getResources().getLayout(layout_item_list), null);
        }
        TextView tv = convertView.findViewById(R.id.textView);
        /*String result = tv.getText().toString();*/
        SpannableStringBuilder resultSpan = new SpannableStringBuilder(n);
        for (char ch : n.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                resultSpan.setSpan(new ForegroundColorSpan(convertView.getResources().getColor(R.color.colorAccent)),
                        n.indexOf(ch), n.indexOf(ch) + 1,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        tv.setText(resultSpan);


        return convertView;
    }

}