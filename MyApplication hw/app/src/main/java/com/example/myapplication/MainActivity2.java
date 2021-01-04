package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b = getIntent().getExtras();
       Movie m = (Movie) b.getSerializable("movie");
        ImageView img = findViewById(R.id.imageView);
        TextView name = findViewById(R.id.name1);
        TextView rating = findViewById(R.id.textView4);
        TextView duration = findViewById(R.id.textView5);


        img.setImageResource(m.getImg());
        name.setText(m.getName());
        duration.setText( m.getDuration()+"");
           rating.setText(m.getRating()+"");
    }
}