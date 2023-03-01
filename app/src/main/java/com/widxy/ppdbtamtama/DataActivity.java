package com.widxy.ppdbtamtama;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.widxy.ppdbtamtama.api.ApiClient;
import com.widxy.ppdbtamtama.api.ApiInterface;
import com.widxy.ppdbtamtama.model.data.Data;
import com.widxy.ppdbtamtama.model.data.DataData;
import com.widxy.ppdbtamtama.model.login.LoginData;
import com.widxy.ppdbtamtama.model.register.Register;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    SessionManager sessionManager;
    Spinner etJk;
    String KD, Nama, JenisKelamin, Tempat, Tanggal, Agama, NIK, NoTelp, Email, Kode, ID, Alamat, Nis, Nisn;
    TextView tvDate;
    Button btnKirim;
    EditText etNama, etJenis, etTempat, etTanggal, etAgama, etNIK, etNotelp, etEmail, etTvid, etId, etAlamat, etNis, etNisn;
    ApiInterface apiInterface;

    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Spinner spinner = findViewById(R.id.etJk);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        etJk = findViewById(R.id.etJk);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvDate = findViewById(R.id.tv_date);
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        DataActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                        setListener,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                tvDate.setText(date);
            }
        };

        etId = findViewById(R.id.etIdP);
        etNama = findViewById(R.id.etNama);
        etTempat = findViewById(R.id.etTempat);
        etAgama = findViewById(R.id.etAgama);
        etNIK = findViewById(R.id.etNIK);
        etNotelp = findViewById(R.id.etNoTelp);
        etEmail = findViewById(R.id.etEmail);
        etAlamat = findViewById(R.id.etAlamat);
        etNis = findViewById(R.id.etNis);
        etNisn = findViewById(R.id.etNisn);

        btnKirim = findViewById(R.id.btnKirim);
        btnKirim.setOnClickListener(this);

        sessionManager = new SessionManager(DataActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }

        etTvid = findViewById(R.id.etKode);
        Kode = sessionManager.getUserDetail().get(SessionManager.KODE_PENDAFTAR);
        etTvid.setText(Kode);
    }

    private void moveToLogin() {
        Intent intent = new Intent(DataActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnKirim:
                ID = etId.getText().toString();
                KD = etTvid.getText().toString();
                Nama = etNama.getText().toString();
                Nis = etNis.getText().toString();
                Nisn = etNisn.getText().toString();
                JenisKelamin = etJk.getSelectedItem().toString();
                Tempat = etTempat.getText().toString();
                Tanggal = tvDate.getText().toString();
                Agama = etAgama.getText().toString();
                NIK = etNIK.getText().toString();
                NoTelp = etNotelp.getText().toString();
                Email = etEmail.getText().toString();
                Alamat = etAlamat.getText().toString();
                data(ID, KD, Nama, Nis, Nisn, JenisKelamin, Tempat, Tanggal, Agama, NIK, NoTelp, Email, Alamat);
                break;
            case R.id.tvLoginHere:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void data(String id, String kd, String nama, String nis, String nisn, String jenisKelamin, String tempat, String tanggal, String agama, String nik, String noTelp, String email, String alamat) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Data> call = apiInterface.dataResponse(id, kd, nama, nis, nisn, jenisKelamin, tempat, tanggal, agama, nik, noTelp, email, alamat);
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    sessionManager = new SessionManager(DataActivity.this);
                    DataData dataData = response.body().getDataData();
                    sessionManager.createDataSession(dataData);

                    Toast.makeText(DataActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DataActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(DataActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(DataActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
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