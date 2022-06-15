package com.erin.rumahkue

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erin.rumahkue.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private var idPengguna = ""

    companion object {
        const val PENGGUNA = "nama_pengguna"
        const val WEB_PREFIX = "https://github.com/"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // menampilkan layout: activity_main2 menggunakan konsep/metode binding
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // mengambil data yang dikirimkan melalui intent
        // jika data ada dan sesuai dengan key variabel PENGGUNA
        idPengguna = intent?.extras?.getString(PENGGUNA).toString()

        // judul dalam AppBAr --> title
        title = "Halloww $idPengguna"

        binding.teksDetailPengguna.text = idPengguna

        // memberikan klik listener pada button dengan id: tombolGithub
        // saat button diklik akan menjalankan fungsi cekGithub
        binding.tombolGithub.setOnClickListener { cekGithub() }

        // memberikan klik listener pada button dengan id: tombolTentang
        // saat button diklik akan menjalankan fungsi keTentangPengguna
        binding.tombolDaftar.setOnClickListener{ keTentangPengguna() }

        // memberikan klik listener pada button dengan id: idMenu
        // saat button diklik akan menjalankan fungsi keTentangMenu
        binding.idMenu.setOnClickListener{ keTentangMenu() }
    }

    private fun keTentangMenu() {
        // menyiapkan variabel intentMenu dari class Intent, konfigurasi/parameter yang digunakan
        // dari activity yang aktif sekarang (MainActivity2 ke class RecyclerActivity)
        val intentMenu = Intent( this, RecyclerActivity::class.java)
        // aktifkan intent
        startActivity(intentMenu)
    }

    private fun keTentangPengguna() {
        // menyiapkan variabel intentPengguna dari class Intent, konfigurasi/parameter yang digunakan
        // dari activity yang aktif sekarang (MainActivity2 ke class ReadActivity)
        val intentPengguna = Intent( this, ReadActivity::class.java)
        // aktifkan intent
        startActivity(intentPengguna)
    }

    private fun cekGithub() {
        // menggunakan intent implisit dg variabel query Url, data di dalamnya web_prefix
        val queryUrl: Uri = Uri.parse("$WEB_PREFIX${idPengguna}")
        // menyiapkan variabel intent dengan parameter
        val intent = Intent(Intent.ACTION_VIEW,queryUrl)
        // aktifkan intent
        startActivity(intent)

    }
}