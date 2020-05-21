package com.nafie.sholihah.soundwavelearning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_kompetensi.*
import kotlinx.android.synthetic.main.toolbar.*

class KompetensiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kompetensi)

        iv_back.setOnClickListener{
            onBackPressed()
        }

        tv_toolbar.text = "Kompetensi Pembelajaran"

        val kompetensiDasar = arrayListOf(
            Kompetensi("3.10","Menerapkan konsep dan prinsip gelombang bunyi dan cahaya dalam teknlogi."),
            Kompetensi("4.10","Melakukan percobaan tentang gelombang bunyi dan atau cahaya berikut presentasi hasil percobaan dan makna fisisnya.")
        )

        val kompetensiPemecahanMasalah = arrayListOf(
            Kompetensi("\u2022","Merumuskan masalah"),
            Kompetensi("\u2022","Merumuskan hipotesis"),
            Kompetensi("\u2022","Menguji hipotesis"),
            Kompetensi("\u2022","Menarik kesimpulan")
        )

        val kompetensiBerfikirKritis = arrayListOf(
            Kompetensi("\u2022","Memberikan penjelasan dasar"),
            Kompetensi("\u2022","Memberikan argumen (gagasan)"),
            Kompetensi("\u2022","Melakukan evaluasi"),
            Kompetensi("\u2022","Mengambil keputusan atau mengambil tindakan")
        )

        rv_kompetensi_diukur_1.layoutManager = LinearLayoutManager(this)
        rv_kompetensi_diukur_2.layoutManager = LinearLayoutManager(this)
        rv_kompetensi_dasar.layoutManager = LinearLayoutManager(this)

        rv_kompetensi_dasar.adapter = Adapter(kompetensiDasar)
        rv_kompetensi_diukur_1.adapter = Adapter(kompetensiPemecahanMasalah)
        rv_kompetensi_diukur_2.adapter = Adapter(kompetensiBerfikirKritis)

    }

    inner class Adapter(var datas:ArrayList<Kompetensi>):RecyclerView.Adapter<ViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(this@KompetensiActivity).inflate(R.layout.item_kompetensi, parent, false))
        }

        override fun getItemCount(): Int {
            return datas.size
        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.setData(datas.get(position))
        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvIndex : TextView = itemView.findViewById(R.id.tv_item_kompetensi_index)
        val tvName : TextView = itemView.findViewById(R.id.tv_item_kompetensi_menu)

        fun setData(kompetensi: Kompetensi){

            tvName.text = kompetensi.menu
            tvIndex.text = kompetensi.index

        }
    }

    data class Kompetensi(
        val index : String,
        val menu : String
    )

}
