package com.example.myapplication12;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class searchView_listenner implements SearchView.OnQueryTextListener {
    textUtility TextUtility;
    ListView lv;
    ArrayAdapter adapter;

  public searchView_listenner(ArrayAdapter arrad){
      super();
      adapter = arrad;
  }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }
}
