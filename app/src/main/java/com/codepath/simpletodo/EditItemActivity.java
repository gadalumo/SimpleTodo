package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditItemActivity extends AppCompatActivity {
    String ntext;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Bundle extras = getIntent().getExtras();
        ntext = extras.getString("text");
        pos = extras.getInt("pos");
        Toast.makeText(this, ntext, Toast.LENGTH_SHORT).show();
        //Put text in savetext
        EditText etNewItem = (EditText) findViewById(R.id.saveText);
        etNewItem.setText(ntext);
        etNewItem.setSelection(ntext.length());

    }

    public void onSaveItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.saveText);
        String itemText = etNewItem.getText().toString();
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("name", itemText);
        data.putExtra("pos", pos);
        setResult(RESULT_OK, data);
        finish();
    }
}
