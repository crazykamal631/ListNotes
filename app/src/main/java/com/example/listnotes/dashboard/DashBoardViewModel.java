package com.example.listnotes.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.listnotes.datasource.Item;

import java.util.List;

public class DashBoardViewModel extends ViewModel {


    private final LiveData<List<Item>> projectListObservable;

    public DashBoardViewModel() {
        projectListObservable = ItemsRepository.getInstance().getItemsList();
    }


    LiveData<List<Item>> getProjectListObservable() {
        return projectListObservable;
    }
}
