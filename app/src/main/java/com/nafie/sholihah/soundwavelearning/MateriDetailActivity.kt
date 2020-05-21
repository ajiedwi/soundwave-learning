package com.nafie.sholihah.soundwavelearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nafie.sholihah.soundwavelearning.Materi.First.Materi_1
import com.nafie.sholihah.soundwavelearning.Materi.First.Materi_2
import com.nafie.sholihah.soundwavelearning.Materi.First.Materi_3
import com.nafie.sholihah.soundwavelearning.Quiz.QuizBKFragment
import kotlinx.android.synthetic.main.toolbar.*

class MateriDetailActivity : AppCompatActivity() {

    val materi by lazy {
        intent.getIntExtra(MateriActivity.MATERI,0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi_detail)

        iv_back.setOnClickListener{
            onBackPressed()
        }

        when(materi){
            1 -> {
                tv_toolbar.text = "Cepat Rambat Bunyi"
                supportFragmentManager.beginTransaction().replace(R.id.container_materi,Materi_1()).commit()
            }
            2 -> {
                tv_toolbar.text = "Nada dan Resonansi"
                supportFragmentManager.beginTransaction().replace(R.id.container_materi, Materi_2()).commit()
            }
            3 -> {
                tv_toolbar.text = "Intensitas Bunyi"
                supportFragmentManager.beginTransaction().replace(R.id.container_materi, Materi_3()).commit()
            }
        }
    }
}
