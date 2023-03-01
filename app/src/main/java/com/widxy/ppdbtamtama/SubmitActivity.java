package com.widxy.ppdbtamtama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.net.IDN;


public class SubmitActivity extends AppCompatActivity {

    TextView tvLihatId, tvLihatNama, tvLihatJk, tvLihatTanggal, tvLihatTempat, tvLihatAgama, tvLihatNIK, tvLihatNo,
            tvLihatLongitude, tvLihatLatitude, tvlihatAlamat, tvlihatUrl, tvLihatNamaSekolah,
            tvLihatNamaKepsek, tvLihatNis, tvLihatNisn, tvLihatStatus, tvLihatTahun, tvlihatNem,
            tvLihatAlamatSek, tvLihatJurusan1, tvLihatJurusan2;
    SessionManager sessionManager;
    String id, nama, jk, tanggal, tempat, agama, nik, no, longitude, latitude, alamat, url, namasekolah,
            namakepsek, nis, nisn, status, tahun, nem, alamatsek, jurusan1, jurusan2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        sessionManager = new SessionManager(SubmitActivity.this);

        tvLihatId = findViewById(R.id.tvLihatID);
        tvLihatNama = findViewById(R.id.tvLihatNama);
        tvLihatJk = findViewById(R.id.tvLihatJk);
        tvLihatTanggal = findViewById(R.id.tvLihatTanggal);
        tvLihatTempat = findViewById(R.id.tvLihatTempat);
        tvLihatAgama = findViewById(R.id.tvLihatAgama);
        tvLihatNIK = findViewById(R.id.tvLihatNik);
        tvLihatNo = findViewById(R.id.tvLihatNo);
        tvLihatLongitude = findViewById(R.id.tvLihatLongitude);
        tvLihatLatitude = findViewById(R.id.tvLihatLatitude);
        tvlihatAlamat = findViewById(R.id.tvLihatAlamat);
        tvlihatUrl = findViewById(R.id.tvLihatUrl);
        tvLihatNamaSekolah = findViewById(R.id.tvLihatNamaSekolah);
        tvLihatNamaKepsek = findViewById(R.id.tvLihatNamaKepsek);
        tvLihatNis = findViewById(R.id.tvLihatNis);
        tvLihatNisn = findViewById(R.id.tvLihatNisn);
        tvLihatStatus = findViewById(R.id.tvLihatStatus);
        tvLihatTahun = findViewById(R.id.tvLihatTahun);
        tvlihatNem = findViewById(R.id.tvLihatNem);
        tvLihatAlamatSek = findViewById(R.id.tvLihatAlamatSek);
        tvLihatJurusan1 = findViewById(R.id.tvLihatJurusan1);
        tvLihatJurusan2 = findViewById(R.id.tvLihatJurusan2);

        id = sessionManager.getLihatDetail().get(SessionManager.LIHAT_ID);
        nama = sessionManager.getLihatDetail().get(SessionManager.LIHAT_NAMA);
        jk = sessionManager.getLihatDetail().get(SessionManager.LIHAT_JK);
        tanggal = sessionManager.getLihatDetail().get(SessionManager.LIHAT_TANGGAL);
        tempat = sessionManager.getLihatDetail().get(SessionManager.LIHAT_TEMPAT);
        agama = sessionManager.getLihatDetail().get(SessionManager.LIHAT_AGAMA);
        nik = sessionManager.getLihatDetail().get(SessionManager.LIHAT_NIK);
        no = sessionManager.getLihatDetail().get(SessionManager.LIHAT_NO);
        longitude = sessionManager.getLihatDetail().get(SessionManager.LIHAT_LONGITUDE);
        latitude = sessionManager.getLihatDetail().get(SessionManager.LIHAT_LATITUDE);
        alamat = sessionManager.getLihatDetail().get(SessionManager.LIHAT_ALAMAT);
        url = sessionManager.getLihatDetail().get(SessionManager.LIHAT_URL);
        namasekolah = sessionManager.getLihatDetail().get(SessionManager.LIHAT_NAMA_SEKOLAH);
        namakepsek = sessionManager.getLihatDetail().get(SessionManager.LIHAT_NAMA_KEPALA_SEKOLAH);
        nis = sessionManager.getLihatDetail().get(SessionManager.LIHAT_NIS);
        nisn = sessionManager.getLihatDetail().get(SessionManager.LIHAT_NISN);
        status= sessionManager.getLihatDetail().get(SessionManager.LIHAT_STATUS_SEKOLAH);
        tahun = sessionManager.getLihatDetail().get(SessionManager.LIHAT_TAHUN_LULUS);
        nem = sessionManager.getLihatDetail().get(SessionManager.LIHAT_NEM);
        alamatsek = sessionManager.getLihatDetail().get(SessionManager.LIHAT_ALAMAT_SEKOLAH);
        jurusan1 = sessionManager.getLihatDetail().get(SessionManager.LIHAT_JURUSAN1);
        jurusan2 = sessionManager.getLihatDetail().get(SessionManager.LIHAT_JURUSAN2);

        tvLihatId.setText(id);
        tvLihatNama.setText(nama);
        tvLihatJk.setText(jk);
        tvLihatTanggal.setText(tanggal);
        tvLihatTempat.setText(tempat);
        tvLihatAgama.setText(agama);
        tvLihatNIK.setText(nik);
        tvLihatNo.setText(no);
        tvLihatLongitude.setText(longitude);
        tvLihatLatitude.setText(latitude);
        tvlihatAlamat.setText(alamat);
        tvlihatUrl.setText(url);
        tvLihatNamaSekolah.setText(namasekolah);
        tvLihatNamaKepsek.setText(namakepsek);
        tvLihatNis.setText(nis);
        tvLihatNisn.setText(nisn);
        tvLihatStatus.setText(status);
        tvLihatTahun.setText(tahun);
        tvlihatNem.setText(nem);
        tvLihatAlamatSek.setText(alamatsek);
        tvLihatJurusan1.setText(jurusan1);
        tvLihatJurusan2.setText(jurusan2);
    }

    private void moveToLogin() {
        Intent intent = new Intent(SubmitActivity.this, LoginActivity.class);
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