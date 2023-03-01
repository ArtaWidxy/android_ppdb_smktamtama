package com.widxy.ppdbtamtama;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.widxy.ppdbtamtama.model.alamat.AlamatData;
import com.widxy.ppdbtamtama.model.data.DataData;
import com.widxy.ppdbtamtama.model.jurusan.JurusanData;
import com.widxy.ppdbtamtama.model.lihat.LihatData;
import com.widxy.ppdbtamtama.model.login.LoginData;
import com.widxy.ppdbtamtama.model.pendaftaran.PendaftaranData;
import com.widxy.ppdbtamtama.model.pengumuman.PengumumanData;
import com.widxy.ppdbtamtama.model.sekolah.SekolahData;

import java.util.HashMap;

public class SessionManager {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String USER_ID = "id_admin";
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";
    public static final String KODE_PENDAFTAR = "kode_pendaftar";
    public static final String ROLE = "role";

    public static final String FULLNAME = "nama_lengkap";

    public static final String NIS = "nis";
    public static final String NISN = "nisn";

    public static final String IDPENDAFTARAN = "id_pendaftar";
    public static final String JENIS_KELAMIN = "jenis_kelamin";
    public static final String TEMPAT_LAHIR = "tempat_lahir";
    public static final String TANGGAL_LAHIR = "tanggal_lahir";
    public static final String AGAMA = "agama";
    public static final String NIK = "nik";
    public static final String NO_TELP = "no_telp";
    public static final String ALAMAT = "alamat";

    public static final String ID_AS_SISWA = "id_siswa";
    public static final String NAMA_SEKOLAH = "nama_sekolah";
    public static final String NAMA_KEPALA_SEKOLAH = "nama_kepala_sekolah";
    public static final String STATUS_SEKOLAH = "status_sekolah";
    public static final String TAHUN_LULUS = "tahun_lulus";
    public static final String NEM = "nam";
    public static final String NPSN_SEKOLAH = "npsn_sekolah";

    public static final String ID_JUR_ID = "id_siswa";
    public static final String JUR1 = "jurusan1";
    public static final String JUR2 = "jurusan2";

    public static final String PENDAF_ID = "id_siswa";
    public static final String PENDAF_STATUS = "status";


    public static final String PENG_KODE = "kode_pendaftar";
    public static final String PENG_NAMA = "nama_lengkap";
    public static final String PENG_JUR = "jurusan";
    public static final String PENG_STATUS = "status";


    public static final String LIHAT_ID = "id_pendaftar";
    public static final String LIHAT_KODE = "kode_pendaftar";
    public static final String LIHAT_NAMA = "nama_lengkap";
    public static final String LIHAT_JK = "jenis_kelamin";
    public static final String LIHAT_TEMPAT = "tempat_lahir";
    public static final String LIHAT_TANGGAL = "tanggal_lahir";
    public static final String LIHAT_AGAMA = "agama";
    public static final String LIHAT_NIK = "nik";
    public static final String LIHAT_NO = "no_telp";
    public static final String LIHAT_EMAIL = "email";
    public static final String LIHAT_LONGITUDE = "longitude";
    public static final String LIHAT_LATITUDE = "latitude";
    public static final String LIHAT_URL = "url";
    public static final String LIHAT_ALAMAT = "alamat";
    public static final String LIHAT_NAMA_SEKOLAH = "nama_sekolah";
    public static final String LIHAT_NAMA_KEPALA_SEKOLAH = "nama_kepala_sekolah";
    public static final String LIHAT_NIS = "nis";
    public static final String LIHAT_NISN = "nisn";
    public static final String LIHAT_STATUS_SEKOLAH = "status_sekolah";
    public static final String LIHAT_TAHUN_LULUS = "tahun_lulus";
    public static final String LIHAT_NEM = "nem";
    public static final String LIHAT_ALAMAT_SEKOLAH = "alamat_sekolah";
    public static final String LIHAT_JURUSAN1 = "jurusan1";
    public static final String LIHAT_JURUSAN2 = "jurusan2";

