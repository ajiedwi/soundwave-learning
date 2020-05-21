package com.nafie.sholihah.soundwavelearning.Materi.First


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.nafie.sholihah.soundwavelearning.PercobaanDetailActivity
import com.nafie.sholihah.soundwavelearning.R
import com.nafie.sholihah.soundwavelearning.loadTahukahKamu
import kotlinx.android.synthetic.main.fragment_materi_2.*
import kotlinx.android.synthetic.main.fragment_slide_1_1.*
import kotlinx.android.synthetic.main.fragment_slide_1_1.btn_next
import kotlinx.android.synthetic.main.fragment_slide_1_1.btn_prev
import kotlinx.android.synthetic.main.fragment_slide_1_1.slide_1_2
import kotlinx.android.synthetic.main.fragment_slide_1_1.tv_slide
import kotlinx.android.synthetic.main.slide_1_1.*
import kotlinx.android.synthetic.main.slide_2_1.*
import kotlinx.android.synthetic.main.slide_2_3.*

/**
 * A simple [Fragment] subclass.
 */
class Materi_2 : Fragment() {

    var position = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_materi_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMateri(position)
        val mediaController = MediaController(requireContext())
        btn_next.setOnClickListener {
            if (position<4){
                position+=1
                setMateri(position)
            }
            if (video_2_3.isPlaying)
                video_2_3.pause()
            if (mediaController.isShowing)
                mediaController.hide()
        }

        tahukah_kamu_2.loadTahukahKamu(requireContext())

        btn_prev.setOnClickListener {
            if (position>1){
                position-=1
                setMateri(position)
            }
            if (video_2_3.isPlaying)
                video_2_3.pause()
            if (mediaController.isShowing)
                mediaController.hide()
        }

        video_2_3.setVideoURI(Uri.parse("android.resource://"+requireContext().packageName+"/"+R.raw.video))
        mediaController.setAnchorView(video_2_3)
        video_2_3.setMediaController(mediaController)
        video_2_3.start()

        btn_percobaan_2.setOnClickListener {
            val i = Intent(requireContext(), PercobaanDetailActivity::class.java)
            i.putExtra(PercobaanDetailActivity.PERCOBAAN,2)
            startActivity(i)
        }
    }

    fun setMateri(pos : Int){
        slide_2_1.visibility = View.GONE
        slide_2_2.visibility = View.GONE
        slide_2_3.visibility = View.GONE
        slide_2_4.visibility = View.GONE
        tv_slide.text = "$pos/4"

        if (position == 1)
            btn_prev.visibility = View.INVISIBLE
        else
            btn_prev.visibility = View.VISIBLE

        if (position == 4)
            btn_next.visibility = View.INVISIBLE
        else
            btn_next.visibility = View.VISIBLE

        when(pos){
            1 -> slide_2_1.visibility = View.VISIBLE
            2 -> slide_2_2.visibility = View.VISIBLE
            3 -> slide_2_3.visibility = View.VISIBLE
            4 -> slide_2_4.visibility = View.VISIBLE
        }
    }
}
