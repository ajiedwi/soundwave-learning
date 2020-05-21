package com.nafie.sholihah.soundwavelearning.Materi.First


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nafie.sholihah.soundwavelearning.PercobaanDetailActivity

import com.nafie.sholihah.soundwavelearning.R
import com.nafie.sholihah.soundwavelearning.loadTahukahKamu
import kotlinx.android.synthetic.main.fragment_slide_1_1.*
import kotlinx.android.synthetic.main.slide_1_1.*

/**
 * A simple [Fragment] subclass.
 */
class Materi_1 : Fragment() {

    var position = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slide_1_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tahukah_kamu_1.loadTahukahKamu(requireContext())

        setMateri(position)
        btn_next.setOnClickListener {
            if (position<3){
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

        btn_percobaan_1.setOnClickListener {
            val i = Intent(requireContext(),PercobaanDetailActivity::class.java)
            i.putExtra(PercobaanDetailActivity.PERCOBAAN,1)
            startActivity(i)
        }
    }

    fun setMateri(pos : Int){
        slide_1_1.visibility = View.GONE
        slide_1_2.visibility = View.GONE
        slide_1_3.visibility = View.GONE
        tv_slide.text = "$pos/3"

        if (position == 1)
            btn_prev.visibility = View.INVISIBLE
        else
            btn_prev.visibility = View.VISIBLE

        if (position == 3)
            btn_next.visibility = View.INVISIBLE
        else
            btn_next.visibility = View.VISIBLE

        when(pos){
            1 -> slide_1_1.visibility = View.VISIBLE
            2 -> slide_1_2.visibility = View.VISIBLE
            3 -> slide_1_3.visibility = View.VISIBLE
        }
    }
}
