package com.example.adminjgi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class StudyMaterials extends AppCompatActivity {
private ImageView back ;
    private StorageReference mStorageRef;
private EditText subname,subrank,materialname,materialno,stream,acyear;
private Button send,select;
private TextView pdfname;
private static String path;
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    String subnamexx;
    String subrankxx;
    String materialnamexx;
    String materialnoxx;
    String streamxx;
    String acyearxx;
   private UploadTask uploadTask;
   private Uri uri;

    private static final String TAG="StudyMaterials";

    private static final String keyNotes1="notes1";
    private static final String keyNotes2="notes2";
    private static final String keyNotes3="notes3";
    private static final String keyNotes4="notes4";
    private static final String keyNotes5="notes5";
    private static final String keyNotes6="notes6";
    private static final String keyNotes7="notes7";
    private static final String keyNotes8="notes8";
    private static final String keyNotes9="notes9";
    private static final String keyNotes10="notes10";
    private static final String keyNotes11="notes11";
    private static final String keyNotes12="notes12";
    private static final String keyNotes13="notes13";
    private static final String keyNotes14="notes14";
    private static final String keyNotes15="notes15";
    private static final String keyNotes16="notes16";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_materials);

        back=(ImageView)findViewById(R.id.back);

        subname=(EditText)findViewById(R.id.subjectname);
        subrank=(EditText)findViewById(R.id.subjectrank);
        materialname=(EditText)findViewById(R.id.materialname);
        materialno=(EditText)findViewById(R.id.materialno);
        stream=(EditText)findViewById(R.id.stream);
        acyear=(EditText)findViewById(R.id.academic_year);

        pdfname=(TextView)findViewById(R.id.pdfname);

        select=(Button)findViewById(R.id.selectfile);
        send=(Button)findViewById(R.id.send);




        mStorageRef = FirebaseStorage.getInstance().getReference("Studtmaterial");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String subnamex=subname.getText().toString();
                 String subrankx=subrank.getText().toString();
                String  materialnamex=materialname.getText().toString();
                  String materialnox=materialno.getText().toString();
                  String streamx=stream.getText().toString();
                  String acyearx=acyear.getText().toString();
                if (subnamex.isEmpty())
                {
                    subname.setError("Fill out this field");
                    subname.requestFocus();
                    return;
                }
                if (subrankx.isEmpty())
                {
                    subrank.setError("Fill out this field");
                    subrank.requestFocus();
                    return;
                }
                if (materialnamex.isEmpty())
                {
                    materialname.setError("Fill out this field");
                    materialname.requestFocus();
                    return;
                }
                if (materialnox.isEmpty())
                {
                    materialno.setError("Fill out this field");
                    materialno.requestFocus();
                    return;
                }
                if (streamx.isEmpty())
                {
                    stream.setError("Fill out this field");
                    stream.requestFocus();
                    return;
                }

                if (acyearx.isEmpty())
                {
                    acyear.setError("Fill out this field");
                    acyear.requestFocus();
                    return;
                }
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                path=intent.getStringExtra("path");
                intent.putExtra("path",path);
                intent.setType("application/pdf");
                startActivityForResult(intent,1);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String subnamexx=subname.getText().toString();
        final String subrankxx=subrank.getText().toString();
        String  materialnamexx=materialname.getText().toString();
        String materialnoxx=materialno.getText().toString();
        final String streamxx=stream.getText().toString();
        final String streamxxx=streamxx.toUpperCase();
        final String acyearxx=acyear.getText().toString();

        if (requestCode==1 && resultCode==RESULT_OK && data!=null)
        {
            Uri  uri=data.getData();
            String uriString=uri.toString();
            File myFile=new File(uriString);
            String path=myFile.getAbsolutePath();
            String displayname=null;

                displayname=myFile.getName();
                pdfname.setText(myFile.getName());
            final StorageReference riversRef = mStorageRef.child(streamxxx);
            try {
                 uploadTask =  riversRef.putFile(uri);
            }
            catch (Exception e)
            {

            }

            Task<Uri> uriTask=uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful())
                    {

                        throw task.getException();
                    }
                    return riversRef.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful())
                    {
                        Uri durl=task.getResult();
                        String link1=durl.toString();



                       Map<String,Object> note=new HashMap<>();
                        note.put(keyNotes1,link1);

                        DocumentReference noteref=db.collection("Studymaterial").document(streamxxx).
                                collection(acyearxx).document(subrankxx);
                        noteref.set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(), "Uploaded sucessfully",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });



                    }

                }
            });

        }

    }
}
