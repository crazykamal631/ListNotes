package com.example.listnotes.addNewItem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.listnotes.R;
import com.example.listnotes.databinding.LytAddNewItemBinding;
import com.example.listnotes.datasource.Item;
import com.example.listnotes.showItemDetail.ActShowItemDetail;

public class ActAddNewItem extends AppCompatActivity {

    private static final String TAG = "ActAddNewItem_ListNotes";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    /**
     * This is used to initialize views and observers
     */
    private void init() {
        AddNewItemViewModel addNewItemViewModel = ViewModelProviders.of(this).get(AddNewItemViewModel.class);
        LytAddNewItemBinding lytAddNewItemBinding = DataBindingUtil.setContentView(this, R.layout.lyt_add_new_item);
        lytAddNewItemBinding.setLifecycleOwner(this);
        lytAddNewItemBinding.setAddNewItemViewModel(addNewItemViewModel);


        addNewItemViewModel.getMessageObservable().observe(this, mMessageObserver);
        addNewItemViewModel.getItemAddedObservable().observe(this, mItemAddedObserver);
    }

    /**
     * This is a live data message observer, handling error messages
     */
    private Observer<? super String> mMessageObserver = new Observer<String>() {
        @Override
        public void onChanged(String s) {
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        }
    };

    /**
     * This is a live data observer, if item is added succesfully, it will launch Detail screen
     */
    private Observer<? super Item> mItemAddedObserver = new Observer<Item>() {
        @Override
        public void onChanged(Item item) {
            launchItemDetailScreen(item);
        }
    };

    /**
     * This method is used to show Detail of item added
     *
     * @param item -- item with title and content
     */
    private void launchItemDetailScreen(Item item) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), ActShowItemDetail.class);
        intent.putExtra(ActShowItemDetail.TITLE, item);
        startActivity(intent);
    }
}
