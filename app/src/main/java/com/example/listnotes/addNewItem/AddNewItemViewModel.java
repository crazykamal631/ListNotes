package com.example.listnotes.addNewItem;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.listnotes.datasource.Item;

public class AddNewItemViewModel extends ViewModel {
    private final MutableLiveData<String> messageObservable = new MutableLiveData<>();

    private final MutableLiveData<Item> mItemAddedObservable = new MutableLiveData<>();

    public AddNewItemViewModel() {

    }

    /**
     * This method is used to add new item
     * @param title
     * @param content
     */
    public void addItem(String title, String content) {
        if (validate(title, content)) {
            Item item = new Item(title, content);
            AddNewItemRepository.getInstance().addNewItem(item);
            mItemAddedObservable.postValue(item);
        }

    }

    /**
     * This method is used to validate empty title or content
     * @param title
     * @param content
     * @return
     */
    private boolean validate(String title, String content) {
        if (title.isEmpty()) {
            messageObservable.postValue("Title can not be empty");
            return false;
        }

        if (content.isEmpty()) {
            messageObservable.postValue("Content can not be empty");
            return false;
        }

        return true;
    }


    LiveData<String> getMessageObservable() {
        return messageObservable;
    }

    LiveData<Item> getItemAddedObservable() {
        return mItemAddedObservable;
    }
}
