package com.example.test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] title ={"City 1-City 2","City 1-City 2","City 1-City 2","City 1-City 2"};
    String[] subtitle ={"XX.XX.XXXX XX:XX","XX.XX.XXXX XX:XX","XX.XX.XXXX XX:XX","XX.XX.XXXX XX:XX"};
    String[] subtitle2 ={"XX.XX.XXXX XX:XX","XX.XX.XXXX XX:XX","XX.XX.XXXX XX:XX","XX.XX.XXXX XX:XX"};
    int[] images ={R.drawable.bus1,R.drawable.bus2,R.drawable.bus3,R.drawable.bus4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView= findViewById(R.id.listView);

        MyAdapter myAdapter=new MyAdapter(this,title,subtitle,subtitle2,images);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this.getApplicationContext(), SecondActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("images", images[0]);
                    bundle.putString("title", title[0]);
                    bundle.putString("subtitle", subtitle[0]);
                    bundle.putString("subtitle2", subtitle2[0]);
                    intent.putExtras(bundle);
                    MainActivity.this.startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(MainActivity.this.getApplicationContext(), SecondActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("images", images[0]);
                    bundle.putString("title", title[0]);
                    bundle.putString("subtitle", subtitle[0]);
                    bundle.putString("subtitle2", subtitle2[0]);
                    intent.putExtras(bundle);
                    MainActivity.this.startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(MainActivity.this.getApplicationContext(), SecondActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("images", images[0]);
                    bundle.putString("title", title[0]);
                    bundle.putString("subtitle", subtitle[0]);
                    bundle.putString("subtitle2", subtitle2[0]);
                    intent.putExtras(bundle);
                    MainActivity.this.startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(MainActivity.this.getApplicationContext(), SecondActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("images", images[0]);
                    bundle.putString("title", title[0]);
                    bundle.putString("subtitle", subtitle[0]);
                    bundle.putString("subtitle2", subtitle2[0]);
                    intent.putExtras(bundle);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] title;
        String[] subtitle;
        String[] subtitle2;
        int[] img;

        public MyAdapter(Context c, String[] title, String[] subtitle, String[] subtitle2, int[] img){
            super(c, R.layout.row,R.id.textView1, title);
            this.context=c;
            this.title=title;
            this.subtitle=subtitle;
            this.subtitle2=subtitle2;
            this.img=img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater;
            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);
            ImageView imageView=row.findViewById(R.id.image);
            TextView textView1 = row.findViewById(R.id.textView1);
            TextView textView2 = row.findViewById(R.id.textView2);
            TextView textView3 = row.findViewById(R.id.textView3);


            imageView.setImageResource(images[position]);
            textView1.setText(title[position]);
            textView2.setText(subtitle[position]);
            textView3.setText(subtitle2[position]);

            return row;
        }
    }

}