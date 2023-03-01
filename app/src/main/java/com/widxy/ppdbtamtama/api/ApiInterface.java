package com.widxy.ppdbtamtama.api;

import com.widxy.ppdbtamtama.model.alamat.Alamat;
import com.widxy.ppdbtamtama.model.data.Data;
import com.widxy.ppdbtamtama.model.jurusan.Jurusan;
import com.widxy.ppdbtamtama.model.lihat.Lihat;
import com.widxy.ppdbtamtama.model.login.Login;
import com.widxy.ppdbtamtama.model.pendaftaran.Pendaftaran;
import com.widxy.ppdbtamtama.model.pengumuman.Pengumuman;
import com.widxy.ppdbtamtama.model.register.Register;
import com.widxy.ppdbtamtama.model.sekolah.Sekolah;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login.php")
    Call<Login> loginResponse(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register.php")
    Call<Register> registerResponse(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("data.php")
    Call<Data> dataResponse(
            @Field("id_pendaftar") String id_pendaftar,
            @Field("kode_pendaftar") String kode_pendaftar,
            @Field("nama_lengkap") String nama_lengkap,
            @Field("nis") String nis,
            @Field("nisn") String nisn,
            @Field("jenis_kelamin") String jenis_kelamin,
            @Field("tempat_lahir") String tempat_lahir,
            @Field("tanggal_lahir") String tanggal_lahir,
            @Field("agama") String agama,
            @Field("nik") String nik,
            @Field("no_telp") String no_telp,
            @Field("email") String email,
            @Field("alamat") String alamat
    );

    @FormUrlEncoded
    @POST("alamat.php")
    Call<Alamat> alamatResponse(
            @Field("id_siswa") String id_siswa,
            @Field("longitude") String longitude,
            @Field("latitude") String latitude,
            @Field("alamat") String alamat,
            @Field("jarak") String jarak,
            @Field("url") String url
    );

    @FormUrlEncoded
    @POST("asal.php")
    Call<Sekolah> sekolahResponse(
            @Field("id_siswa") String id_siswa,
            @Field("nama_sekolah") String nama_sekolah,
            @Field("nama_kepala_sekolah") String nama_kepala_sekolah,
            @Field("status_sekolah") String status_sekolah,
            @Field("tahun_lulus") String tahun_lulus,
            @Field("nem") String nem,
            @Field("npsn_sekolah") String npsn_sekolah
    );

    @FormUrlEncoded
    @POST("jurusan.php")
    Call<Jurusan> jurusanResponse(
            @Field("id_siswa") String id_siswa,
            @Field("jurusan1") String jurusan1,
            @Field("jurusan2") String jurusan2
    );

    @FormUrlEncoded
    @POST("status.php")
    Call<Pendaftaran> pendaftaranResponse(
            @Field("id_siswa") String id_siswa,
            @Field("status") String status
    );

    @FormUrlEncoded
    @POST("lihat.php")
    Call<Pengumuman> pengumumanResponse(
            @Field("kode_pendaftar") String kode_pendaftar
    );

    @FormUrlEncoded
    @POST("lihatdata.php")
    Call<Lihat> lihatResponse(
            @Field("kode_pendaftar") String kode_pendaftar
    );
}
