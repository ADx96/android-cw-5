package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import static com.example.myapplication.R.*;

public class MovieAdapter extends RecyclerView.Adapter  {


    ArrayList<Movie> mArray;
    Context c;

    public MovieAdapter(ArrayList<Movie> mArray, Context c) {
        this.mArray = mArray;
        this.c = c;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout.movie_list_item,parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //connecting to movie_list_item xml
        ((ViewHolder) holder).rating.setText(mArray.get(position).getRating()+"");
        ((ViewHolder) holder).duration.setText(mArray.get(position).getDuration()+"");
        ((ViewHolder) holder).year.setText(mArray.get(position).getYear()+"");
        ((ViewHolder) holder).name.setText(mArray.get(position).getName());
        ((ViewHolder) holder).img.setImageResource(mArray.get(position).getImg());
        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(c,MainActivity2.class);
                i.putExtra("movie",mArray.get(position));
                c.startActivity(i);
            }
        });

        final AlertDialog.Builder builder = new AlertDialog.Builder(c);


        ((ViewHolder) holder).remove.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                builder.setTitle("remove");
                builder.setMessage("are you sure ?");
                builder.setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mArray.remove(position);
                        notifyDataSetChanged();



                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int i) {
        Toast.makeText(c,"not removed", Toast.LENGTH_SHORT).show();

    }
});

            }

        });
    }


    @Override
    public int getItemCount() {
        return mArray.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView img;
        public  ImageView remove;
        public TextView duration;
        public TextView name;
        public TextView rating;
        public TextView year;
        public View view;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            view = itemView;
            img = view.findViewById(id.img1);
            name = view.findViewById(id.name1);
            duration = view.findViewById(id.duration);
            rating = view.findViewById(id.rating);
            year = view.findViewById(id.year);
            remove = view.findViewById(id.remove);
        }
    }
}
