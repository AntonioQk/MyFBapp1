package com.example.myfbapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.BreakIterator;
import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {
    LocalDateTime datetime =LocalDateTime.now();
    private TextView TextViewmytext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextView mytext= (TextView) findViewById(R.id.text_inicio);
        TextView texto = findViewById(R.id.input);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("message1");
        myRef.setValue("Hello, World android firebase!");

        DatabaseReference myRef1 = database.getReference("message2");
        myRef1.setValue("TecChina, Juan antonio cu cauich!");

        DatabaseReference myRef2 = database.getReference("messages").child("asunto");
        myRef2.setValue("Firebase!!!");

        DatabaseReference myRef3 = database.getReference("messages").child("mensaje");
        myRef3.setValue("Firebase desde Tec China!");

        DatabaseReference myRef4 = database.getReference("email").child("De");
        myRef4.setValue("Juan antonio");

        DatabaseReference myRef5 = database.getReference("email").child("Correo de");
        myRef5.setValue("juan@gmail.com");

        DatabaseReference myRef6 = database.getReference("email").child("Para");
        myRef6.setValue("caamal.edgar@gmail.com");

        DatabaseReference myRef7 = database.getReference("email").child("Asunto");
        myRef7.setValue("Solicitamos apoyo para acceder a la plataforma office");

        DatabaseReference myRef8 = database.getReference("email").child("Fecha");
        myRef8.setValue(datetime);

        DatabaseReference myref9 = database.getReference("input");
        myref9.setValue(texto);

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            private static final String TAG = "1";

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Context context= getApplicationContext();
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
                Toast.makeText(context, "Estoy en : " + value, Toast.LENGTH_SHORT).show();
                //mytext.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }
}