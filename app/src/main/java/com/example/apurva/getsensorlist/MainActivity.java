package com.example.apurva.getsensorlist;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView mylist; //listview object

    ArrayList<String> arrayList=new ArrayList<>(); //dynamic array object

    ArrayAdapter<String> adapter; //arrayadapter refrence

    //SensorManager reference
    SensorManager sensorManager;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist=findViewById(R.id.mylist);

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);

        mylist.setAdapter(adapter);

        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> list=sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor:list){
            arrayList.add(""+sensor.getName());
            count++;
            adapter.notifyDataSetChanged();
        }

        Toast.makeText(this, "Your Mobile have "+count+" Sensor", Toast.LENGTH_LONG).show();

    }
}
