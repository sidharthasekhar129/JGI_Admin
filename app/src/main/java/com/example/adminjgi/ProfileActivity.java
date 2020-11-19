package com.example.adminjgi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ProfileActivity extends AppCompatActivity {
    private ImageView back,profilepic;
    String pplinkx;
    private UploadTask uploadTask;
    String idx;
    private static final String TAG="ProfileActivity";
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private static final String Key_mail="mail";
    private static final String Key_passcode="passcode";
    private static final String Key_password="password";

    private static final String Key_mobile="mobile";
    private static final String Key_name="name";
    private static final String Key_id="id";
    private static final String key_pplink="PPLink1";
    private StorageReference mStorageRef;
    private TextView mail,name,id,mobno,password,passcode,qualification,headid,headmail,headname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mStorageRef = FirebaseStorage.getInstance().getReference("Images");

        mail=(TextView)findViewById(R.id.mail);
        name=(TextView)findViewById(R.id.name);
        id=(TextView)findViewById(R.id.id);
        mobno=(TextView)findViewById(R.id.mobno);
        password=(TextView)findViewById(R.id.password);
        passcode=(TextView)findViewById(R.id.passcode);
        qualification=(TextView)findViewById(R.id.qualification);
        headid=(TextView)findViewById(R.id.headid);
        headmail=(TextView)findViewById(R.id.headmail);
        headname=(TextView)findViewById(R.id.headname);

        back=(ImageView)findViewById(R.id.back);
        profilepic=(ImageView)findViewById(R.id.profilepic);
        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // filechooser();
                //fileuploader();
                selectImage();
            }
        });
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
        String mailZ = getIntent().getStringExtra("mail");
        db.collection(mailZ).document("profile").get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        String mailx=documentSnapshot.getString(Key_mail);
                        String passcodex=documentSnapshot.getString(Key_passcode);
                        String passwordx=documentSnapshot.getString(Key_password);
                        String mobilex=documentSnapshot.getString(Key_mobile);
                        String namex=documentSnapshot.getString(Key_name);
                          idx=documentSnapshot.getString(Key_id);
                          pplinkx=documentSnapshot.getString(key_pplink);
                        mail.setText(mailx);
                        name.setText(namex);
                        id.setText(idx);

                        headmail.setText(mailx);
                        headname.setText(namex);
                        headid.setText(idx);

                        mobno.setText(mobilex);
                        passcode.setText(passcodex);
                        password.setText(passwordx);
                        if (pplinkx.isEmpty())
                        {
                            Toast.makeText(getApplicationContext(),"Upload a profile pic.",Toast.LENGTH_SHORT).show();
                        }else {


                            //String imageUri = "https://i.imgur.com/tGbaZCY.jpg";
                            // ImageView ivBasicImage = (ImageView) findViewById(R.id.ivBasicImage);
                            Glide.with(getApplicationContext()).load(pplinkx).into(profilepic);
                        }





                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }


    private void selectImage() {
        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo"))
                {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent, 1);
                }
                else if (options[item].equals("Choose from Gallery"))
                {
                    Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                }
                else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),
                            bitmapOptions);
                    profilepic.setImageBitmap(bitmap);
                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == 2) {
                Uri selectedImage = data.getData();
                profilepic.setImageURI(selectedImage);
                final StorageReference riversRef = mStorageRef.child(idx);

                try {
                    uploadTask =  riversRef.putFile(selectedImage);
                }
                catch (Exception e)
                { }


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

                            String mailget=getIntent().getStringExtra("mail");
                            DocumentReference noteref=db.collection(mailget).document("profile");
                            noteref.update(key_pplink,link1);
                            Toast.makeText(getApplicationContext(), "Uploaded sucessfully",Toast.LENGTH_SHORT).show();

                        }

                    }
                });


            }
        }
    }
}
