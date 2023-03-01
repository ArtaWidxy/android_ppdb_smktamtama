package com.widxy.ppdbtamtama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.widxy.ppdbtamtama.api.ApiClient;
import com.widxy.ppdbtamtama.api.ApiInterface;
import com.widxy.ppdbtamtama.model.lihat.Lihat;
import com.widxy.ppdbtamtama.model.lihat.LihatData;
import com.widxy.ppdbtamtama.model.pengumuman.Pengumuman;
import com.widxy.ppdbtamtama.model.pengumuman.PengumumanData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnKirim, btnSubmit, btnSekolah, btnJurusan, btnAll, btnPengumuman;
    TextView etKode_Pendaftar, etUsername, etEmail, etCardUser, etTvid, etLihatId;
    SessionManager sessionManager;
    String KodePendaftar, Username, Email, Id, KDDaf, idPendaf;

    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManager = new SessionManager(MainActivity.this);

        btnPengumuman = findViewById(R.id.btnPengumuman);
        btnPengumuman.setOnClickListener(this);

        btnAll = findViewById(R.id.btnDaftar5);
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StatusActivity.class);
                startActivity(intent);
            }
        });

        btnJurusan = findViewById(R.id.btnDaftar3);
        btnJurusan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, JurusanActivity.class);
                startActivity(intent);
            }
        });

        btnSekolah = findViewById(R.id.btnDaftar2);
        btnSekolah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SekolahActivity.class);
                startActivity(intent);
            }
        });

        btnSubmit = findViewById(R.id.btnDaftar4);
        btnSubmit.setOnClickListener(this);

        btnKirim = findViewById(R.id.btnDaftar);
        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DataActivity.class);
                startActivity(intent);
            }
        });

        sessionManager = new SessionManager(MainActivity.this);

        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }

        etTvid = findViewById(R.id.tvId);
        etUsername = findViewById(R.id.tvUsername);
        etKode_Pendaftar = findViewById(R.id.tvKodePendaftaran);
        etEmail = findViewById(R.id.tvEmail);
        etCardUser = findViewById(R.id.cardUser);

        etLihatId = findViewById(R.id.tvId);


        Id = sessionManager.getUserDetail().get(SessionManager.USER_ID);
        Username = sessionManager.getUserDetail().get(SessionManager.USERNAME);
        Email = sessionManager.getUserDetail().get(SessionManager.EMAIL);
        KodePendaftar = sessionManager.getUserDetail().get(SessionManager.KODE_PENDAFTAR);


        etLihatId.setText(Id);
        etTvid.setText(Id);
        etUsername.setText(Username);
        etEmail.setText(Email);
        etKode_Pendaftar.setText(KodePendaftar);
        etCardUser.setText(Username);
    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPengumuman:
                KDDaf = etKode_Pendaftar.getText().toString();
                pengumuman(KDDaf);
                break;
            case R.id.btnDaftar4:
                KDDaf = etKode_Pendaftar.getText().toString();
                lihat(KDDaf);
                break;
        }
    }

    private void lihat(String kdDaf) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Lihat> call = apiInterface.lihatResponse(kdDaf);
        call.enqueue(new Callback<Lihat>() {
            @Override
            public void onResponse(Call<Lihat> call, Response<Lihat> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    sessionManager = new SessionManager(MainActivity.this);
                    LihatData lihatData = response.body().getLihatData();
                    sessionManager.createLihatSession(lihatData);

                    Toast.makeText(MainActivity.this, response.body().getLihatData().getKode_pendaftar(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SubmitActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Lihat> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void pengumuman(String kdDaf) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Pengumuman> call = apiInterface.pengumumanResponse(kdDaf);
        call.enqueue(new Callback<Pengumuman>() {
            @Override
            public void onResponse(Call<Pengumuman> call, Response<Pengumuman> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    sessionManager = new SessionManager(MainActivity.this);
                    PengumumanData pengumumanData = response.body().getPengumumanData();
                    sessionManager.createPengumumanSession(pengumumanData);

                    //Ini untuk pindah
                    Toast.makeText(MainActivity.this, response.body().getPengumumanData().getStatus(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, PengumumanActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Pengumuman> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}