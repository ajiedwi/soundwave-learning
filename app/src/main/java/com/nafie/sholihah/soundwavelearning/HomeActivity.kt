package com.nafie.sholihah.soundwavelearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val menu = arrayListOf<HomeMenu>(
            HomeMenu(R.drawable.tujuanpemb_,"Kompetensi"),
            HomeMenu(R.drawable.materi_,"Materi"),
            HomeMenu(R.drawable.percobaan_,"Percobaan"),
            HomeMenu(R.drawable.quiz_,"Quiz"),
            HomeMenu(R.drawable.glosarium,"Glosarium"),
            HomeMenu(R.drawable.pengembang,"Profil Pengembang")
        )

        rv_menu.layoutManager = LinearLayoutManager(this)
        rv_menu.adapter = Adapter(menu)
    }

    inner class Adapter(var datas:ArrayList<HomeMenu>):RecyclerView.Adapter<ViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(this@HomeActivity).inflate(R.layout.item_menu, parent, false))
        }

        override fun getItemCount(): Int {
            return datas.size
        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.setData(datas.get(position))

            holder.itemView.setOnClickListener{
                when(position){
                    0 -> startActivity(Intent(this@HomeActivity, KompetensiActivity::class.java))
                    1 -> startActivity(Intent(this@HomeActivity, MateriActivity::class.java))
                    2 -> startActivity(Intent(this@HomeActivity, PercobaanActivity::class.java))
                    4 -> startActivity(Intent(this@HomeActivity, GlosariumActivity::class.java))
                    3 -> startActivity(Intent(this@HomeActivity, QuizActivity::class.java))
                    5 -> startActivity(Intent(this@HomeActivity, ProfilActivity::class.java))
                }
            }
        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivIcon : ImageView = itemView.findViewById(R.id.iv_item_menu)
        val tvName : TextView = itemView.findViewById(R.id.tv_item_menu)

        fun setData(homeMenu: HomeMenu){

            tvName.text = homeMenu.menu
            Glide.with(this@HomeActivity)
                .load(ContextCompat.getDrawable(this@HomeActivity, homeMenu.icon))
                .into(ivIcon)

        }
    }

    data class HomeMenu(
        val icon : Int,
        val menu : String
    )

}
