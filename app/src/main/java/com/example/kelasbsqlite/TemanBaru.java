package com.example.kelasbsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kelasbsqlite.database.DBController;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class TemanBaru extends AppCompatActivity {
    private TextInputEditText tNama,tTelpon;
    private Button simpanBtn;
    String nm,tlp;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_baru);
        tNama = (TextInputEditText) findViewById(R.id.ednama);
        tTelpon = (TextInputEditText) findViewById(R.id.edtlp);
        simpanBtn = (Button) findViewById(R.id.buttonsev);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tNama.getText().equals("") ||tTelpon.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Data Belum Lengkap !!!",Toast.LENGTH_SHORT).show();
                }else {
                    nm = tNama.getText().toString();
                    tlp = tTelpon.getText().toString();
                    HashMap<String,String> qvalues = new HashMap<>();
                    qvalues.put("nama",nm);
                    qvalues.put("telpon",tlp);

                    controller.InsertData(qvalues);
                    callHome();
                }
            }
        });

    }
    //Membuat sebuah method untuk memanggil act
    public void callHome(){
        Intent intent = new Intent(TemanBaru.this, com.example.kelasbsqlite.MainActivity.class);
        startActivity(intent);
        finish();
    }
}