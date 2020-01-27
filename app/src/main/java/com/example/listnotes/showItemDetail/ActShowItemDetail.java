package com.example.listnotes.showItemDetail;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listnotes.R;

public class ActShowItemDetail extends AppCompatActivity {

    private static final String TAG = "ActShowItemDetail_ListNotes";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_item_detail);
    }

}
