package com.widxy.ppdbtamtama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.widxy.ppdbtamtama.api.ApiClient;
import com.widxy.ppdbtamtama.api.ApiInterface;
import com.widxy.ppdbtamtama.model.alamat.Alamat;
import com.widxy.ppdbtamtama.model.alamat.AlamatData;
import com.widxy.ppdbtamtama.model.jurusan.Jurusan;
import com.widxy.ppdbtamtama.model.jurusan.JurusanData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JurusanActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    SessionManager sessionManager;

    EditText etJurIdSiswa;
    Button btnKirim;
    String JurId, Jur1, Jur2;
    ApiInterface apiInterface;

    Spinner etJur1, etJur2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurusan);

        etJurIdSiswa = findViewById(R.id.etJurIdSiswa);

        etJur1 = findViewById(R.id.etJur1);
        etJur2 = findViewById(R.id.etJur2);

        Spinner spinner = findViewById(R.id.etJur1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.jurusan, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner2 = findViewById(R.id.etJur2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.jurusan, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        btnKirim = findViewById(R.id.btnKirim);
        btnKirim.setOnClickListener(this);

        sessionManager = new SessionManager(JurusanActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }
        JurId = sessionManager.getDataDetail().get(SessionManager.IDPENDAFTARAN);
        etJurIdSiswa.setText(JurId);
    }

    private void moveToLogin() {
        Intent intent = new Intent(JurusanActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnKirim:
                JurId = etJurIdSiswa.getText().toString();
                Jur1 = etJur1.getSelectedItem().toString();
                Jur2 = etJur2.getSelectedItem().toString();
                jurusan(JurId, Jur1, Jur2);
                break;
            case R.id.tvLoginHere:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void jurusan(String jurId, String jur1, String jur2) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Jurusan> call = apiInterface.jurusanResponse(jurId, jur1, jur2);
        call.enqueue(new Callback<Jurusan>() {
            @Override
            public void onResponse(Call<Jurusan> call, Response<Jurusan> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    sessionManager = new SessionManager(JurusanActivity.this);
                    JurusanData jurusanData = response.body().getJurusanData();
                    sessionManager.createJurusanSession(jurusanData);

                    Toast.makeText(JurusanActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(JurusanActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(JurusanActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Jurusan> call, Throwable t) {
                Toast.makeText(JurusanActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}