package com.nafie.sholihah.soundwavelearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_materi.*
import kotlinx.android.synthetic.main.toolbar.*

class MateriActivity : AppCompatActivity() {

    companion object {
        val MATERI = "materi"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi)

        iv_back.setOnClickListener{
            onBackPressed()
        }

        tv_toolbar.text = "Materi"

        btn_materi_1.setOnClickListener {
            val intent = Intent(this,MateriDetailActivity::class.java)
            intent.putExtra(MATERI, 1)
            startActivity(intent)
        }

        btn_materi_2.setOnClickListener {
            val intent = Intent(this,MateriDetailActivity::class.java)
            intent.putExtra(MATERI, 2)
            startActivity(intent)
        }

        btn_materi_3.setOnClickListener {
            val intent = Intent(this,MateriDetailActivity::class.java)
            intent.putExtra(MATERI, 3)
            startActivity(intent)
        }

    }
}
