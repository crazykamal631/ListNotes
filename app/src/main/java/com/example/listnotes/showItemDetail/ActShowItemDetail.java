package com.example.listnotes.showItemDetail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.listnotes.R;
import com.example.listnotes.databinding.LytItemDetailBinding;
import com.example.listnotes.datasource.Item;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActShowItemDetail extends AppCompatActivity {

    public static final String TITLE = "TITLE";
    private static final String TAG = "ActShowItemDetail_ListNotes";
    private static final String ITEM_DATE_FORMAT = "dd MMM yyyy, hh:mm aaa";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LytItemDetailBinding lytItemDetailBinding = DataBindingUtil.setContentView(this, R.layout.lyt_item_detail);
        lytItemDetailBinding.setLifecycleOwner(this);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(TITLE)) {
                Item item = intent.getParcelableExtra(TITLE);
                item.setTime(getDateFormatted());
                lytItemDetailBinding.setItem(item);
            }
        }

    }

    private String getDateFormatted(){
        //13 January 2018, 5:30 PM
        SimpleDateFormat formatter = new SimpleDateFormat(ITEM_DATE_FORMAT);
        return formatter.format(new Date());
    }

}
