package com.example.kiemtra2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageButton gotoadd;
    RecyclerView main_rcv;
    ThuocTayAdapter thuocTayAdapter;
    List<ThuocTay> thuocTays;

    FirebaseFirestore fdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fdb = FirebaseFirestore.getInstance();
        initID();


        main_rcv = findViewById(R.id.main_rcv);

        thuocTays = new ArrayList<>();
        thuocTayAdapter = new ThuocTayAdapter(this, thuocTays);

        main_rcv.setLayoutManager(new LinearLayoutManager(this));
        main_rcv.setAdapter(thuocTayAdapter);

        showData();

        gotoadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));
            }
        });

        ThuocTay thuocTay = new ThuocTay("aa", "aa", "aa", "aa", "aa", "aa", "aa");





    }

    public void showData() {
        thuocTays.clear();
        fdb.collection("thuoctay").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                        ThuocTay thuocTay = documentSnapshot.toObject(ThuocTay.class);
                        thuocTay.setIdthuoctay(documentSnapshot.getId());
                        thuocTays.add(thuocTay);
                    }
                    thuocTayAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    public void initID() {
        gotoadd = findViewById(R.id.gotoadd);
    }
}