package com.example.adminjgi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class SeettingsActivity extends AppCompatActivity {
    private ImageView back;
    private Switch eandp,fingerprint,storege,text,push,privecy,otp,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seettings);

        eandp=(Switch)findViewById(R.id.eandp);
        fingerprint=(Switch)findViewById(R.id.fingerprint);
        storege=(Switch)findViewById(R.id.storage);
        text=(Switch)findViewById(R.id.textnotification);
        push=(Switch)findViewById(R.id.pushnotification);
        privecy=(Switch)findViewById(R.id.privacy);
        otp=(Switch)findViewById(R.id.otp);
        email=(Switch)findViewById(R.id.email);

        eandp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==false)
                {
                    eandp.setChecked(true);
                }
                else
                {

                }

            }
        });
        storege.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==false)
                {
                    storege.setChecked(true);
                }
                else
                {

                }

            }
        });
        text.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true)
                {

                }
                else
                {

                }

            }
        });
        push.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true)
                {

                }
                else
                {

                }

            }
        });
        otp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==false)
                {
                    otp.setChecked(true);
                }
                else
                {

                }

            }
        });
        email.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==false)
                {
                    email.setChecked(true);
                }
                else
                {

                }

            }
        });

        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        eandp.setChecked(true);
        storege.setChecked(true);
        otp.setChecked(true);
        email.setChecked(true);
    }
}
