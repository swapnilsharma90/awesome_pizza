package com.ma.android.pizza;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    SeekBar sb;

    TextView tvMedium, tvLarge, tvReg;
    TextView tvMediumDesc, tvLargeDesc, tvRegDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb = (SeekBar) findViewById(R.id.seekBar1);

        tvReg = (TextView) findViewById(R.id.tvRegular);
        tvMedium = (TextView) findViewById(R.id.tvMed);
        tvLarge = (TextView) findViewById(R.id.tvLarge);

        tvRegDesc = (TextView) findViewById(R.id.tvRegularDesc);
        tvMediumDesc = (TextView) findViewById(R.id.tvMedDesc);
        tvLargeDesc = (TextView) findViewById(R.id.tvLargeDesc);


        tvReg.setTextColor(getResources().getColor(R.color.colorAccent));
        tvRegDesc.setTextColor(getResources().getColor(R.color.colorAccent));

        tvReg.setTextSize(24);
        tvRegDesc.setTextSize(24);


        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (progress < 33) {
                    tvReg.setTextColor(getResources().getColor(R.color.colorAccent));
                    tvRegDesc.setTextColor(getResources().getColor(R.color.colorAccent));


                    tvReg.setTextSize(24);
                    tvRegDesc.setTextSize(24);

                    tvMedium.setTextSize(16);
                    tvMediumDesc.setTextSize(16);

                    tvLarge.setTextSize(16);
                    tvLargeDesc.setTextSize(16);


                    tvMediumDesc.setTextColor(getResources().getColor(android.R.color.white));
                    tvLargeDesc.setTextColor(getResources().getColor(android.R.color.white));


                    tvMedium.setTextColor(getResources().getColor(android.R.color.white));
                    tvLarge.setTextColor(getResources().getColor(android.R.color.white));


                }
                if (progress > 33 && (progress < 70)) {

                    tvReg.setTextSize(16);
                    tvRegDesc.setTextSize(16);

                    tvMedium.setTextSize(24);
                    tvMediumDesc.setTextSize(24);

                    tvLarge.setTextSize(16);
                    tvLargeDesc.setTextSize(16);

                    tvMedium.setTextColor(getResources().getColor(R.color.colorAccent));
                    tvReg.setTextColor(getResources().getColor(android.R.color.white));
                    tvLarge.setTextColor(getResources().getColor(android.R.color.white));


                    tvRegDesc.setTextColor(getResources().getColor(android.R.color.white));
                    tvMediumDesc.setTextColor(getResources().getColor(R.color.colorAccent));
                    tvLargeDesc.setTextColor(getResources().getColor(android.R.color.white));

                }
                if (progress > 70) {

                    tvReg.setTextSize(16);
                    tvRegDesc.setTextSize(16);

                    tvMedium.setTextSize(16);
                    tvMediumDesc.setTextSize(16);

                    tvLarge.setTextSize(24);
                    tvLargeDesc.setTextSize(24);

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
}
