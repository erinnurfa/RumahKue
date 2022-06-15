package com.erin.rumahkue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.erin.rumahkue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // menampilkan layout: activity_main menggunakan konsep/metode binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // memberikan klik listener pada button dengan id: tombolLogin
        // saat button diklik akan menjalankanfungsi cek password
        binding.tombolLogin.setOnClickListener{ cekPassword() }
    }

    private fun cekPassword() {
        // mengambil data dari input text (textEdit) dikonversi ke String --> dimasukkan ke variabel
        val namaPengguna = binding.teksPengguna.text.toString()
        val passwordPengguna = binding.teksPassword.text.toString()

        // cek kondisi apakah salah satu isian kosong?
        // jika benar akan menampilkan toast/pop-up
        if (namaPengguna.isEmpty() || passwordPengguna.isEmpty()) {
            Toast.makeText(this, "Mohon masukkan nama dan password", Toast.LENGTH_SHORT).show()
            return
        }

        // mengecek apakah isian valid atau tidak
        if(namaPengguna == "erinnurfa" && passwordPengguna == "123456") {
            // menyiapkan variabel intent dari class Intent, konfigurasi/parameter yang digunakan
            // dari activity yang aktif sekarang (MainActivity ke class MainActivity2)
            val intent = Intent(this, MainActivity2::class.java)

            // dalam variabel ditambahkan data dengan key: nama_pengguna,
            // value diambil dari input nama pengguna
            intent.putExtra("nama_pengguna", binding.teksPengguna.text.toString())

            // activity dijalankan
            startActivity(intent)

            finish()
        } else{
            Toast.makeText(this, "Nama atau password salah.", Toast.LENGTH_SHORT).show()
            return
        }

    }
}