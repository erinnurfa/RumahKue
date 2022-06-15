package com.erin.rumahkue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        // untuk pemanggilan isi list, nama gambar dan deskripsinya.
        val kueList = listOf<Kue>(
            Kue(
                R.drawable.redvelvett,
                nameKue = "Red Velvet",
                descKue = "Kue ini berukuran 16 cm dengan harga Rp 200.000"
            ),
            Kue(
                R.drawable.chocolatefudgecakee,
                nameKue = "Chocolate Fudge Cake",
                descKue = "Ukuran L dengan harga Rp 225.000"
            ),
            Kue(
                R.drawable.rainboww,
                nameKue = "Rainbow Ice Cream",
                descKue = "Berukuran xl dengan harga Rp 355.000"
            ),
            Kue(
                R.drawable.tiramisuu,
                nameKue = "Tiramisu",
                descKue = "Kue ini dengan ukuran s mempunyai harga Rp 75.000 dan m dengan harga Rp 125.000"
            ),
            Kue(
                R.drawable.pinckyrolll,
                nameKue = "Pincky Roll",
                descKue = "Kue ini ukuran M dengan harga Rp 60.000 serta ukuran L dengan harga Rp 70.000"
            ),
            Kue(
                R.drawable.blackforestt,
                nameKue = "Black Forest Oreo Cheese",
                descKue = "Kue ini mempunyai ukuran s dengan harga Rp 75.000 dan m dengan harga Rp 90.000"
            ),
            Kue(
                R.drawable.chocorainn,
                nameKue = "Choco Rain",
                descKue = "Ukuran s dengan harga Rp 75.000 dan m dengan harga Rp 125.000"
            ),
            Kue(
                R.drawable.lapislegitt,
                nameKue = "Lapis Legit Prune",
                descKue = "Kue ini mempunyai ukuran Medium dengan harga Rp 310.000 dan whole dengan harga Rp 600.000"
            ),
            Kue(
                R.drawable.redvelvettt,
                nameKue = "Red Velvet Straw",
                descKue = "Kue ini mempunyai 22 cm dengan harga Rp 340.000"
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_kue)
        // LinearLayoutManager digunakan untuk mengelola tata letak.
        recyclerView.layoutManager = LinearLayoutManager( this)
        // Untuk optimasi ketika ukuran RecycleView tidak berubah dari dokumen.
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = KueAdapter(this,kueList){
        }
    }
}