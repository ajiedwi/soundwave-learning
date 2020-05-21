package com.nafie.sholihah.soundwavelearning

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_landing.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }

        Glide.with(this).load(R.drawable.name).thumbnail(0.2f).into(name)
        Glide.with(this).load(R.drawable.splash_logo).thumbnail(0.2f).into(logo)
        Glide.with(this).load(R.drawable.identity).thumbnail(0.2f).into(identity)

    }

}

fun ImageView.loadTahukahKamu(context: Context){
    Glide.with(context).load(R.drawable.orang).into(this)
}
