package com.example.kiemtra2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
    EditText hinhanh, luuy, lieudung, congdung, dactinh, tenthuonggoi, tenkhoahoc;
    Button themthuoc;

    FirebaseFirestore fdb = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initID();


        themthuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> thuoctay = new HashMap<>();

                thuoctay.put("tenkhoahoc", tenkhoahoc.getText().toString().trim());
                thuoctay.put("tenthuonggoi", tenthuonggoi.getText().toString().trim());
                thuoctay.put("dactinh", dactinh.getText().toString().trim());
                thuoctay.put("congdung", congdung.getText().toString().trim());
                thuoctay.put("lieudung", lieudung.getText().toString().trim());
                thuoctay.put("luuy", luuy.getText().toString().trim());
                thuoctay.put("hinhanh", hinhanh.getText().toString().trim());

                fdb.collection("thuoctay").add(thuoctay).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(AddActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddActivity.this, MainActivity.class));
                    }
                });

            }
        });



    }

    public void initID() {
        hinhanh = findViewById(R.id.hinhanh);
        luuy = findViewById(R.id.luuy);
        lieudung = findViewById(R.id.lieudung);
        congdung = findViewById(R.id.congdung);
        dactinh = findViewById(R.id.dactinh);
        tenthuonggoi = findViewById(R.id.tenthuonggoi);
        tenkhoahoc = findViewById(R.id.tenkhoahoc);
        themthuoc = findViewById(R.id.themthuoc);
    }


}