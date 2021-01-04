package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.sql.Driver;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Movie> MovieData = new ArrayList<>();
       Movie m = new Movie("Avengers1",1.5,7,2010,R.drawable.avengers1);
       Movie a =  new Movie("Avengers2",2,7,2013,R.drawable.avengers2);
        Movie b =  new Movie("Avengers3",2,8,2017,R.drawable.avengers3);
        Movie c =  new Movie("Avengers4",2,7,2019,R.drawable.avengers4);

MovieData.add(m);
MovieData.add(a);
MovieData.add(b);
MovieData.add(c);

       RecyclerView movielist = findViewById(R.id.rv);
       //aligning the item linear layout
  movielist.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
movielist.setLayoutManager(lm);

MovieAdapter ma = new MovieAdapter(MovieData,MainActivity.this);
movielist.setAdapter(ma);


        Toolbar toolbar = findViewById(R.id.toolbar);
        LinearLayout ll = findViewById(R.id.linearLayout);
        PrimaryDrawerItem item1 =  new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.ic_baseline_home_24);
        PrimaryDrawerItem item2 =  new PrimaryDrawerItem().withIdentifier(2).withName("Settings").withIcon(R.drawable.ic_baseline_settings_24);
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("Settings");

        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems( item1, item2 , new DividerDrawerItem(), item3

                )


                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Toast.makeText(MainActivity.this, "you clicked on" + drawerItem.getIdentifier(),Toast.LENGTH_SHORT).show();

                        Snackbar.make(ll,"undo",Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
return true;
                    }
                })
                .build();



    }
}