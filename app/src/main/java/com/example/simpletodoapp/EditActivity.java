package com.example.simpletodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    EditText etItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        etItem.setText(getIntent().getStringExtra(MainActivity.kEY_ITEM_TEXT));

        //when the user is done edition , they click the save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create an intent which will contain the results
                Intent intent = new Intent();
                // pass the data (results of editing)
                intent.putExtra(MainActivity.kEY_ITEM_TEXT, etItem.getText().toString());
                intent.putExtra(MainActivity.kEY_ITEM_POSITION,getIntent().getExtras().getInt(MainActivity.kEY_ITEM_POSITION));

                //set the result of the intent
                setResult(RESULT_OK, intent);
                //finish activity, close the scree and go back
                finish();
            }
        });
    }
}
