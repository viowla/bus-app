package com.example.test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String title[]={"City 1-City 2","City 1-City 2","City 1-City 2","City 1-City 2"};
    String subtitle[]={"XX.XX.XXXX XX:XX","XX.XX.XXXX XX:XX","XX.XX.XXXX XX:XX","XX.XX.XXXX XX:XX"};
    int images[]={R.drawable.bus1,R.drawable.bus2,R.drawable.bus3,R.drawable.bus4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView=(ListView) findViewById(R.id.listView);

        MyAdapter myAdapter=new MyAdapter(this,title,subtitle,images);
        listView.setAdapter(myAdapter);
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String title[];
        String subtitle[];
        int img[];

        public MyAdapter(Context c, String[] title, String[] subtitle, int[] img){
            super(c, R.layout.row,R.id.textView1, title);
            this.context=c;
            this.title=title;
            this.subtitle=subtitle;
            this.img=img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);
            ImageView imageView=row.findViewById(R.id.image);
            TextView textView1 = row.findViewById(R.id.textView1);
            TextView textView2 = row.findViewById(R.id.textView2);


            imageView.setImageResource(images[position]);
            textView1.setText(title[position]);
            textView2.setText(subtitle[position]);

            return row;
        }
    }

}