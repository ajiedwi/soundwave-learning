package com.nafie.sholihah.soundwavelearning.Quiz


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.nafie.sholihah.soundwavelearning.R
import kotlinx.android.synthetic.main.fragment_quiz_pm.*
import kotlinx.android.synthetic.main.pm_1.*
import kotlinx.android.synthetic.main.pm_10.*
import kotlinx.android.synthetic.main.pm_2.*
import kotlinx.android.synthetic.main.pm_3.*
import kotlinx.android.synthetic.main.pm_4.*
import kotlinx.android.synthetic.main.pm_5.*
import kotlinx.android.synthetic.main.pm_6.*
import kotlinx.android.synthetic.main.pm_7.*
import kotlinx.android.synthetic.main.pm_8.*
import kotlinx.android.synthetic.main.pm_9.*

/**
 * A simple [Fragment] subclass.
 */
class QuizPMFragment : Fragment() {

    val name by lazy {
        arguments?.getString("name")
    }

    val jawaban = arrayListOf(
        arrayListOf("Panjang tabung, suhu udara, dan cepat rambat bunyi di udara","Panjang tabung dan cepat rambat bunyi di udara","Suhu udara dan bahan tabung resonator","Bahan pipa dan panjang tabung"),
        arrayListOf("Iya, sama","Nada atas dengan frekuensi 420 Hz memiliki cepat rambat lebih besar.","Nada atas dengan frekuensi 490 Hz memiliki cepat rambat lebih besar.","Tidak ada jawaban yang tepat"),
        arrayListOf("3 : 5","5 : 3","9 : 25","25 : 9"),
        arrayListOf("Selisih perbandingannya lebih dari 5","Selisih perbandingannya kurang dari 5","Selisih perbandingannya 5","Tidak ada selisih"),
        arrayListOf("1,2","2,1","2,2","3,2"),
        arrayListOf("Cepat rambat bunyi kurang dari 100 m/s","Cepat rambat bunyi lebih dari 100 m/s","Cepat rambat bunyi 210 m/s","Cepat rambat bunyi lebih dari 210 m/s"),
        arrayListOf("6 : 5","5 : 5","5 : 6","6 : 6"),
        arrayListOf("Intensitas gempa di Yogyakarta lebih besar daripada di Sragen","Intensitas gempa keduanya sama","Intensitas gempa di Yogyakarta lebih kecil daripada di Sragen","Intensitas gempa pada kedua daerah sama-sama besar"),
        arrayListOf("Taraf intensitas Desi saat memainkan biola lebih besar terdengar dari jarak 20 m.","Taraf intensitas saat biola dimainkan secara bersamaan lebih besar meskipun terdengar dari jarak 200 m.","Taraf intensitas Desi saat memainkan biola lebih besar terdengar dari jarak 200 m","Taraf intensitas saat biola dimainkan secara bersamaan lebih kecil terdengar dari jarak 20 m"),
        arrayListOf("Panjang dawai gitar diperkecil","Panjang dawai gitar diperbesar","Dawai gitar di ganti dengan dawai jenis lain","Tegangan dawai gitar diperkecil")
    )

    var userJawab = arrayListOf(5,5,5,5,5,5,5,5,5,5)
    val kunci = arrayListOf(1,1,3,0,2,3,0,2,0,0)
    var position = 0
    var pembahasan = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_pm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setQuiz(position)
        btn_next.setOnClickListener {
            if (position<9){
                position+=1
                setQuiz(position)
            }
        }

        btn_prev.setOnClickListener {
            if (position>0){
                position-=1
                setQuiz(position)
            }
        }

        btn_finish.setOnClickListener {
            val fragment = BlankFragment()

            fragment.nama = name
            var skor = 0
            for (i in userJawab.indices){
                if (userJawab.get(i) == kunci.get(i))
                    skor+=10
            }
            fragment.nilai = skor.toString()
            fragment.onKembaliClick = {
                fragment.dismiss()
                requireActivity().finish()
            }
            fragment.onPembahasanClick = {
                pembahasan = true
                position = 0
                setQuiz(position)
                fragment.dismiss()

            }
            fragment.onCobaClick = {
                userJawab = arrayListOf(5,5,5,5,5,5,5,5,5,5)
                position = 0
                pembahasan = false
                setQuiz(position)
                fragment.dismiss()

            }
            fragment.show(requireFragmentManager(),"jajal")
        }

