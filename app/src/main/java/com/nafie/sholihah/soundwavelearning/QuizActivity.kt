package com.nafie.sholihah.soundwavelearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlinx.android.synthetic.main.toolbar.*

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        iv_back.setOnClickListener{
            onBackPressed()
        }

        tv_toolbar.text = "Quiz"

        btn_bk.setOnClickListener {
            if (edt_class.text.isNotEmpty() && edt_name.text.isNotEmpty()){
                val intent = Intent(this, QuizDetailActivity::class.java)
                intent.putExtra("bk",true)
                intent.putExtra("name",edt_name.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this,"Isi identitas kamu terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }

        btn_pm.setOnClickListener {
            if (edt_class.text.isNotEmpty() && edt_name.text.isNotEmpty()){
                val intent = Intent(this, QuizDetailActivity::class.java)
                intent.putExtra("bk",false)
                intent.putExtra("name",edt_name.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this,"Isi identitas kamu terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
