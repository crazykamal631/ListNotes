package com.example.listnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.listnotes.addNewItem.ActAddNewItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_ListNotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.add_new_item) {
            Log.d(TAG, "--clicked add new item--");
            launchAddNewItem();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void launchAddNewItem() {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), ActAddNewItem.class);
        startActivity(intent);
    }
}
