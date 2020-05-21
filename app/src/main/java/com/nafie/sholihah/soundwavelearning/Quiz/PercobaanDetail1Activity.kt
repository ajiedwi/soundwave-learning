package com.nafie.sholihah.soundwavelearning.Quiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nafie.sholihah.soundwavelearning.R
import kotlinx.android.synthetic.main.toolbar.*

class PercobaanDetail1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_percobaan_detail1)

        tv_toolbar.text = "Perambatan Bunyi"
        iv_back.setOnClickListener{
            onBackPressed()
        }
    }
}