    public SessionManager (Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLihatSession(LihatData lihatData){
        editor.putString(LIHAT_ID, lihatData.getId_pendaftar());
        editor.putString(LIHAT_KODE, lihatData.getKode_pendaftar());
        editor.putString(LIHAT_NAMA, lihatData.getNama_lengkap());
        editor.putString(LIHAT_JK, lihatData.getJenis_kelamin());
        editor.putString(LIHAT_TEMPAT, lihatData.getTempat_lahir());
        editor.putString(LIHAT_TANGGAL, lihatData.getTanggal_lahir());
        editor.putString(LIHAT_AGAMA, lihatData.getAgama());
        editor.putString(LIHAT_NIK, lihatData.getNik());
        editor.putString(LIHAT_NO, lihatData.getNo_telp());
        editor.putString(LIHAT_EMAIL, lihatData.getEmail());
        editor.putString(LIHAT_LONGITUDE, lihatData.getLongitude());
        editor.putString(LIHAT_LATITUDE, lihatData.getLatitude());
        editor.putString(LIHAT_URL, lihatData.getUrl());
        editor.putString(LIHAT_ALAMAT, lihatData.getAlamat());
        editor.putString(LIHAT_NAMA_SEKOLAH, lihatData.getNama_sekolah());
        editor.putString(LIHAT_NAMA_KEPALA_SEKOLAH, lihatData.getNama_kepala_sekolaj());
        editor.putString(LIHAT_NIS, lihatData.getNis());
        editor.putString(LIHAT_NISN, lihatData.getNisn());
        editor.putString(LIHAT_STATUS_SEKOLAH, lihatData.getStatus_sekolah());
        editor.putString(LIHAT_TAHUN_LULUS, lihatData.getTahun_lulus());
        editor.putString(LIHAT_NEM, lihatData.getNem());
        editor.putString(LIHAT_ALAMAT_SEKOLAH, lihatData.getAlamat_sekolah());
        editor.putString(LIHAT_JURUSAN1, lihatData.getJurusan1());
        editor.putString(LIHAT_JURUSAN2, lihatData.getJurusan2());
        editor.commit();
    }

    public HashMap<String, String> getLihatDetail(){
        HashMap<String, String> lihat = new HashMap<>();
        lihat.put(LIHAT_ID, sharedPreferences.getString(LIHAT_ID, null));
        lihat.put(LIHAT_KODE, sharedPreferences.getString(LIHAT_KODE, null));
        lihat.put(LIHAT_NAMA, sharedPreferences.getString(LIHAT_NAMA, null));
        lihat.put(LIHAT_JK, sharedPreferences.getString(LIHAT_JK, null));
        lihat.put(LIHAT_TEMPAT, sharedPreferences.getString(LIHAT_TEMPAT, null));
        lihat.put(LIHAT_TANGGAL, sharedPreferences.getString(LIHAT_TANGGAL, null));
        lihat.put(LIHAT_AGAMA, sharedPreferences.getString(LIHAT_AGAMA, null));
        lihat.put(LIHAT_NIK, sharedPreferences.getString(LIHAT_NIK, null));
        lihat.put(LIHAT_NO, sharedPreferences.getString(LIHAT_NO, null));
        lihat.put(LIHAT_EMAIL, sharedPreferences.getString(LIHAT_EMAIL, null));
        lihat.put(LIHAT_LONGITUDE, sharedPreferences.getString(LIHAT_LONGITUDE, null));
        lihat.put(LIHAT_LATITUDE, sharedPreferences.getString(LIHAT_LATITUDE, null));
        lihat.put(LIHAT_URL, sharedPreferences.getString(LIHAT_URL, null));
        lihat.put(LIHAT_ALAMAT, sharedPreferences.getString(LIHAT_ALAMAT, null));
        lihat.put(LIHAT_NAMA_SEKOLAH, sharedPreferences.getString(LIHAT_NAMA_SEKOLAH, null));
        lihat.put(LIHAT_NAMA_KEPALA_SEKOLAH, sharedPreferences.getString(LIHAT_NAMA_KEPALA_SEKOLAH, null));
        lihat.put(LIHAT_NIS, sharedPreferences.getString(LIHAT_NIS, null));
        lihat.put(LIHAT_NISN, sharedPreferences.getString(LIHAT_NISN, null));
        lihat.put(LIHAT_STATUS_SEKOLAH, sharedPreferences.getString(LIHAT_STATUS_SEKOLAH, null));
        lihat.put(LIHAT_TAHUN_LULUS, sharedPreferences.getString(LIHAT_TAHUN_LULUS, null));
        lihat.put(LIHAT_NEM, sharedPreferences.getString(LIHAT_NEM, null));
        lihat.put(LIHAT_ALAMAT_SEKOLAH, sharedPreferences.getString(LIHAT_ALAMAT_SEKOLAH, null));
        lihat.put(LIHAT_JURUSAN1, sharedPreferences.getString(LIHAT_JURUSAN1, null));
        lihat.put(LIHAT_JURUSAN2, sharedPreferences.getString(LIHAT_JURUSAN2, null));
        return lihat;
    }
    public void createPengumumanSession(PengumumanData pengumumanData){
        editor.putString(PENG_KODE, pengumumanData.getKode_pendaftar());
        editor.putString(PENG_NAMA, pengumumanData.getNama_lengkap());
        editor.putString(PENG_JUR, pengumumanData.getJurusan());
        editor.putString(PENG_STATUS, pengumumanData.getStatus());
        editor.commit();
    }

    public HashMap<String, String> getPengumumanDetail(){
        HashMap<String, String> pengumuman = new HashMap<>();
        pengumuman.put(PENG_KODE, sharedPreferences.getString(PENG_KODE, null));
        pengumuman.put(PENG_NAMA, sharedPreferences.getString(PENG_NAMA, null));
        pengumuman.put(PENG_JUR, sharedPreferences.getString(PENG_JUR, null));
        pengumuman.put(PENG_STATUS, sharedPreferences.getString(PENG_STATUS, null));
        return pengumuman;
    }

    public void createPendaftaranSession(PendaftaranData pendaftaranData){
        editor.putString(PENDAF_ID, pendaftaranData.getId_siswa());
        editor.putString(PENDAF_STATUS, pendaftaranData.getStatus());
        editor.commit();
    }

    public HashMap<String, String> getPendaftaranDetail(){
        HashMap<String,String> pendaftaran = new HashMap<>();
        editor.putString(PENDAF_ID, sharedPreferences.getString(PENDAF_ID, null));
        editor.putString(PENDAF_STATUS, sharedPreferences.getString(PENDAF_STATUS, null));
        return pendaftaran;
    }

    public void createJurusanSession(JurusanData jurusanData){
        editor.putString(ID_JUR_ID, jurusanData.getId_siswa());
        editor.putString(JUR1, jurusanData.getJurusan1());
        editor.putString(JUR2, jurusanData.getJurusan2());
        editor.commit();
    }

    public HashMap<String, String> getJurusanDetail(){
        HashMap<String,String> jurusan = new HashMap<>();
        jurusan.put(ID_JUR_ID, sharedPreferences.getString(ID_JUR_ID, null));
        jurusan.put(JUR1, sharedPreferences.getString(JUR1, null));
        jurusan.put(JUR2, sharedPreferences.getString(JUR2, null));
        return jurusan;
    }

    public void createSekolahSession(SekolahData sekolahData){
        editor.putString(ID_AS_SISWA, sekolahData.getId_siswa());
        editor.putString(NAMA_SEKOLAH, sekolahData.getNama_sekolah());
        editor.putString(NAMA_KEPALA_SEKOLAH, sekolahData.getNama_kepala_sekolah());
        editor.putString(STATUS_SEKOLAH, sekolahData.getStatus_sekolah());
        editor.putString(TAHUN_LULUS, sekolahData.getTahun_lulus());
        editor.putString(NEM, sekolahData.getNem());
        editor.putString(NPSN_SEKOLAH, sekolahData.getNpsn_sekolah());
        editor.commit();
    }

    public HashMap<String, String> getSekolahDetail(){
        HashMap<String,String> sekolah = new HashMap<>();
        sekolah.put(ID_AS_SISWA, sharedPreferences.getString(ID_AS_SISWA, null));
        sekolah.put(NAMA_SEKOLAH, sharedPreferences.getString(NAMA_SEKOLAH, null));
        sekolah.put(NAMA_KEPALA_SEKOLAH, sharedPreferences.getString(NAMA_KEPALA_SEKOLAH, null));
        sekolah.put(STATUS_SEKOLAH, sharedPreferences.getString(STATUS_SEKOLAH, null));
        sekolah.put(TAHUN_LULUS, sharedPreferences.getString(TAHUN_LULUS, null));
        sekolah.put(NEM, sharedPreferences.getString(NEM, null));
        sekolah.put(NPSN_SEKOLAH, sharedPreferences.getString(NPSN_SEKOLAH, null));
        return sekolah;
    }

    public void createDataSession(DataData data){
        editor.putString(FULLNAME, data.getNama_lengkap());
        editor.putString(IDPENDAFTARAN, data.getId_pendaftar());
        editor.putString(JENIS_KELAMIN, data.getJenis_kelamin());
        editor.putString(TEMPAT_LAHIR, data.getTempat_lahir());
        editor.putString(TANGGAL_LAHIR, data.getTanggal_lahir());
        editor.putString(AGAMA, data.getAgama());
        editor.putString(NIK, data.getNik());
        editor.putString(NO_TELP, data.getNo_telp());
        editor.putString(ALAMAT, data.getNo_telp());
        editor.putString(NIS, data.getNis());
        editor.putString(NISN, data.getNisn());
        editor.commit();
    }

    public HashMap<String, String> getDataDetail(){
        HashMap<String,String> data = new HashMap<>();
        data.put(FULLNAME, sharedPreferences.getString(FULLNAME, null));
        data.put(IDPENDAFTARAN, sharedPreferences.getString(IDPENDAFTARAN, null));
        data.put(JENIS_KELAMIN, sharedPreferences.getString(JENIS_KELAMIN, null));
        data.put(TEMPAT_LAHIR, sharedPreferences.getString(TEMPAT_LAHIR, null));
        data.put(TANGGAL_LAHIR, sharedPreferences.getString(TANGGAL_LAHIR, null));
        data.put(AGAMA, sharedPreferences.getString(AGAMA, null));
        data.put(NIK, sharedPreferences.getString(NIK, null));
        data.put(NO_TELP, sharedPreferences.getString(NO_TELP, null));
        data.put(ALAMAT, sharedPreferences.getString(ALAMAT, null));
        data.put(NIS, sharedPreferences.getString(NIS, null));
        data.put(NISN, sharedPreferences.getString(NISN, null));
        return data;
    }

    public void createLoginSession(LoginData user){
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(USER_ID, user.getId_admin());
        editor.putString(USERNAME, user.getUsername());
        editor.putString(EMAIL, user.getEmail());
        editor.putString(ROLE, user.getRole());
        editor.putString(KODE_PENDAFTAR, user.getKode_pendaftar());
        editor.commit();
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(USER_ID, sharedPreferences.getString(USER_ID,null));
        user.put(USERNAME, sharedPreferences.getString(USERNAME,null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL,null));
        user.put(KODE_PENDAFTAR, sharedPreferences.getString(KODE_PENDAFTAR,null));
        user.put(ROLE, sharedPreferences.getString(ROLE,null));
        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

}
