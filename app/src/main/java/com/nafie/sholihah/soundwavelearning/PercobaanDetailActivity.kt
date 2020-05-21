package com.nafie.sholihah.soundwavelearning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_percobaan_detail.*
import kotlinx.android.synthetic.main.toolbar.*
import android.content.Intent
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri


class PercobaanDetailActivity : AppCompatActivity() {

    companion object {
        val PERCOBAAN = "percobaan"
    }

    val percobaan by lazy {
        intent?.getIntExtra(PERCOBAAN,0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_percobaan_detail)

        iv_back.setOnClickListener{
            onBackPressed()
        }

        percobaan?.let {
            var datasAlat = arrayOf<String>()
            var datasPercobaan = arrayOf<String>()
            when(it){
                1->{
                    tv_toolbar.text = "Perambatan Bunyi"
                    datasAlat = resources.getStringArray(R.array.bahan_percobaan_1)
                    datasPercobaan = resources.getStringArray(R.array.langkah_percobaan_1)
                }
                2->{
                    tv_toolbar.text = "Resonansi"
                    datasAlat = resources.getStringArray(R.array.bahan_percobaan_2)
                    datasPercobaan = resources.getStringArray(R.array.langkah_percobaan_2)
                    btn_mulai.visibility = View.VISIBLE
                }
                3->{
                    tv_toolbar.text = "Taraf Intensitas"
                    datasAlat = resources.getStringArray(R.array.bahan_percobaan_3)
                    datasPercobaan = resources.getStringArray(R.array.langkah_percobaan_3)
                    btn_mulai.visibility = View.VISIBLE
                }


            }
            rv_percobaan_alat.layoutManager = LinearLayoutManager(this)
            rv_percobaan_alat.adapter = Adapter(datasAlat)

            rv_percobaan_langkah.layoutManager = LinearLayoutManager(this)
            rv_percobaan_langkah.adapter = Adapter(datasPercobaan)

            btn_mulai.setOnClickListener {itv ->
                var intent =
                    if (it == 2){
                        packageManager.getLaunchIntentForPackage("com.keuwl.audiofrequencycounter")
                    }else {
                        packageManager.getLaunchIntentForPackage("com.gamebasic.decibel")
                    }
                if (intent != null) {
                    // We found the activity now start the activity
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                } else {
                    // Bring user to the market or let them choose an app?
                    intent = Intent(Intent.ACTION_VIEW)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.data =
                        if (it == 2){
                            Uri.parse("market://details?id=com.keuwl.audiofrequencycounter")
                        }else {
                            Uri.parse("market://details?id=com.gamebasic.decibel")
                        }
                    startActivity(intent)
                }
            }
        }

    }

    inner class Adapter(var datas:Array<String>): RecyclerView.Adapter<ViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(this@PercobaanDetailActivity).inflate(R.layout.item_percobaan, parent, false))
        }

        override fun getItemCount(): Int {
            return datas.size
        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.tvIndex.text = "${position+1}."
            holder.tvName.text = datas[position]
        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvIndex : TextView = itemView.findViewById(R.id.tv_item_percobaan_index)
        val tvName : TextView = itemView.findViewById(R.id.tv_item_percobaan_content)

    }


}
