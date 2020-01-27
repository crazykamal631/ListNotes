package com.example.listnotes.addNewItem;

import com.example.listnotes.datasource.DataSource;
import com.example.listnotes.datasource.Item;

public class AddNewItemRepository {
    private DataSource mDataSource;
    private static AddNewItemRepository itemsRepository;

    private AddNewItemRepository() {
        mDataSource = DataSource.getInstance();
    }

    public synchronized static AddNewItemRepository getInstance() {
        if (itemsRepository == null) {
            itemsRepository = new AddNewItemRepository();
        }
        return itemsRepository;
    }

    /**
     * This is added new item to data source
     * @param item
     */
    public void addNewItem(Item item){
        mDataSource.addNewItem(item);
    }
}
