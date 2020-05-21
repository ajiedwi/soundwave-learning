package com.nafie.sholihah.soundwavelearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_glosarium.*
import kotlinx.android.synthetic.main.toolbar.*

class GlosariumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glosarium)

        iv_back.setOnClickListener{
            onBackPressed()
        }

        tv_toolbar.text = "Glosarium"

        val glosarium = arrayListOf(
            Kompetensi("\u25ba","Gelombang mekanik: Gelombang yang membutuhkan medium untuk memindahkan energi dari satu tempat ke tempat lain."),
            Kompetensi("►","Frekuensi : Banyaknya getaran per detik"),
            Kompetensi("►","Audiosonik : Bunyi dengan frekuensi antara 20-20.000 Hz."),
            Kompetensi("►","Infrasonik: Bunyi dengan frekuensi kurang dari 20 Hz"),
            Kompetensi("►","Ultrasonik: Bunyi dengan frekuensi lebih dari 20.000 Hz"),
            Kompetensi("►","Nada : Bunyi dengan frekuensi tertentu yang teratur."),
            Kompetensi("►","Desah : Bunyi dengan frekuensi yang tidak beraturan"),
            Kompetensi("►","Timbre : Kekhasan setiap bunyi meskipun mempuyai frekuensi yang sama dengan bunyi lainnya.")
        )

        rv_glosarium.layoutManager = LinearLayoutManager(this)
        rv_glosarium.adapter = Adapter(glosarium)


    }

    inner class Adapter(var datas:ArrayList<Kompetensi>): RecyclerView.Adapter<ViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(this@GlosariumActivity).inflate(R.layout.item_kompetensi, parent, false))
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
            tvIndex.gravity = Gravity.CENTER_HORIZONTAL
        }
    }

    data class Kompetensi(
        val index : String,
        val menu : String
    )


}
