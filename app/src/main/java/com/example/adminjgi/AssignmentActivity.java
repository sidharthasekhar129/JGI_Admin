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
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AssignmentActivity extends AppCompatActivity {
private EditText stream1,year1,lectname,subrank,subname,topicname,deadline,message;
private Button send;
private Spinner streamspinner,yearspinner;
private ImageView back;
private ProgressBar progressBar;
    private static final String TAG="AssignmentActivity";
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private static final String Key_lectname="lectname";
    private static final String Key_subname="subname";
    private static final String Key_rank="rank";

    private static final String Key_topicname="topicname";
    private static final String Key_deadline="deadline";
    private static final String Key_message="message";
    String subrankx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        stream1=(EditText)findViewById(R.id.stream);
        year1=(EditText)findViewById(R.id.year);
        lectname=(EditText)findViewById(R.id.lectname);
        subname=(EditText)findViewById(R.id.subname);
        topicname=(EditText)findViewById(R.id.topicname);
        deadline=(EditText)findViewById(R.id.deadline);
        message=(EditText)findViewById(R.id.message);
        subrank=(EditText)findViewById(R.id.subrank);
        progressBar=(ProgressBar)findViewById(R.id.progressbar) ;

        send=(Button)findViewById(R.id.send);
        streamspinner=(Spinner)findViewById(R.id.streamspinner);
        yearspinner=(Spinner)findViewById(R.id.yearspinner);


        final String stream[]={"CTMA","CTIS","IOT","DS"};
        String year[]={"2016-2020","2017-2021","2018-2022","2019-2023"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,stream);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        streamspinner.setAdapter(adapter);

        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,year);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearspinner.setAdapter(adapter1);


        streamspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    stream1.setText("CTMA");
                }
                else   if (position==1)
                {
                    stream1.setText("CTIS");
                }
                else   if (position==2)
                {
                    stream1.setText("IOT");
                }
                else   if (position==3)
                {
                    stream1.setText("DS");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        yearspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    year1.setText("2016-2020");
                }
                else   if (position==1)
                {
                    year1.setText("2017-2021");
                }
                else   if (position==2)
                {
                    year1.setText("2018-2022");
                }
                else   if (position==3)
                {
                    year1.setText("2019-2023");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String streamx=stream1.getText().toString();
                String yearx=year1.getText().toString();
                String ok=streamx+yearx;
                String lectnamex=lectname.getText().toString();
                String subnamex=subname.getText().toString();
                 subrankx=subrank.getText().toString();
                String topicnamex=topicname.getText().toString();
                String deadlinex=deadline.getText().toString();
                String messagex=message.getText().toString();

                if (streamx.isEmpty())
                {
                    stream1.setError("Enter date");
                    stream1.requestFocus();
                    return;
                }
                if (yearx.isEmpty())
                {
                    year1.setError("Enter date");
                    year1.requestFocus();
                    return;
                }
                if (subnamex.isEmpty())
                {
                    subname.setError("Enter date");
                    subname.requestFocus();
                    return;
                }
                if (subrankx.isEmpty())
                {
                    subrank.setError("Enter date");
                    subrank.requestFocus();
                    return;
                }
                if (lectnamex.isEmpty())
                {
                    lectname.setError("Enter date");
                    lectname.requestFocus();
                    return;
                }

                if (topicnamex.isEmpty())
                {
                    topicname.setError("Enter date");
                    topicname.requestFocus();
                    return;
                }
                if (deadlinex.isEmpty())
                {
                    deadline.setError("Enter date");
                    deadline.requestFocus();
                    return;
                }
                if (messagex.isEmpty())
                {
                    message.setError("Enter date");
                    message.requestFocus();
                    return;
                }
                Map<String, Object> assignment=new HashMap<>();
                assignment.put(Key_lectname,lectnamex);
                assignment.put(Key_subname,subnamex);
                assignment.put(Key_rank,subrankx);
                assignment.put(Key_topicname,topicnamex);
                assignment.put(Key_deadline,deadlinex);
                assignment.put(Key_message,messagex);

                db.collection("Assignment").document(streamx).collection(yearx).document(subrankx).set(assignment)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(),"Assignment send sucessfully",Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Can't  send Assignment",Toast.LENGTH_SHORT).show();
                                Log.d(TAG,e.toString());
                                progressBar.setVisibility(View.GONE);
                            }
                        });

            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
