package com.example.listnotes;

import com.example.listnotes.addNewItem.ActAddNewItemTest;
import com.example.listnotes.dashboard.MainActivityTest;
import com.example.listnotes.showItemDetail.ActShowItemDetailTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({MainActivityTest.class, ActAddNewItemTest.class, ActShowItemDetailTest.class})
public class ActivityTestSuite {
}
