package com.nafie.sholihah.soundwavelearning.Materi.First

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nafie.sholihah.soundwavelearning.PercobaanDetailActivity
import com.nafie.sholihah.soundwavelearning.R
import com.nafie.sholihah.soundwavelearning.loadTahukahKamu
import kotlinx.android.synthetic.main.fragment_materi_3.*
import kotlinx.android.synthetic.main.slide_3_1.*

class Materi_3 : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_materi_3, container, false)
    }

    var position = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tahukah_kamu_3.loadTahukahKamu(requireContext())

        setMateri(position)
        btn_next.setOnClickListener {
            if (position<2){
                position+=1
                setMateri(position)
            }
        }

        btn_prev.setOnClickListener {
            if (position>1){
                position-=1
                setMateri(position)
            }
        }

        btn_percobaan_3.setOnClickListener {
            val i = Intent(requireContext(), PercobaanDetailActivity::class.java)
            i.putExtra(PercobaanDetailActivity.PERCOBAAN,3)
            startActivity(i)
        }
    }

    fun setMateri(pos : Int){
        slide_3_1.visibility = View.GONE
        slide_3_2.visibility = View.GONE
        tv_slide.text = "$pos/2"

        if (position == 1)
            btn_prev.visibility = View.INVISIBLE
        else
            btn_prev.visibility = View.VISIBLE

        if (position == 2)
            btn_next.visibility = View.INVISIBLE
        else
            btn_next.visibility = View.VISIBLE

        when(pos){
            1 -> slide_3_1.visibility = View.VISIBLE
            2 -> slide_3_2.visibility = View.VISIBLE
        }
    }
}
