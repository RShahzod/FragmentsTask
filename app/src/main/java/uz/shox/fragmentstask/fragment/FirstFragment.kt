package uz.shox.fragmentstask.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import uz.shox.fragmentstask.R

class FirstFragment: Fragment() {

    private var listener: FirstListener? = null
    var tv_first: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, con: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val view =  inflater.inflate(R.layout.fragment_first, con, false)
        initViews(view)
        return view
    }

    fun initViews(view: View) {
        tv_first = view.findViewById(R.id.firstText)
        val b_first= view.findViewById<Button>(R.id.firstSendBtn)
        b_first.setOnClickListener { listener!!.onFirstSend("Google1") }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is FirstListener) {
            context
        } else {
            throw RuntimeException("$context must implement FirstListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun updateFirstText(str: String?) {
        tv_first!!.text = str
    }

    interface FirstListener {
        fun onFirstSend(str: String?)
    }
}