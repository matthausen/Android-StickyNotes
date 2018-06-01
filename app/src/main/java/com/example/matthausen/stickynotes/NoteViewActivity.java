package com.example.matthausen.stickynotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NoteViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_view);

        TextView textview=(TextView)findViewById(R.id.text_view);

        String sub_id = getIntent().getStringExtra("id");
        String text=getIntent().getStringExtra("text");
        textview.setText(text);
    }
}
