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
import com.widxy.ppdbtamtama.model.jurusan.Jurusan;
import com.widxy.ppdbtamtama.model.jurusan.JurusanData;
import com.widxy.ppdbtamtama.model.pendaftaran.Pendaftaran;
import com.widxy.ppdbtamtama.model.pendaftaran.PendaftaranData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatusActivity extends AppCompatActivity implements View.OnClickListener {

    EditText iddaftar, statusdaftar;
    String idPendaf, statusPendaf;
    Button btnGo;
    ApiInterface apiInterface;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        iddaftar = findViewById(R.id.etIdPendaftar);
        statusdaftar = findViewById(R.id.etPendaftarStatus);

        btnGo = findViewById(R.id.btnGo);
        btnGo.setOnClickListener(this);

        sessionManager = new SessionManager(StatusActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }
        idPendaf = sessionManager.getJurusanDetail().get(sessionManager.ID_JUR_ID);
        iddaftar.setText(idPendaf);
    }

    private void moveToLogin() {
        Intent intent = new Intent(StatusActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGo:
                idPendaf = iddaftar.getText().toString();
                statusPendaf = statusdaftar.getText().toString();
                pendaftaran(idPendaf, statusPendaf);
                break;
            case R.id.tvLoginHere:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void pendaftaran(String idPendaf, String statusPendaf) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Pendaftaran> call = apiInterface.pendaftaranResponse(idPendaf, statusPendaf);
        call.enqueue(new Callback<Pendaftaran>() {
            @Override
            public void onResponse(Call<Pendaftaran> call, Response<Pendaftaran> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    sessionManager = new SessionManager(StatusActivity.this);
                    PendaftaranData pendaftaranData = response.body().getPendaftaranData();
                    sessionManager.createPendaftaranSession(pendaftaranData);

                    Toast.makeText(StatusActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(StatusActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(StatusActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Pendaftaran> call, Throwable t) {
                Toast.makeText(StatusActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}