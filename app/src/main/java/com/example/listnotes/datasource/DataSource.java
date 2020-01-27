package com.example.listnotes.datasource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

/**
 * This a temporary data source, can be replaced with db
 */
public class DataSource {
    private static DataSource instance;
    private List<Item> itemList;
    private final MutableLiveData<List<Item>> mData = new MutableLiveData<>();

    private DataSource() {
        itemList = new ArrayList<>();
    }

    public static synchronized DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public void addNewItem(Item item) {
        itemList.add(item);
        mData.setValue(itemList);
    }


    public LiveData<List<Item>> getAllItems() {
        mData.setValue(itemList);
        return mData;
    }


}
