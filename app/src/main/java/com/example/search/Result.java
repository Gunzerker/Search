package com.example.search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView res;
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String passedArg = getIntent().getExtras().getString("arg");
        ImageView img=(ImageView) findViewById(R.id.imageView2);
        int imageResource=getResources().getIdentifier("@drawable/"+ passedArg ,null,this.getPackageName());
        img.setImageResource(imageResource);
    }

}
