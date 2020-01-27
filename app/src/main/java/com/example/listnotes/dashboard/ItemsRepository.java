package com.example.listnotes.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.listnotes.datasource.DataSource;
import com.example.listnotes.datasource.Item;

import java.util.List;

public class ItemsRepository {
    private DataSource mDataSource;
    private static ItemsRepository itemsRepository;

    private ItemsRepository() {
        mDataSource = DataSource.getInstance();
    }

    public synchronized static ItemsRepository getInstance() {
        if (itemsRepository == null) {
            itemsRepository = new ItemsRepository();
        }
        return itemsRepository;
    }


    /**
     * This is used to get all items
     * @return live data with items
     */
    public LiveData<List<Item>> getItemsList() {
        return mDataSource.getAllItems();
    }
}
