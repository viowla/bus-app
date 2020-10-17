package com.example.test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    ListView listView;
    String[] nameList ={"Aigerim", "Assel", "Arlan"};
    String[] seatsNum = {"XX","XX","XX"};
    String[] seatType = {"ONLINE", "OFFLINE","ONLINE"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        listView= findViewById(R.id.listView);

        SecondActivity.MyAdapter myAdapter=new SecondActivity.MyAdapter(this,nameList,seatsNum,seatType);
        listView.setAdapter(myAdapter);
        TextView type = findViewById(R.id.type);
        type.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "bottomSheet");
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] nameList;
        String[] seatsNum;
        String[] seatType;

        public MyAdapter(Context c, String[] nameList, String[] seatsNum, String[] seatType){
            super(c, R.layout.seat_row,R.id.name, nameList);
            this.context=c;
            this.nameList=nameList;
            this.seatsNum=seatsNum;
            this.seatType=seatType;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater;
            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.seat_row,parent,false);
            TextView name = row.findViewById(R.id.name);
            TextView seat = row.findViewById(R.id.seat);
            TextView type = row.findViewById(R.id.type);


            name.setText(nameList[position]);
            seat.setText(seatsNum[position]);
            type.setText(seatType[position]);

            return row;
        }
    }
}