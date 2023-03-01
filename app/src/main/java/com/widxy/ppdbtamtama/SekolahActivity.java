package com.widxy.ppdbtamtama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.widxy.ppdbtamtama.api.ApiClient;
import com.widxy.ppdbtamtama.api.ApiInterface;
import com.widxy.ppdbtamtama.model.alamat.Alamat;
import com.widxy.ppdbtamtama.model.alamat.AlamatData;
import com.widxy.ppdbtamtama.model.sekolah.Sekolah;
import com.widxy.ppdbtamtama.model.sekolah.SekolahData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SekolahActivity extends AppCompatActivity implements View.OnClickListener {

    SessionManager sessionManager;

    EditText etAsNama, etAsNamaKepsek, etAsNis, etAsNisn, etAsStatus, etAsTahun, etAsNem, etAsAlamat, etAsId;
    String Id, Nama, Kepsek, Nis, Nisn, Status, Tahun, Nem, Alamat;
    Button btnKirim;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekolah);

        etAsId = findViewById(R.id.etAsIdSiswa);
        etAsNama = findViewById(R.id.etAsNama);
        etAsNamaKepsek = findViewById(R.id.etAsNamaKepsek);
        etAsStatus = findViewById(R.id.etAsStatus);
        etAsTahun = findViewById(R.id.etAsTahun);
        etAsNem = findViewById(R.id.etAsNem);
        etAsAlamat = findViewById(R.id.etAsNpsn);

        btnKirim = findViewById(R.id.btnKirim);
        btnKirim.setOnClickListener(this);

        sessionManager = new SessionManager(SekolahActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }
        Id = sessionManager.getDataDetail().get(SessionManager.IDPENDAFTARAN);
        etAsId.setText(Id);
    }

    private void moveToLogin() {
        Intent intent = new Intent(SekolahActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnKirim:
                Id = etAsId.getText().toString();
                Nama = etAsNama.getText().toString();
                Kepsek = etAsNamaKepsek.getText().toString();
                Status = etAsStatus.getText().toString();
                Tahun = etAsTahun.getText().toString();
                Nem = etAsNem.getText().toString();
                Alamat = etAsAlamat.getText().toString();
                sekolah(Id, Nama, Kepsek,Status, Tahun, Nem, Alamat);
                break;
            case R.id.tvLoginHere:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void sekolah(String id, String nama, String kepsek, String status, String tahun, String nem, String alamat) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Sekolah> call = apiInterface.sekolahResponse(id, nama, kepsek, status, tahun, nem, alamat);
        call.enqueue(new Callback<Sekolah>() {
            @Override
            public void onResponse(Call<Sekolah> call, Response<Sekolah> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    sessionManager = new SessionManager(SekolahActivity.this);
                    SekolahData sekolahData = response.body().getSekolahData();
                    sessionManager.createSekolahSession(sekolahData);

                    Toast.makeText(SekolahActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SekolahActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SekolahActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Sekolah> call, Throwable t) {
                Toast.makeText(SekolahActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}