        rv_option_pm.layoutManager = LinearLayoutManager(requireContext())
    }

    fun setQuiz(pos : Int){
        pm_10.visibility = View.GONE
        pm_1.visibility = View.GONE
        pm_2.visibility = View.GONE
        pm_3.visibility = View.GONE
        pm_4.visibility = View.GONE
        pm_5.visibility = View.GONE
        pm_6.visibility = View.GONE
        pm_7.visibility = View.GONE
        pm_8.visibility = View.GONE
        pm_9.visibility = View.GONE

        tv_slide.text = "${pos+1}/10"

        if (position == 0)
            btn_prev.visibility = View.INVISIBLE
        else
            btn_prev.visibility = View.VISIBLE

        if (position == 9){
            btn_next.visibility = View.INVISIBLE
            btn_finish.visibility = View.VISIBLE
        }
        else{
            btn_next.visibility = View.VISIBLE
            btn_finish.visibility = View.GONE
        }

        when(pos){
            0 -> pm_1.visibility = View.VISIBLE
            1 -> pm_2.visibility = View.VISIBLE
            2 -> pm_3.visibility = View.VISIBLE
            3 -> pm_4.visibility = View.VISIBLE
            4 -> pm_5.visibility = View.VISIBLE
            5 -> pm_6.visibility = View.VISIBLE
            6 -> pm_7.visibility = View.VISIBLE
            7 -> pm_8.visibility = View.VISIBLE
            8 -> pm_9.visibility = View.VISIBLE
            9 -> pm_10.visibility = View.VISIBLE
        }
        if (pembahasan){
            pembahasan_pm_1.visibility = View.VISIBLE
            pembahasan_pm_10.visibility = View.VISIBLE
            pembahasan_pm_4.visibility = View.VISIBLE
            pembahasan_pm_5.visibility = View.VISIBLE
            pembahasan_pm_2.visibility = View.VISIBLE
            pembahasan_pm_3.visibility = View.VISIBLE
            pembahasan_pm_6.visibility = View.VISIBLE
            pembahasan_pm_7.visibility = View.VISIBLE
            pembahasan_pm_8.visibility = View.VISIBLE
            pembahasan_pm_9.visibility = View.VISIBLE
        } else {
            pembahasan_pm_6.visibility = View.GONE
            pembahasan_pm_1.visibility = View.GONE
            pembahasan_pm_2.visibility = View.GONE
            pembahasan_pm_3.visibility = View.GONE
            pembahasan_pm_4.visibility = View.GONE
            pembahasan_pm_5.visibility = View.GONE
            pembahasan_pm_7.visibility = View.GONE
            pembahasan_pm_8.visibility = View.GONE
            pembahasan_pm_9.visibility = View.GONE
            pembahasan_pm_10.visibility = View.GONE
        }

        rv_option_pm.adapter = Adapter(jawaban.get(pos))
    }

    inner class Adapter(var datas:ArrayList<String>): RecyclerView.Adapter<ViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(requireContext()).inflate(R.layout.item_option_quiz, parent, false))
        }

        override fun getItemCount(): Int {
            return datas.size
        }


        override fun onBindViewHolder(holder: ViewHolder, pos: Int) {

            holder.tvName.text = datas.get(pos)

            holder.itemView.setOnClickListener{
                if (!pembahasan){
                    userJawab.set(position,pos)
                    notifyDataSetChanged()
                }

            }

            if (kunci.get(position) == pos && pembahasan)
                holder.ivTrue.visibility = View.VISIBLE
            else holder.ivTrue.visibility = View.INVISIBLE

            if (userJawab.get(position) == pos){
                holder.tvName.setTextColor(ContextCompat.getColor(requireContext(),R.color.backgroundWhite))
                holder.cl.background = ContextCompat.getDrawable(requireContext(),R.drawable.bg_quiz_selected)
            } else {
                holder.cl.background = ContextCompat.getDrawable(requireContext(),R.drawable.bg_quiz_unselected)
                holder.tvName.setTextColor(ContextCompat.getColor(requireContext(),R.color.frenchPuce))
            }
        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cl : ConstraintLayout = itemView.findViewById(R.id.cl_option_quiz)
        val ivTrue : ImageView = itemView.findViewById(R.id.item_option_quiz_true)
        val tvName : TextView = itemView.findViewById(R.id.tv_item_quiz_option)

    }
}
