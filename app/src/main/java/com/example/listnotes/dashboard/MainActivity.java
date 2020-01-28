package com.example.listnotes.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.listnotes.R;
import com.example.listnotes.addNewItem.ActAddNewItem;
import com.example.listnotes.datasource.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_ListNotes";

    private ListView mListView;
    private List<Item> mItems;
    private CustomAdapter mCustomAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    /**
     * This is used to initialize views and observers
     */
    private void init() {
        mListView = findViewById(R.id.item_list);
        View empty = findViewById(R.id.empty);
        mListView.setEmptyView(empty);
        mItems = new ArrayList<>();
        mCustomAdapter = new CustomAdapter(mItems, getApplicationContext());
        mListView.setAdapter(mCustomAdapter);

        DashBoardViewModel dashBoradViewModel = ViewModelProviders.of(this).get(DashBoardViewModel.class);
        dashBoradViewModel.getProjectListObservable().observe(this, mItemsObserver);

    }

    /**
     * This is a live data observer, observing any new items added
     */
    private Observer<? super List<Item>> mItemsObserver = new Observer<List<Item>>() {
        @Override
        public void onChanged(List<Item> items) {
            Log.d(TAG, "on Changed items->" + items);
            if (items != null) {
                Log.d(TAG, "on Changed items size->" + items.size());
                Collections.reverse(items);
                updateListView(items);
            }
        }
    };

    /**
     * This method is used to update list view
     * @param items - new items
     */
    private void updateListView(List<Item> items){
        mItems.clear();
        mItems.addAll(items);
        mCustomAdapter.notifyDataSetChanged();
    }


    /**
     * This method is used to create options menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * This method will handle menu item click
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.add_new_item) {
            Log.d(TAG, "--clicked add new item--");
            launchAddNewItem();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * This method will launch activity to create new Item
     */
    private void launchAddNewItem() {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), ActAddNewItem.class);
        startActivity(intent);
    }

    public void handleOnClick(View view){
        launchAddNewItem();
    }

}
