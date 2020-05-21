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
import kotlinx.android.synthetic.main.bk_1.*
import kotlinx.android.synthetic.main.bk_10.*
import kotlinx.android.synthetic.main.bk_2.*
import kotlinx.android.synthetic.main.bk_3.*
import kotlinx.android.synthetic.main.bk_4.*
import kotlinx.android.synthetic.main.bk_5.*
import kotlinx.android.synthetic.main.bk_6.*
import kotlinx.android.synthetic.main.bk_7.*
import kotlinx.android.synthetic.main.bk_8.*
import kotlinx.android.synthetic.main.bk_9.*
import kotlinx.android.synthetic.main.fragment_quiz_bk.*

/**
 * A simple [Fragment] subclass.
 */
class QuizBKFragment : Fragment() {

    val name by lazy {
        arguments?.getString("name")
    }

    val jawaban = arrayListOf(
        arrayListOf("A","B","A dan B memiliki frekuensi yang sama","Semua Salah"),
        arrayListOf("A","B","A dan B memiliki bunyi yang sama","Semua Salah"),
        arrayListOf("Frekuensi rendah","Frekuensi tinggi","Amplitudo getaran sumber lebih besar dari amplitudo getaran resonansi","Amplitudo getaran resonansi lebih besar dari amplitude getaran sumber"),
        arrayListOf("Pernyataan 2 dan 3","Pernyataan 1 dan 2","Pernyataan 3 dan 4","Pernyataan 4 dan 5"),
        arrayListOf("1 : 3","2 : 3","1 : 6","6 : 1"),
        arrayListOf("0,1m","0,6m","0,16m","0,24m"),
        arrayListOf("3m","9m","18m","27m"),
        arrayListOf("4 : 6,4","6,4 : 4","6 : 7,3","7,3 : 6"),
        arrayListOf("168 W.m\u207b\u00b2","84 W.m⁻²","42 W.m⁻²","21 W.m⁻²"),
        arrayListOf("170 m/s","270 m/s","370 m/s","470 m/s")
    )

    var userJawab = arrayListOf(5,5,5,5,5,5,5,5,5,5)
    val kunci = arrayListOf(1,1,3,0,2,3,0,2,3,2)
    var position = 0
    var pembahasan = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_bk, container, false)
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

        rv_option_bk.layoutManager = LinearLayoutManager(requireContext())
    }

    fun setQuiz(pos : Int){
        bk_1.visibility = View.GONE
        bk_2.visibility = View.GONE
        bk_3.visibility = View.GONE
        bk_4.visibility = View.GONE
        bk_5.visibility = View.GONE
        bk_6.visibility = View.GONE
        bk_7.visibility = View.GONE
        bk_8.visibility = View.GONE
        bk_9.visibility = View.GONE
        bk_10.visibility = View.GONE

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
            0 -> bk_1.visibility = View.VISIBLE
            1 -> bk_2.visibility = View.VISIBLE
            2 -> bk_3.visibility = View.VISIBLE
            3 -> bk_4.visibility = View.VISIBLE
            4 -> bk_5.visibility = View.VISIBLE
            5 -> bk_6.visibility = View.VISIBLE
            6 -> bk_7.visibility = View.VISIBLE
            7 -> bk_8.visibility = View.VISIBLE
            8 -> bk_9.visibility = View.VISIBLE
            9 -> bk_10.visibility = View.VISIBLE
        }
        if (pembahasan){
            pembahasan_bk_1.visibility = View.VISIBLE
            pembahasan_bk_3.visibility = View.VISIBLE
            pembahasan_bk_2.visibility = View.VISIBLE
            pembahasan_bk_4.visibility = View.VISIBLE
            pembahasan_bk_5.visibility = View.VISIBLE
            pembahasan_bk_6.visibility = View.VISIBLE
            pembahasan_bk_7.visibility = View.VISIBLE
            pembahasan_bk_8.visibility = View.VISIBLE
            pembahasan_bk_9.visibility = View.VISIBLE
            pembahasan_bk_10.visibility = View.VISIBLE
        } else {
            pembahasan_bk_1.visibility = View.GONE
            pembahasan_bk_3.visibility = View.GONE
            pembahasan_bk_2.visibility = View.GONE
            pembahasan_bk_4.visibility = View.GONE
            pembahasan_bk_5.visibility = View.GONE
            pembahasan_bk_6.visibility = View.GONE
            pembahasan_bk_7.visibility = View.GONE
            pembahasan_bk_8.visibility = View.GONE
            pembahasan_bk_9.visibility = View.GONE
            pembahasan_bk_10.visibility = View.GONE
        }

        rv_option_bk.adapter = Adapter(jawaban.get(pos))
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
