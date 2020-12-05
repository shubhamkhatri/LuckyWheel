package com.sugarbaby.luckywheel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.WheelItem;

import java.util.ArrayList;
import java.util.List;
public class wheel extends AppCompatActivity {
    LuckyWheel lmw;
    List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel);
        lmw=findViewById(R.id.lwv);
        List<WheelItem> wheelItems = new ArrayList<>();
        wheelItems.add(new WheelItem(Color.rgb(172,32,225),BitmapFactory.decodeResource(getResources(),R.drawable.dot),"0"));
        wheelItems.add(new WheelItem(Color.rgb(226,70,79),BitmapFactory.decodeResource(getResources(),R.drawable.dot),"1"));
        wheelItems.add(new WheelItem(Color.rgb(213,193,36),BitmapFactory.decodeResource(getResources(),R.drawable.dot),"2"));
        wheelItems.add(new WheelItem(Color.rgb(29,170,118),BitmapFactory.decodeResource(getResources(),R.drawable.dot),"3"));
        wheelItems.add(new WheelItem(Color.rgb(28,133,224),BitmapFactory.decodeResource(getResources(),R.drawable.dot),"4"));
        wheelItems.add(new WheelItem(Color.rgb(172,32,225),BitmapFactory.decodeResource(getResources(),R.drawable.dot),"5"));
        wheelItems.add(new WheelItem(Color.rgb(226,70,79),BitmapFactory.decodeResource(getResources(),R.drawable.dot),"6"));
        wheelItems.add(new WheelItem(Color.rgb(213,193,36),BitmapFactory.decodeResource(getResources(),R.drawable.dot),"7"));
        wheelItems.add(new WheelItem(Color.rgb(29,170,118),BitmapFactory.decodeResource(getResources(),R.drawable.dot),"8"));
        wheelItems.add(new WheelItem(Color.rgb(28,133,224),BitmapFactory.decodeResource(getResources(),R.drawable.dot),"9"));
        lmw.addWheelItems(wheelItems);

    }
}