package com.example.adminjgi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ResultsActivity extends AppCompatActivity {
    private ImageView back;
    private TextView a1,b1,c1,d1,e1,f1,g1,h1,i1,j1;
    private EditText a11,b11,c11,d11,e11,f11,g11,h11,i11,j11,usn;
    private Spinner spinner,spinner1;
    private Button send,clear;

    private static final String TAG="ResultsActivity";
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private static final String Key_a1="a1";
    private static final String Key_b1="b1";
    private static final String Key_c1="c1";
    private static final String Key_d1="d1";
    private static final String Key_e1="e1";
    private static final String Key_f1="f1";
    private static final String Key_g1="g1";
    private static final String Key_h1="h1";
    private static final String Key_i1="i1";
    private static final String Key_j1="j1";


    private static final String Key_a11="a11";
    private static final String Key_b11="b11";
    private static final String Key_c11="c11";
    private static final String Key_d11="d11";
    private static final String Key_e11="e11";
    private static final String Key_f11="f11";
    private static final String Key_g11="g11";
    private static final String Key_h11="h11";
    private static final String Key_i11="i11";
    private static final String Key_j11="j11";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        back=(ImageView)findViewById(R.id.back);
        a1=(TextView)findViewById(R.id.a1);
        b1=(TextView)findViewById(R.id.b1);
        c1=(TextView)findViewById(R.id.c1);
        d1=(TextView)findViewById(R.id.d1);
        e1=(TextView)findViewById(R.id.e1);
        f1=(TextView)findViewById(R.id.f1);
        g1=(TextView)findViewById(R.id.g1);
        h1=(TextView)findViewById(R.id.h1);
        i1=(TextView)findViewById(R.id.i1);
        j1=(TextView)findViewById(R.id.j1);

        a11=(EditText)findViewById(R.id.a11);
        b11=(EditText)findViewById(R.id.b11);
        c11=(EditText)findViewById(R.id.c11);
        d11=(EditText)findViewById(R.id.d11);
        e11=(EditText)findViewById(R.id.e11);
        f11=(EditText)findViewById(R.id.f11);
        g11=(EditText)findViewById(R.id.g11);
        h11=(EditText)findViewById(R.id.h11);
        i11=(EditText)findViewById(R.id.i11);
        j11=(EditText)findViewById(R.id.j11);

        usn=(EditText)findViewById(R.id.usn);

        spinner=(Spinner)findViewById(R.id.spinner);
        spinner1=(Spinner)findViewById(R.id.spinner1);

        send=(Button)findViewById(R.id.send);
        clear=(Button)findViewById(R.id.clear);

        String stream[]={"CTMA","CTIS","IOT","DS"};
        final String sem[]={"1st sem","3th sem","5th sem","7th sem"};

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,stream);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sem);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position==0)
                            {

                            }
                            else if (position==1)
                            {

                            }
                            else if (position==2)
                            {
                                a1.setText("Data center");
                                b1.setText("Enterprise app developement");
                                c1.setText("iOS app develipement");
                                d1.setText("Storage management");
                                e1.setText("Principle of virtualization");
                                f1.setText("Windows server configuration");
                            }
                            else if (position==3)
                            {

                            }
                            else
                            {

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                }
                else if (position==1)
                {
                    spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position==0)
                            {

                            }
                            else if (position==1)
                            {

                            }
                            else if (position==2)
                            {
                                a1.setText("Data center");
                                b1.setText("Network security");
                                c1.setText("Cryptography");
                                d1.setText("Storage management");
                                e1.setText("Principle of virtualization");
                                f1.setText("Windows server configuration");
                            }
                            else if (position==3)
                            {

                            }
                            else
                            {

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                }
                else if (position==2)
                {

                    spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position==0)
                            {

                            }
                            else if (position==1)
                            {

                            }
                            else if (position==2)
                            {
                                a1.setText("Sensor technology");
                                b1.setText("Design and analysis of algorithim");
                                c1.setText("Big data analysis");
                                d1.setText("Python programming");
                                e1.setText("Introduction to IoT,cloud and Big data");
                                f1.setText("Digital signal processing");
                            }
                            else if (position==3)
                            {

                            }
                            else
                            {

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (position==3)
                {

                    spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position==0)
                            {

                            }
                            else if (position==1)
                            {

                            }
                            else if (position==2)
                            {
                                a1.setText("Inferential Statistics");
                                b1.setText("Advanca data analysis using SQL");
                                c1.setText("Big data analysis1");
                                d1.setText("Machine learning algorithim");
                                e1.setText("Optimization technology");
                                f1.setText("Python programming for data science");
                                g1.setText("Data virtualization");
                            }
                            else if (position==3)
                            {

                            }
                            else
                            {

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else
                {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ax=a1.getText().toString();
                String bx=b1.getText().toString();
                String cx=c1.getText().toString();
                String dx=d1.getText().toString();
                String ex=e1.getText().toString();
                String fx=f1.getText().toString();
              /*  String gx=g1.getText().toString();
                String hx=h1.getText().toString();
                String ix=i1.getText().toString();
                String jx=j1.getText().toString();*/

                String usnx=usn.getText().toString();
                String usnxx=usnx.toUpperCase();

                String axx=a11.getText().toString();
                String bxx=b11.getText().toString();
                String cxx=c11.getText().toString();
                String dxx=d11.getText().toString();
                String exx=e11.getText().toString();
                String fxx=f11.getText().toString();
                /*String gxx=g11.getText().toString();
                String hxx=h11.getText().toString();
                String ixx=i11.getText().toString();
                String jxx=j11.getText().toString();*/

                Map<String, Object> result=new HashMap<>();
                result.put(Key_a1,ax);
                result.put(Key_b1,bx);
                result.put(Key_c1,cx);
                result.put(Key_d1,dx);
                result.put(Key_e1,ex);
                result.put(Key_f1,fx);
              /*  result.put(Key_g1,gx);
                result.put(Key_h1,hx);
                result.put(Key_i1,ix);
                result.put(Key_j1,jx);*/


                result.put(Key_a11,axx);
                result.put(Key_b11,bxx);
                result.put(Key_c11,cxx);
                result.put(Key_d11,dxx);
                result.put(Key_e11,exx);
                result.put(Key_f11,fxx);
              /*  result.put(Key_g11,gxx);
                result.put(Key_h11,hxx);
                result.put(Key_i11,ixx);
                result.put(Key_j11,jxx);*/

                db.collection(usnxx).document("results").set(result)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(),"Saved Sucessfully",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Cant create database",Toast.LENGTH_SHORT).show();
                                Log.d(TAG,e.toString());
                            }
                        });



            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a11.setText("");
                b11.setText("");
                c11.setText("");
                d11.setText("");
                e11.setText("");
                f11.setText("");
                g11.setText("");
                h11.setText("");
                i11.setText("");
                j11.setText("");

            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
