package com.example.move;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;


public class MyAdapter extends ArrayAdapter<SetData> {
    Context context;
    int resource;
    List<SetData> setData;
    TextView likeCount;
    int nLike1 = 0;
    int nLike2 = 0;
    int nLike3 = 0;
    int nLike4 = 0;
   public  MyAdapter(Context context, int resource, List<SetData> setData){
       super(context, resource, setData);
       this.context = context;
       this.resource = resource;
       this.setData = setData;
   }

   @SuppressLint("SetTextI18n")
   @NonNull
   @Override
   public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       LayoutInflater layoutInflater = LayoutInflater.from(context);
       @SuppressLint("ViewHolder") View view = layoutInflater.inflate(resource, null, false);
       TextView textViewTitle = view.findViewById(R.id.textTitle);
       TextView textViewDes = view.findViewById(R.id.textDescription);
       likeCount = view.findViewById(R.id.likeCount);
       ImageView imageViewList =  view.findViewById(R.id.listImage);
       Button likeBtn =  view.findViewById(R.id.like);
       ImageView imageViewMore =  view.findViewById(R.id.more);

       final SetData setDataNew = setData.get(position);
       textViewTitle.setText(setDataNew.getTitle());
       textViewDes.setText(setDataNew.getDescription());
       Picasso.get().load(setDataNew.getImage()).into(imageViewList);



       likeBtn.setOnClickListener(new View.OnClickListener() {

           @SuppressLint("SetTextI18n")
           @Override
           public void onClick(View v){


               if(textViewTitle.getText().equals("Yoga")){
                   nLike1++;
                   likeCount.setText(Integer.toString(nLike1));
                   Toast.makeText(context, "Like Clicked", Toast.LENGTH_SHORT).show();

               }
               else if(textViewTitle.getText().equals("Pilates")){
                   nLike2++;
                   likeCount.setText(Integer.toString(nLike2));
                   Toast.makeText(context, "Like Clicked", Toast.LENGTH_SHORT).show();

               }
               else if(textViewTitle.getText().equals("Running")){
                   nLike3++;
                   likeCount.setText(Integer.toString(nLike3));
                   Toast.makeText(context, "Like Clicked", Toast.LENGTH_SHORT).show();

               }
               else if(textViewTitle.getText().equals("Skipping")){
                   nLike4++;
                   likeCount.setText(Integer.toString(nLike4));
                   Toast.makeText(context, "Like Clicked", Toast.LENGTH_SHORT).show();

               }



           }


       });



       imageViewMore.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v){
               Uri uri;
               if(textViewTitle.getText().equals("Yoga")){
               uri = Uri.parse("https://www.google.com/search?q="+"yoga");
               }
               else if(textViewTitle.getText().equals("Pilates")){
                   uri = Uri.parse("https://www.google.com/search?q="+"pilates");
               }
               else if(textViewTitle.getText().equals("Running")){
                   uri = Uri.parse("https://www.google.com/search?q="+"running");
               }
               else if(textViewTitle.getText().equals("Skipping")){
                   uri = Uri.parse("https://www.google.com/search?q="+"skipping");
               }
               else {
                    uri = Uri.parse("http://www.google.com/search?q="+"sports");
               }
               Intent intent = new Intent(Intent.ACTION_VIEW, uri);
               context.startActivity(intent);
           }
       });


       if(textViewTitle.getText().equals("Yoga")){
           likeCount.setText(Integer.toString(nLike1));


       }
       else if(textViewTitle.getText().equals("Pilates")){
           likeCount.setText(Integer.toString(nLike2));

       }
       else if(textViewTitle.getText().equals("Running")){
           likeCount.setText(Integer.toString(nLike3));

       }
       else if(textViewTitle.getText().equals("Skipping")){
           likeCount.setText(Integer.toString(nLike4));

       }

       return view;
   }
}
