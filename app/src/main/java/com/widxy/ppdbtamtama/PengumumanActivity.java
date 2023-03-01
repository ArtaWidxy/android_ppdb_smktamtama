package com.widxy.ppdbtamtama;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PengumumanActivity extends AppCompatActivity {
    TextView tvKode, tvNama, tvStatus, tvJurusan;
    String kode, nama, status, jurusan;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengumuman);
        sessionManager = new SessionManager(PengumumanActivity.this);

        tvKode = findViewById(R.id.tvKodeDaf);
        tvNama = findViewById(R.id.tvNama);
        tvStatus = findViewById(R.id.tvStatus);
        tvJurusan = findViewById(R.id.tvJurusan);

        kode = sessionManager.getPengumumanDetail().get(SessionManager.PENG_KODE);
        nama = sessionManager.getPengumumanDetail().get(SessionManager.PENG_NAMA);
        status = sessionManager.getPengumumanDetail().get(SessionManager.PENG_STATUS);
        jurusan = sessionManager.getPengumumanDetail().get(SessionManager.PENG_JUR);

        tvKode.setText(kode);
        tvNama.setText(nama);
        tvStatus.setText(status);
        tvJurusan.setText(jurusan);
    }

    private void moveToLogin() {
        Intent intent = new Intent(PengumumanActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.actionLogout:
                sessionManager.logoutSession();
                moveToLogin();
        }
        return super.onOptionsItemSelected(item);
    }
}