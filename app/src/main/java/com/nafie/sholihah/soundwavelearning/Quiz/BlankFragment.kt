package com.nafie.sholihah.soundwavelearning.Quiz


import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.DialogFragment

import com.nafie.sholihah.soundwavelearning.R
import kotlinx.android.synthetic.main.fragment_blank.*

/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : AppCompatDialogFragment() {

    var nilai : String? = null
    var nama : String? = null
    var onPembahasanClick  : (() -> Unit) ? = null
    var onCobaClick  : (() -> Unit) ? = null
    var onKembaliClick  : (() -> Unit) ? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isCancelable = true

        nama?.let {
            dialog_name.text = "Selamat, $it. Nilai kamu"
        }

        nilai?.let {
            dialog_nilai.text = it
        }

        dialog_pembahasan.setOnClickListener {
            onPembahasanClick?.let {
                it()
            }
        }

        dialog_coba_lagi.setOnClickListener {
            onCobaClick?.let {
                it()
            }
        }

        dialog_kembali.setOnClickListener {
            onKembaliClick?.let {
                it()
            }
        }

    }
}
