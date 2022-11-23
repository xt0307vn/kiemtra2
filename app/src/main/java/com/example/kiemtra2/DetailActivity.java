package com.example.kiemtra2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class DetailActivity extends AppCompatActivity {
    TextView tenkhoahoc, tenthuonggoi, dactinh, congdung, lieudung, luuy;
    ImageView hinhanh;

    FirebaseFirestore fdb = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initID();
        Bundle bundle = getIntent().getBundleExtra("thuoctay");
        if(bundle != null) {
            fdb.collection("thuoctay").document(bundle.getString("idThuoctay"))
                    .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.isSuccessful()) {
                                DocumentSnapshot documentSnapshot = task.getResult();
                                ThuocTay thuocTay = documentSnapshot.toObject(ThuocTay.class);
                                tenkhoahoc.setText(thuocTay.getTenkhoahoc());
                                tenthuonggoi.setText(thuocTay.getTenthuonggoi());
                                dactinh.setText(thuocTay.getDactinh());
                                congdung.setText(thuocTay.getCongdung());
                                lieudung.setText(thuocTay.getLieudung());
                                luuy.setText(thuocTay.getLuuy());
                                Glide.with(getApplicationContext()).load(thuocTay.getHinhanh()).into(hinhanh);
                            }
                        }
                    });
        }



    }

    public void initID() {
        tenkhoahoc = findViewById(R.id.tenkhoahoc);
        tenthuonggoi = findViewById(R.id.tenthuonggoi);
        dactinh = findViewById(R.id.dactinh);
        congdung = findViewById(R.id.congdung);
        lieudung = findViewById(R.id.lieudung);
        luuy = findViewById(R.id.luuy);
        hinhanh = findViewById(R.id.hinhanh);
    }


}