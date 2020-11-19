package com.example.adminjgi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AttendanceActivity extends AppCompatActivity {
    private ImageView back;

    private EditText sname,a,a1,a2,a3,a4,A,A1,A2,A3,A4,
            b,b1,b2,b3,b4,B,B1,B2,B3,B4,
            c,c1,c2,c3,c4,C,C1,C2,C3,C4,
            d,d1,d2,d3,d4,D,D1,D2,D3,D4,
            e,e1,e2,e3,e4,E,E1,E2,E3,E4,
            f,f1,f2,f3,f4,F,F1,F2,F3,F4,
            g,g1,g2,g3,g4,G,G1,G2,G3,G4,
            h,h1,h2,h3,h4,H,H1,H2,H3,H4,
            i,i1,i2,i3,i4,I,I1,I2,I3,I4,
            j,j1,j2,j3,j4,J,J1,J2,J3,J4;


     private ProgressBar progressBar,progressBar1;

    private static final String Key_a="class1";
    private static final String Key_a1="class2";
    private static final String Key_a2="class3";
    private static final String Key_a3="class4";
    private static final String Key_a4="class5";
    private static final String Key_b="class6";
    private static final String Key_b1="class7";
    private static final String Key_b2="class8";
    private static final String Key_b3="class9";
    private static final String Key_b4="class10";
    private static final String Key_c="class11";
    private static final String Key_c1="class12";
    private static final String Key_c2="class13";
    private static final String Key_c3="class14";
    private static final String Key_c4="class15";
    private static final String Key_d="class16";
    private static final String Key_d1="class17";
    private static final String Key_d2="class18";
    private static final String Key_d3="class19";
    private static final String Key_d4="class20";
    private static final String Key_e="class21";
    private static final String Key_e1="class22";
    private static final String Key_e2="class23";
    private static final String Key_e3="class24";
    private static final String Key_e4="class25";
    private static final String Key_f="class26";
    private static final String Key_f1="class27";
    private static final String Key_f2="class28";
    private static final String Key_f3="class29";
    private static final String Key_f4="class30";
    private static final String Key_g="class31";
    private static final String Key_g1="class32";
    private static final String Key_g2="class33";
    private static final String Key_g3="class34";
    private static final String Key_g4="class35";
    private static final String Key_h="class36";
    private static final String Key_h1="class37";
    private static final String Key_h2="class38";
    private static final String Key_h3="class39";
    private static final String Key_h4="class40";
    private static final String Key_i="class41";
    private static final String Key_i1="class42";
    private static final String Key_i2="class43";
    private static final String Key_i3="class44";
    private static final String Key_i4="class45";
    private static final String Key_j="class46";
    private static final String Key_j1="class47";
    private static final String Key_j2="class48";
    private static final String Key_j3="class49";
    private static final String Key_j4="class50";

    private static final String Key_A="class1A";
    private static final String Key_A1="class2A";
    private static final String Key_A2="class3A";
    private static final String Key_A3="class4A";
    private static final String Key_A4="class5A";
    private static final String Key_B="class6B";
    private static final String Key_B1="class7B";
    private static final String Key_B2="class8B";
    private static final String Key_B3="class9B";
    private static final String Key_B4="class10B";
    private static final String Key_C="class11C";
    private static final String Key_C1="class12C";
    private static final String Key_C2="class13C";
    private static final String Key_C3="class14C";
    private static final String Key_C4="class15C";
    private static final String Key_D="class16D";
    private static final String Key_D1="class17D";
    private static final String Key_D2="class18D";
    private static final String Key_D3="class19D";
    private static final String Key_D4="class20D";
    private static final String Key_E="class21E";
    private static final String Key_E1="class22E";
    private static final String Key_E2="class23E";
    private static final String Key_E3="class24E";
    private static final String Key_E4="class25E";
    private static final String Key_F="class26F";
    private static final String Key_F1="class27F";
    private static final String Key_F2="class28F";
    private static final String Key_F3="class29F";
    private static final String Key_F4="class30F";
    private static final String Key_G="class31G";
    private static final String Key_G1="class32G";
    private static final String Key_G2="class33G";
    private static final String Key_G3="class34G";
    private static final String Key_G4="class35G";
    private static final String Key_H="class36H";
    private static final String Key_H1="class37H";
    private static final String Key_H2="class38H";
    private static final String Key_H3="class39H";
    private static final String Key_H4="class40H";
    private static final String Key_I="class41I";
    private static final String Key_I1="class42I";
    private static final String Key_I2="class43I";
    private static final String Key_I3="class44I";
    private static final String Key_I4="class45I";
    private static final String Key_J="class46J";
    private static final String Key_J1="class47J";
    private static final String Key_J2="class48J";
    private static final String Key_J3="class49J";
    private static final String Key_J4="class50J";
    private static final String Key_subjects="subject";


    private static final String TAG="AttendanceActivity";
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private static final String Key_current="current";
    private static final String Key_last="last";
    private static final String Key_last2="last2";
    private static final String Key_last3="last3";

    private static final String Key_overall="overall";
    private static final String Key_remarks="remarks";
private EditText usn,current,last,last2,last3,overall,remarks,usnx,subnamex,subrankx;
private Button send,clear,sendx,loadx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        usn=(EditText)findViewById(R.id.usn);
        current=(EditText)findViewById(R.id.current);
        last=(EditText)findViewById(R.id.last);
        last3=(EditText)findViewById(R.id.last3);
        last2=(EditText)findViewById(R.id.last2);
        overall=(EditText)findViewById(R.id.overall);
        remarks=(EditText)findViewById(R.id.remarks);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        progressBar1=(ProgressBar)findViewById(R.id.progressbar1);

        usnx=(EditText)findViewById(R.id.usnx);
        subnamex=(EditText)findViewById(R.id.subnamex);
        subrankx=(EditText)findViewById(R.id.subrankx);

        send=(Button)findViewById(R.id.send);
        clear=(Button)findViewById(R.id.clear);

        sendx=(Button)findViewById(R.id.sendx);
        loadx=(Button)findViewById(R.id.loadx);

        a=(EditText) findViewById(R.id.a);
        a1=(EditText) findViewById(R.id.a1);
        a2=(EditText)findViewById(R.id.a2);
        a3=(EditText)findViewById(R.id.a3);
        a4=(EditText)findViewById(R.id.a4);

        A=(EditText)findViewById(R.id.A);
        A1=(EditText)findViewById(R.id.A1);
        A2=(EditText)findViewById(R.id.A2);
        A3=(EditText)findViewById(R.id.A3);
        A4=(EditText)findViewById(R.id.A4);

        b=(EditText)findViewById(R.id.b);
        b1=(EditText)findViewById(R.id.b1);
        b2=(EditText)findViewById(R.id.b2);
        b3=(EditText)findViewById(R.id.b3);
        b4=(EditText)findViewById(R.id.b4);

        B=(EditText)findViewById(R.id.B);
        B1=(EditText)findViewById(R.id.B1);
        B2=(EditText)findViewById(R.id.B2);
        B3=(EditText)findViewById(R.id.B3);
        B4=(EditText)findViewById(R.id.B4);

        c=(EditText)findViewById(R.id.c);
        c1=(EditText)findViewById(R.id.c1);
        c2=(EditText)findViewById(R.id.c2);
        c3=(EditText)findViewById(R.id.c3);
        c4=(EditText)findViewById(R.id.c4);

        C=(EditText)findViewById(R.id.C);
        C1=(EditText)findViewById(R.id.C1);
        C2=(EditText)findViewById(R.id.C2);
        C3=(EditText)findViewById(R.id.C3);
        C4=(EditText)findViewById(R.id.C4);

        d=(EditText)findViewById(R.id.d);
        d1=(EditText)findViewById(R.id.d1);
        d2=(EditText)findViewById(R.id.d2);
        d3=(EditText)findViewById(R.id.d3);
        d4=(EditText)findViewById(R.id.d4);

        D=(EditText)findViewById(R.id.D);
        D1=(EditText)findViewById(R.id.D1);
        D2=(EditText)findViewById(R.id.D2);
        D3=(EditText)findViewById(R.id.D3);
        D4=(EditText)findViewById(R.id.D4);

        e=(EditText)findViewById(R.id.e);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);

        E=(EditText)findViewById(R.id.E);
        E1=(EditText)findViewById(R.id.E1);
        E2=(EditText)findViewById(R.id.E2);
        E3=(EditText)findViewById(R.id.E3);
        E4=(EditText)findViewById(R.id.E4);

        f=(EditText)findViewById(R.id.f);
        f1=(EditText)findViewById(R.id.f1);
        f2=(EditText)findViewById(R.id.f2);
        f3=(EditText)findViewById(R.id.f3);
        f4=(EditText)findViewById(R.id.f4);

        F=(EditText)findViewById(R.id.F);
        F1=(EditText)findViewById(R.id.F1);
        F2=(EditText)findViewById(R.id.F2);
        F3=(EditText)findViewById(R.id.F3);
        F4=(EditText)findViewById(R.id.F4);

        g=(EditText)findViewById(R.id.g);
        g1=(EditText)findViewById(R.id.g1);
        g2=(EditText)findViewById(R.id.g2);
        g3=(EditText)findViewById(R.id.g3);
        g4=(EditText)findViewById(R.id.g4);

        G=(EditText)findViewById(R.id.G);
        G1=(EditText)findViewById(R.id.G1);
        G2=(EditText)findViewById(R.id.G2);
        G3=(EditText)findViewById(R.id.G3);
        G4=(EditText)findViewById(R.id.G4);

        h=(EditText)findViewById(R.id.h);
        h1=(EditText)findViewById(R.id.h1);
        h2=(EditText)findViewById(R.id.h2);
        h3=(EditText)findViewById(R.id.h3);
        h4=(EditText)findViewById(R.id.h4);

        H=(EditText)findViewById(R.id.H);
        H1=(EditText)findViewById(R.id.H1);
        H2=(EditText)findViewById(R.id.H2);
        H3=(EditText)findViewById(R.id.H3);
        H4=(EditText)findViewById(R.id.H4);

        i=(EditText)findViewById(R.id.i);
        i1=(EditText)findViewById(R.id.i1);
        i2=(EditText)findViewById(R.id.i2);
        i3=(EditText)findViewById(R.id.i3);
        i4=(EditText)findViewById(R.id.i4);

        I=(EditText)findViewById(R.id.I);
        I1=(EditText)findViewById(R.id.I1);
        I2=(EditText)findViewById(R.id.I2);
        I3=(EditText)findViewById(R.id.I3);
        I4=(EditText)findViewById(R.id.I4);

        j=(EditText)findViewById(R.id.j);
        j1=(EditText)findViewById(R.id.j1);
        j2=(EditText)findViewById(R.id.j2);
        j3=(EditText)findViewById(R.id.j3);
        j4=(EditText)findViewById(R.id.j4);

        J=(EditText)findViewById(R.id.J);
        J1=(EditText)findViewById(R.id.J1);
        J2=(EditText)findViewById(R.id.J2);
        J3=(EditText)findViewById(R.id.J3);
        J4=(EditText)findViewById(R.id.J4);



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar1.setVisibility(View.VISIBLE);
                    String a=current.getText().toString();
                    String b=last.getText().toString();
                    String c=last2.getText().toString();
                    String d=last3.getText().toString();
                String e=overall.getText().toString();


                String f=remarks.getText().toString();

                String roll=usn.getText().toString();
                String roll1=roll.toUpperCase();

                if (roll.isEmpty())
                {
                    usn.setError("Enter usn");
                    usn.requestFocus();
                    return;
                }

                Map<String, Object> note=new HashMap<>();
                note.put(Key_current,a);
                note.put(Key_last,b);
                note.put(Key_last2,c);
                note.put(Key_last3,d);
                note.put(Key_overall,e);
                note.put(Key_remarks,f);
                db.collection(roll1).document("attendance").set(note)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(),"Saved Sucessfully",Toast.LENGTH_SHORT).show();
                                progressBar1.setVisibility(View.GONE);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Cant create database",Toast.LENGTH_SHORT).show();
                                Log.d(TAG,e.toString());
                                progressBar1.setVisibility(View.GONE);
                            }
                        });


            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 current.setText("");
                last.setText("");
                last2.setText("");
                overall.setText("");
                remarks.setText("");
                usn.setText("");
            }
        });
        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


        loadx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                String subnamexx=subnamex.getText().toString();
                String usnxx=usnx.getText().toString();
                String upusn=usnxx.toUpperCase();
                String subrankxx=subrankx.getText().toString();

                if (usnxx.isEmpty())
                {progressBar1.setVisibility(View.GONE);
                    usnx.setError("Enter usn");
                    usnx.requestFocus();
                    return;
                }
                if (subrankxx.isEmpty())
                {progressBar1.setVisibility(View.GONE);
                    subrankx.setError("Enter subrank");
                    subrankx.requestFocus();
                    return;
                }

                db.collection(upusn).document("attendance").collection("subjects").document(subrankxx).get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists())
                                {


                                    String day1=documentSnapshot.getString(Key_a);
                                    String day2=documentSnapshot.getString(Key_a1);
                                    String day3=documentSnapshot.getString(Key_a2);
                                    String day4=documentSnapshot.getString(Key_a3);
                                    String day5=documentSnapshot.getString(Key_a4);

                                    String day6=documentSnapshot.getString(Key_b);
                                    String day7=documentSnapshot.getString(Key_b1);
                                    String day8=documentSnapshot.getString(Key_b2);
                                    String day9=documentSnapshot.getString(Key_b3);
                                    String day10=documentSnapshot.getString(Key_b4);

                                    String day11=documentSnapshot.getString(Key_c);
                                    String day12=documentSnapshot.getString(Key_c1);
                                    String day13=documentSnapshot.getString(Key_c2);
                                    String day14=documentSnapshot.getString(Key_c3);
                                    String day15=documentSnapshot.getString(Key_c4);

                                    String day16=documentSnapshot.getString(Key_d);
                                    String day17=documentSnapshot.getString(Key_d1);
                                    String day18=documentSnapshot.getString(Key_d2);
                                    String day19=documentSnapshot.getString(Key_d3);
                                    String day20=documentSnapshot.getString(Key_d4);

                                    String day21=documentSnapshot.getString(Key_e);
                                    String day22=documentSnapshot.getString(Key_e1);
                                    String day23=documentSnapshot.getString(Key_e2);
                                    String day24=documentSnapshot.getString(Key_e3);
                                    String day25=documentSnapshot.getString(Key_e4);

                                    String day26=documentSnapshot.getString(Key_f);
                                    String day27=documentSnapshot.getString(Key_f1);
                                    String day28=documentSnapshot.getString(Key_f2);
                                    String day29=documentSnapshot.getString(Key_f3);
                                    String day30=documentSnapshot.getString(Key_f4);

                                    String day31=documentSnapshot.getString(Key_g);
                                    String day32=documentSnapshot.getString(Key_g1);
                                    String day33=documentSnapshot.getString(Key_g2);
                                    String day34=documentSnapshot.getString(Key_g3);
                                    String day35=documentSnapshot.getString(Key_g4);

                                    String day36=documentSnapshot.getString(Key_h);
                                    String day37=documentSnapshot.getString(Key_h1);
                                    String day38=documentSnapshot.getString(Key_h2);
                                    String day39=documentSnapshot.getString(Key_h3);
                                    String day40=documentSnapshot.getString(Key_h4);

                                    String day41=documentSnapshot.getString(Key_i);
                                    String day42=documentSnapshot.getString(Key_i1);
                                    String day43=documentSnapshot.getString(Key_i2);
                                    String day44=documentSnapshot.getString(Key_i3);
                                    String day45=documentSnapshot.getString(Key_i4);

                                    String day46=documentSnapshot.getString(Key_j);
                                    String day47=documentSnapshot.getString(Key_j1);
                                    String day48=documentSnapshot.getString(Key_j2);
                                    String day49=documentSnapshot.getString(Key_j3);
                                    String day50=documentSnapshot.getString(Key_j4);


                                    String cday1=documentSnapshot.getString(Key_A);
                                    String cday2=documentSnapshot.getString(Key_A1);
                                    String cday3=documentSnapshot.getString(Key_A2);
                                    String cday4=documentSnapshot.getString(Key_A3);
                                    String cday5=documentSnapshot.getString(Key_A4);

                                    String cday6=documentSnapshot.getString(Key_B);
                                    String cday7=documentSnapshot.getString(Key_B1);
                                    String cday8=documentSnapshot.getString(Key_B2);
                                    String cday9=documentSnapshot.getString(Key_B3);
                                    String cday10=documentSnapshot.getString(Key_B4);

                                    String cday11=documentSnapshot.getString(Key_C);
                                    String cday12=documentSnapshot.getString(Key_C1);
                                    String cday13=documentSnapshot.getString(Key_C2);
                                    String cday14=documentSnapshot.getString(Key_C3);
                                    String cday15=documentSnapshot.getString(Key_C4);

                                    String cday16=documentSnapshot.getString(Key_D);
                                    String cday17=documentSnapshot.getString(Key_D1);
                                    String cday18=documentSnapshot.getString(Key_D2);
                                    String cday19=documentSnapshot.getString(Key_D3);
                                    String cday20=documentSnapshot.getString(Key_D4);

                                    String cday21=documentSnapshot.getString(Key_E);
                                    String cday22=documentSnapshot.getString(Key_E1);
                                    String cday23=documentSnapshot.getString(Key_E2);
                                    String cday24=documentSnapshot.getString(Key_E3);
                                    String cday25=documentSnapshot.getString(Key_E4);

                                    String cday26=documentSnapshot.getString(Key_F);
                                    String cday27=documentSnapshot.getString(Key_F1);
                                    String cday28=documentSnapshot.getString(Key_F2);
                                    String cday29=documentSnapshot.getString(Key_F3);
                                    String cday30=documentSnapshot.getString(Key_F4);

                                    String cday31=documentSnapshot.getString(Key_G);
                                    String cday32=documentSnapshot.getString(Key_G1);
                                    String cday33=documentSnapshot.getString(Key_G2);
                                    String cday34=documentSnapshot.getString(Key_G3);
                                    String cday35=documentSnapshot.getString(Key_g4);

                                    String cday36=documentSnapshot.getString(Key_H);
                                    String cday37=documentSnapshot.getString(Key_H1);
                                    String cday38=documentSnapshot.getString(Key_H2);
                                    String cday39=documentSnapshot.getString(Key_H3);
                                    String cday40=documentSnapshot.getString(Key_H4);

                                    String cday41=documentSnapshot.getString(Key_I);
                                    String cday42=documentSnapshot.getString(Key_I1);
                                    String cday43=documentSnapshot.getString(Key_I2);
                                    String cday44=documentSnapshot.getString(Key_I3);
                                    String cday45=documentSnapshot.getString(Key_I4);

                                    String cday46=documentSnapshot.getString(Key_J);
                                    String cday47=documentSnapshot.getString(Key_J1);
                                    String cday48=documentSnapshot.getString(Key_J2);
                                    String cday49=documentSnapshot.getString(Key_J3);
                                    String cday50=documentSnapshot.getString(Key_J4);


                                    a.setText(day1);
                                    a1.setText(day2);
                                    a2.setText(day3);
                                    a3.setText(day4);
                                    a4.setText(day5);

                                    A.setText(cday1);
                                    A1.setText(cday2);
                                    A2.setText(cday3);
                                    A3.setText(cday4);
                                    A4.setText(cday5);

                                    b.setText(day6);
                                    b1.setText(day7);
                                    b2.setText(day8);
                                    b3.setText(day9);
                                    b4.setText(day10);

                                    B.setText(cday6);
                                    B1.setText(cday7);
                                    B2.setText(cday8);
                                    B3.setText(cday9);
                                    B4.setText(cday10);

                                    c.setText(day11);
                                    c1.setText(day12);
                                    c2.setText(day13);
                                    c3.setText(day14);
                                    c4.setText(day15);

                                    C.setText(cday11);
                                    C1.setText(cday12);
                                    C2.setText(cday13);
                                    C3.setText(cday14);
                                    C4.setText(cday15);

                                    d.setText(day16);
                                    d1.setText(day17);
                                    d2.setText(day18);
                                    d3.setText(day19);
                                    d4.setText(day20);

                                    D.setText(cday16);
                                    D1.setText(cday17);
                                    D2.setText(cday18);
                                    D3.setText(cday19);
                                    D4.setText(cday20);

                                    e.setText(day21);
                                    e1.setText(day22);
                                    e2.setText(day23);
                                    e3.setText(day24);
                                    e4.setText(day25);

                                    E.setText(cday21);
                                    E1.setText(cday22);
                                    E2.setText(cday23);
                                    E3.setText(cday24);
                                    E4.setText(cday25);

                                    f.setText(day26);
                                    f1.setText(day27);
                                    f2.setText(day28);
                                    f3.setText(day29);
                                    f4.setText(day30);

                                    F.setText(cday26);
                                    F1.setText(cday27);
                                    F2.setText(cday28);
                                    F3.setText(cday29);
                                    F4.setText(cday30);

                                    g.setText(day31);
                                    g1.setText(day32);
                                    g2.setText(day33);
                                    g3.setText(day34);
                                    g4.setText(day35);

                                    G.setText(cday31);
                                    G.setText(cday32);
                                    G2.setText(cday33);
                                    G3.setText(cday34);
                                    G4.setText(cday35);

                                    h.setText(day36);
                                    h1.setText(day37);
                                    h2.setText(day38);
                                    h3.setText(day39);
                                    h4.setText(day40);

                                    I.setText(cday36);
                                    I1.setText(cday37);
                                    I2.setText(cday38);
                                    I3.setText(cday39);
                                    I4.setText(cday40);

                                    i.setText(day41);
                                    i1.setText(day42);
                                    i2.setText(day43);
                                    i3.setText(day44);
                                    i4.setText(day45);

                                    I.setText(cday41);
                                    I1.setText(cday42);
                                    I2.setText(cday43);
                                    I3.setText(cday44);
                                    I4.setText(cday45);

                                    j.setText(day46);
                                    j1.setText(day47);
                                    j2.setText(day48);
                                    j3.setText(day49);
                                    j4.setText(day50);

                                    J.setText(cday46);
                                    J1.setText(cday47);
                                    J2.setText(cday48);
                                    J3.setText(cday49);
                                    J4.setText(cday50);

                                    progressBar.setVisibility(View.GONE);
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),"Not uploaded yet",Toast.LENGTH_SHORT).show();

                                }

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Document does not exist!",Toast.LENGTH_SHORT).show();
                                Log.d(TAG,e.toString());
                            }
                        });
            }
        });
        sendx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String ax=a.getText().toString();
                String Ax=A.getText().toString();
                String a1x=a1.getText().toString();
                String A1x=A1.getText().toString();
                String a2x=a2.getText().toString();
                String A2x=A2.getText().toString();
                String a3x=a3.getText().toString();
                String A3x=A3.getText().toString();
                String a4x=a4.getText().toString();
                String A4x=A4.getText().toString();

                String bx=b.getText().toString();
                String Bx=B.getText().toString();
                String b1x=b1.getText().toString();
                String B1x=B1.getText().toString();
                String b2x=b2.getText().toString();
                String B2x=B2.getText().toString();
                String b3x=b3.getText().toString();
                String B3x=B3.getText().toString();
                String b4x=b4.getText().toString();
                String B4x=B4.getText().toString();

                String cx=c.getText().toString();
                String Cx=C.getText().toString();
                String c1x=c1.getText().toString();
                String C1x=C1.getText().toString();
                String c2x=c2.getText().toString();
                String C2x=C2.getText().toString();
                String c3x=c3.getText().toString();
                String C3x=C3.getText().toString();
                String c4x=c4.getText().toString();
                String C4x=C4.getText().toString();

                String dx=d.getText().toString();
                String Dx=D.getText().toString();
                String d1x=d1.getText().toString();
                String D1x=D1.getText().toString();
                String d2x=d2.getText().toString();
                String D2x=D2.getText().toString();
                String d3x=d3.getText().toString();
                String D3x=D3.getText().toString();
                String d4x=d4.getText().toString();
                String D4x=D4.getText().toString();

                String ex=e.getText().toString();
                String Ex=E.getText().toString();
                String e1x=e1.getText().toString();
                String E1x=E1.getText().toString();
                String e2x=e2.getText().toString();
                String E2x=E2.getText().toString();
                String e3x=e3.getText().toString();
                String E3x=E3.getText().toString();
                String e4x=e4.getText().toString();
                String E4x=E4.getText().toString();

                String fx=f.getText().toString();
                String Fx=F.getText().toString();
                String f1x=f1.getText().toString();
                String F1x=F1.getText().toString();
                String f2x=f2.getText().toString();
                String F2x=F2.getText().toString();
                String f3x=f3.getText().toString();
                String F3x=F3.getText().toString();
                String f4x=f4.getText().toString();
                String F4x=F4.getText().toString();

                String gx=g.getText().toString();
                String Gx=G.getText().toString();
                String g1x=g1.getText().toString();
                String G1x=G1.getText().toString();
                String g2x=g2.getText().toString();
                String G2x=G2.getText().toString();
                String g3x=g3.getText().toString();
                String G3x=G3.getText().toString();
                String g4x=g4.getText().toString();
                String G4x=G4.getText().toString();

                String hx=h.getText().toString();
                String Hx=H.getText().toString();
                String h1x=h1.getText().toString();
                String H1x=H1.getText().toString();
                String h2x=h2.getText().toString();
                String H2x=H2.getText().toString();
                String h3x=h3.getText().toString();
                String H3x=H3.getText().toString();
                String h4x=h4.getText().toString();
                String H4x=H4.getText().toString();

                String ix=i.getText().toString();
                String Ix=I.getText().toString();
                String i1x=i1.getText().toString();
                String I1x=I1.getText().toString();
                String i2x=i2.getText().toString();
                String I2x=I2.getText().toString();
                String i3x=i3.getText().toString();
                String I3x=I3.getText().toString();
                String i4x=i4.getText().toString();
                String I4x=I4.getText().toString();

                String jx=j.getText().toString();
                String Jx=J.getText().toString();
                String j1x=j1.getText().toString();
                String J1x=J1.getText().toString();
                String j2x=j2.getText().toString();
                String J2x=J2.getText().toString();
                String j3x=j3.getText().toString();
                String J3x=J3.getText().toString();
                String j4x=j4.getText().toString();
                String J4x=J4.getText().toString();

                String subnamexx=subnamex.getText().toString();

                String usnxx=usnx.getText().toString();
                String upusnx=usnxx.toUpperCase();

                String subrankxx=subrankx.getText().toString();


                if (usnxx.isEmpty() || usnxx.length()<10)
                {progressBar1.setVisibility(View.GONE);
                    usnx.setError("Enter data");
                    usnx.requestFocus();
                    return;

                }
                if (subnamexx.isEmpty())
                {
                    progressBar1.setVisibility(View.GONE);
                    subnamex.setError("Enter data");
                    subnamex.requestFocus();
                    return;
                }
                if (subrankxx.isEmpty())
                {progressBar1.setVisibility(View.GONE);
                    subrankx.setError("Enter data");
                    subrankx.requestFocus();
                    return;
                }


                Map<String, Object> data=new HashMap<>();
                data.put(Key_a,ax);
                data.put(Key_A,Ax);
                data.put(Key_a1,a1x);
                data.put(Key_A1,A1x);
                data.put(Key_a2,a2x);
                data.put(Key_A2,A2x);
                data.put(Key_a3,a3x);
                data.put(Key_A3,A3x);
                data.put(Key_a4,a4x);
                data.put(Key_A4,A4x);

                data.put(Key_b,bx);
                data.put(Key_B,Bx);
                data.put(Key_b1,b1x);
                data.put(Key_B1,B1x);
                data.put(Key_b2,b2x);
                data.put(Key_B2,B2x);
                data.put(Key_b3,b3x);
                data.put(Key_B3,B3x);
                data.put(Key_b4,b4x);
                data.put(Key_B4,B4x);

                data.put(Key_c,cx);
                data.put(Key_C,Cx);
                data.put(Key_c1,c1x);
                data.put(Key_C1,C1x);
                data.put(Key_c2,c2x);
                data.put(Key_C2,C2x);
                data.put(Key_c3,c3x);
                data.put(Key_C3,C3x);
                data.put(Key_c4,c4x);
                data.put(Key_C4,C4x);

                data.put(Key_d,dx);
                data.put(Key_D,Dx);
                data.put(Key_d1,d1x);
                data.put(Key_D1,D1x);
                data.put(Key_d2,d2x);
                data.put(Key_D2,D2x);
                data.put(Key_d3,d3x);
                data.put(Key_D3,D3x);
                data.put(Key_d4,d4x);
                data.put(Key_D4,D4x);

                data.put(Key_e,ex);
                data.put(Key_E,Ex);
                data.put(Key_e1,e1x);
                data.put(Key_E1,E1x);
                data.put(Key_e2,e2x);
                data.put(Key_E2,E2x);
                data.put(Key_e3,e3x);
                data.put(Key_E3,E3x);
                data.put(Key_e4,e4x);
                data.put(Key_E4,E4x);

                data.put(Key_f,fx);
                data.put(Key_F,Fx);
                data.put(Key_f1,f1x);
                data.put(Key_F1,F1x);
                data.put(Key_f2,f2x);
                data.put(Key_F2,F2x);
                data.put(Key_f3,f3x);
                data.put(Key_F3,F3x);
                data.put(Key_f4,f4x);
                data.put(Key_F4,F4x);

                data.put(Key_g,gx);
                data.put(Key_G,Gx);
                data.put(Key_g1,g1x);
                data.put(Key_G1,G1x);
                data.put(Key_g2,g2x);
                data.put(Key_G2,G2x);
                data.put(Key_g3,g3x);
                data.put(Key_G3,G3x);
                data.put(Key_g4,g4x);
                data.put(Key_G4,G4x);

                data.put(Key_h,hx);
                data.put(Key_H,Hx);
                data.put(Key_h1,h1x);
                data.put(Key_H1,H1x);
                data.put(Key_h2,h2x);
                data.put(Key_H2,H2x);
                data.put(Key_h3,h3x);
                data.put(Key_H3,H3x);
                data.put(Key_h4,h4x);
                data.put(Key_H4,H4x);

                data.put(Key_i,ix);
                data.put(Key_I,Ix);
                data.put(Key_i1,i1x);
                data.put(Key_I1,I1x);
                data.put(Key_i2,i2x);
                data.put(Key_I2,I2x);
                data.put(Key_i3,i3x);
                data.put(Key_I3,I3x);
                data.put(Key_i4,i4x);
                data.put(Key_I4,I4x);

                data.put(Key_j,jx);
                data.put(Key_J,Jx);
                data.put(Key_j1,j1x);
                data.put(Key_J1,J1x);
                data.put(Key_j2,j2x);
                data.put(Key_J2,J2x);
                data.put(Key_j3,j3x);
                data.put(Key_J3,J3x);
                data.put(Key_j4,j4x);
                data.put(Key_J4,J4x);

                data.put(Key_subjects,subnamexx);


                db.collection(upusnx).document("attendance").collection("subjects").document(subrankxx).set(data)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(),"Saved Sucessfully",Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Cant create database",Toast.LENGTH_SHORT).show();
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
