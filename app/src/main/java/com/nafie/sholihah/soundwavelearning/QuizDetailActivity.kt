package com.nafie.sholihah.soundwavelearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nafie.sholihah.soundwavelearning.Quiz.QuizBKFragment
import com.nafie.sholihah.soundwavelearning.Quiz.QuizPMFragment
import kotlinx.android.synthetic.main.toolbar.*

class QuizDetailActivity : AppCompatActivity() {


    val bk by lazy {
        intent.getBooleanExtra("bk",true)
    }

    val name by lazy {
        intent.getStringExtra("name")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_detail)

        iv_back.setOnClickListener{
            onBackPressed()
        }

        if(bk){
            tv_toolbar.text = "Quiz Berfikir Kritis"
            val frament = QuizBKFragment()
            var args = Bundle()
            args.putString("name",name)
            frament.arguments = args
            supportFragmentManager.beginTransaction().replace(R.id.container_materi,frament).commit()
        } else {
            tv_toolbar.text = "Quiz Pemecahan Masalah"
            val frament = QuizPMFragment()
            var args = Bundle()
            args.putString("name",name)
            frament.arguments = args
            supportFragmentManager.beginTransaction().replace(R.id.container_materi,frament).commit()
        }
    }
}
