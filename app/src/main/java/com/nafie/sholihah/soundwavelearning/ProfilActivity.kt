package com.nafie.sholihah.soundwavelearning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_profil.*
import kotlinx.android.synthetic.main.toolbar.*

class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        iv_back.setOnClickListener{
            onBackPressed()
        }

        tv_toolbar.text = "Profil Pengembang"

        val profil = arrayListOf(
            Kompetensi("Nama\t\t:","Nafi\'atus Sholihah"),
            Kompetensi("TTL\t\t\t\t:","Ngawi, 20 Maret 1994"),
            Kompetensi("Email\t\t\t:","nafiatussholihah55@gmail.com"),
            Kompetensi("Motto\t\t\t:","\"Hidup sekali hiduplah yang berarti\"")
        )

        rv_profil.layoutManager = LinearLayoutManager(this)
        rv_profil.adapter = Adapter(profil)

    }

    inner class Adapter(var datas:ArrayList<Kompetensi>): RecyclerView.Adapter<ViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(this@ProfilActivity).inflate(R.layout.item_profil, parent, false))
        }

        override fun getItemCount(): Int {
            return datas.size
        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.setData(datas.get(position))
        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvIndex : TextView = itemView.findViewById(R.id.tv_item_profil_index)
        val tvName : TextView = itemView.findViewById(R.id.tv_item_profil_content)

        fun setData(kompetensi: Kompetensi){
            tvIndex.text = kompetensi.index
            tvName.text = kompetensi.menu
        }
    }

    data class Kompetensi(
        val index : String,
        val menu : String
    )
}
