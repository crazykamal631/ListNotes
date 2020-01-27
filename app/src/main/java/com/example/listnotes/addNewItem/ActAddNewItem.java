package com.example.listnotes.addNewItem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listnotes.R;
import com.example.listnotes.showItemDetail.ActShowItemDetail;

public class ActAddNewItem extends AppCompatActivity {

    private static final String TAG = "ActAddNewItem_ListNotes";

    Button saveContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_add_new_item);

        saveContent = findViewById(R.id.save_content);
        saveContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchItemDetailScreen();
            }
        });
    }

    private void launchItemDetailScreen(){
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), ActShowItemDetail.class);
        startActivity(intent);
    }
}
