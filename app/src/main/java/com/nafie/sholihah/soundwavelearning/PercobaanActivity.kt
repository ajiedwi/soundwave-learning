package com.nafie.sholihah.soundwavelearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nafie.sholihah.soundwavelearning.Quiz.PercobaanDetail1Activity
import kotlinx.android.synthetic.main.activity_percobaan.*
import kotlinx.android.synthetic.main.toolbar.*

class PercobaanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_percobaan)

        iv_back.setOnClickListener{
            onBackPressed()
        }

        tv_toolbar.text = "Percobaan"

        btn_percobaan_1.setOnClickListener {
            val i = Intent(this,PercobaanDetail1Activity::class.java)
            i.putExtra(PercobaanDetailActivity.PERCOBAAN,1)
            startActivity(i)
        }


        btn_percobaan_2.setOnClickListener {
            val i = Intent(this,PercobaanDetailActivity::class.java)
            i.putExtra(PercobaanDetailActivity.PERCOBAAN,2)
            startActivity(i)
        }

        btn_percobaan_3.setOnClickListener {
            val i = Intent(this,PercobaanDetailActivity::class.java)
            i.putExtra(PercobaanDetailActivity.PERCOBAAN,3)
            startActivity(i)
        }
    }
}
