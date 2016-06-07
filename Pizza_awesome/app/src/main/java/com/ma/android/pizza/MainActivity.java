package com.ma.android.pizza;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    SeekBar sb;
    TextView tvMedium, tvLarge, tvReg;
    TextView tvMediumDesc, tvLargeDesc, tvRegDesc;
    CircleView pizzaCircle;

    LinearLayout llSize;
    String selectedSize;

    RelativeLayout rlSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);

        sb = (SeekBar) findViewById(R.id.seekBar1);
        tvReg = (TextView) findViewById(R.id.tvRegular);
        tvMedium = (TextView) findViewById(R.id.tvMed);
        tvLarge = (TextView) findViewById(R.id.tvLarge);
        tvRegDesc = (TextView) findViewById(R.id.tvRegularDesc);
        tvMediumDesc = (TextView) findViewById(R.id.tvMedDesc);
        tvLargeDesc = (TextView) findViewById(R.id.tvLargeDesc);
        pizzaCircle = (CircleView) findViewById(R.id.pizzaCircle);

        rlSelect = (RelativeLayout) findViewById(R.id.rlSelect);

        llSize = (LinearLayout) findViewById(R.id.sizeLL);

        tvReg.setTextColor(getResources().getColor(R.color.colorAccent));
        tvRegDesc.setTextColor(getResources().getColor(R.color.colorAccent));

        tvReg.setTextSize(20);
        tvRegDesc.setTextSize(16);


        rlSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb.setVisibility(View.GONE);
                llSize.setVisibility(View.GONE);

                Toast.makeText(MainActivity.this,"selected size is "+selectedSize,Toast.LENGTH_SHORT).show();


            }
        });


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        pizzaCircle.setLayoutParams(params);

        // pizzaCircle.gra
        pizzaCircle.setCircleRadius(270);

        selectedSize="regular";
        
        //// TODO: 6/7/16 how to change size....on bCK SHOW SIZE OPTIONS

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (progress < 33) {

                    selectedSize="regular";

                    pizzaCircle.setSlices(4);

                    tvReg.setTextColor(getResources().getColor(R.color.colorAccent));
                    tvRegDesc.setTextColor(getResources().getColor(R.color.colorAccent));

                    tvReg.setTextSize(20);
                    tvRegDesc.setTextSize(16);

                    tvMedium.setTextSize(14);
                    tvMediumDesc.setTextSize(10);

                    tvLarge.setTextSize(14);
                    tvLargeDesc.setTextSize(10);


                    tvMediumDesc.setTextColor(getResources().getColor(android.R.color.white));
                    tvLargeDesc.setTextColor(getResources().getColor(android.R.color.white));


                    tvMedium.setTextColor(getResources().getColor(android.R.color.white));
                    tvLarge.setTextColor(getResources().getColor(android.R.color.white));
                    resizePizza(270);

                }
                if (progress > 33 && (progress < 70)) {


                    selectedSize="medium";

                    pizzaCircle.setSlices(6);

                    //   pizzaCircle
                    resizePizza(285);

                    tvReg.setTextSize(14);
                    tvRegDesc.setTextSize(10);

                    tvMedium.setTextSize(20);
                    tvMediumDesc.setTextSize(16);

                    tvLarge.setTextSize(14);
                    tvLargeDesc.setTextSize(10);

                    tvMedium.setTextColor(getResources().getColor(R.color.colorAccent));
                    tvReg.setTextColor(getResources().getColor(android.R.color.white));
                    tvLarge.setTextColor(getResources().getColor(android.R.color.white));


                    tvRegDesc.setTextColor(getResources().getColor(android.R.color.white));
                    tvMediumDesc.setTextColor(getResources().getColor(R.color.colorAccent));
                    tvLargeDesc.setTextColor(getResources().getColor(android.R.color.white));

                    tvMedium.animate();
                    tvMediumDesc.animate();


                }
                if (progress > 70) {

                    selectedSize="large";

                    pizzaCircle.setSlices(8);

                    resizePizza(295);

                    tvReg.setTextSize(14);
                    tvRegDesc.setTextSize(10);

                    tvMedium.setTextSize(14);
                    tvMediumDesc.setTextSize(10);

                    tvLarge.setTextSize(20);
                    tvLargeDesc.setTextSize(16);

                    tvLarge.setTextColor(getResources().getColor(R.color.colorAccent));
                    tvReg.setTextColor(getResources().getColor(android.R.color.white));
                    tvMedium.setTextColor(getResources().getColor(android.R.color.white));

                    tvRegDesc.setTextColor(getResources().getColor(android.R.color.white));
                    tvMediumDesc.setTextColor(getResources().getColor(android.R.color.white));
                    tvLargeDesc.setTextColor(getResources().getColor(R.color.colorAccent));

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    private void resizePizza(int radius) {

        pizzaCircle.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        pizzaCircle.setFillColor(0x33ffffff);

        pizzaCircle.setCircleRadius(radius);
        pizzaCircle.setSlices(8);

        pizzaCircle.invalidate();

    }


}
