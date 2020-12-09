package com.sugarbaby.luckywheel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.WheelItem;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class wheel extends AppCompatActivity {
    LuckyWheel lmw;
    List list;

    private ImageView wheel;
    private Button spin;
    private TextView ans;
    private String txt;
    private int z = 0;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel);

        //lmw=findViewById(R.id.lwv);
       /* List<WheelItem> wheelItems = new ArrayList<>();
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
        */

        setDefault();

        spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumber();

            }
        });
    }

    private void getNumber() {
        db.collection("games").document("game1").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                txt =documentSnapshot.getString("number");

                int rr = Integer.parseInt(txt);
                if (rr >= 0 && rr <= 9) {
                    spinWheel(rr);
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(wheel.this, "Error004", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setDefault() {
        wheel = (ImageView) findViewById(R.id.spin_wheel_image);
        // value = (EditText) findViewById(R.id.edit_text);
        spin = (Button) findViewById(R.id.spin_button);
        ans = (TextView) findViewById(R.id.ans_text);
        // gift = (ImageView) findViewById(R.id.gift_image);
        //  bonus = (ImageView) findViewById(R.id.bonus_image);
    }

    public void spinWheel(final int rr) {
        RotateAnimation rotateAnimation = new RotateAnimation(0, (360 - (rr * 36)) + 720,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());


        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                z = z + rr;
                final String result = String.valueOf(z);
                ans.setText(result);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });
        wheel.startAnimation(rotateAnimation);
    }
}