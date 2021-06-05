package com.noerkhalidah.utspraktik_if2_10118077_noerkhalidahmiskiyah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class FormData extends AppCompatActivity {
    public static final String nama = "com.noerkhalidah.utspraktik_if2_10118077_noerkhalidahmiskiyah.nama";
    public static final String nik = "com.noerkhalidah.utspraktik_if2_10118077_noerkhalidahmiskiyah.nik";
    public static final String ttl = "com.noerkhalidah.utspraktik_if2_10118077_noerkhalidahmiskiyah.ttl";
    public static final String jk = "com.noerkhalidah.utspraktik_if2_10118077_noerkhalidahmiskiyah.jk";
    public static final String hubungan = "com.noerkhalidah.utspraktik_if2_10118077_noerkhalidahmiskiyah.hubungan";
    public static final String status = "com.noerkhalidah.utspraktik_if2_10118077_noerkhalidahmiskiyah.status";

    private Dialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_data);

        Intent intent = getIntent();
        Intent intent2 = new Intent(this,MainActivity.class);

        String nik = intent.getStringExtra(MainActivity.nik);
        String nama = intent.getStringExtra(MainActivity.nama);
        String jk = intent.getStringExtra(MainActivity.jk);
        String tgl = intent.getStringExtra(MainActivity.ttl);
        String hub = intent.getStringExtra(MainActivity.hubungan);

        TextView tvNik = findViewById(R.id.j_nik);
        TextView tvNama = findViewById(R.id.j_nama);
        TextView tvTgl = findViewById(R.id.j_tgl);
        TextView tvHub = findViewById(R.id.j_hub);
        TextView tvJk = findViewById(R.id.j_jk);
        Button btn_simpan= findViewById(R.id.btn_simpan);
        Button btn_ubah= findViewById(R.id.btn_ubah);



        tvNik.setText(nik);
        tvNama.setText(nama);
        tvTgl.setText(tgl);
        tvJk.setText(jk);
        tvHub.setText(hub);
        initCustomDialog();

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.show();
            }
        });

        btn_ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2.putExtra(status,"ubah");
                intent2.putExtra(nik,nik);
                intent2.putExtra(nama,nama);
                intent2.putExtra(ttl,tgl);
                intent2.putExtra(jk,jk);
                intent2.putExtra(jk,hub);

//                if (hub == "Orang Tua"){
//                    intent2.putExtra(Extra_hub,"hbg_ort");
//                }

                startActivity(intent2);
            }
        });
    }

    private void initCustomDialog(){

        customDialog = new Dialog(FormData.this);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setContentView(R.layout.dialog_simpan);
        customDialog.setCancelable(true);



        Button btnok = customDialog.findViewById(R.id.btn_ok);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customDialog.dismiss();
            }
        });
    }
}