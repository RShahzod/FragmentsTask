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
import uz.shox.fragmentstask.model.User

class SecondFragment: Fragment() {
    private var listener: SecondListener? = null
    var tv_second: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        initViews(view)
        return view
    }

    fun initViews(view: View) {
        tv_second = view.findViewById(R.id.secondText)
        val b_second = view.findViewById<Button>(R.id.secondSendBtn)
        val users = User("Shox",22)
        b_second.setOnClickListener {
            listener!!.onSecondSend(users) }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is SecondListener) {
            context
        } else {
            throw RuntimeException("$context must implement SecondListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun updateSecondText(user: User?) {
        tv_second!!.text = user.toString()
    }

    interface SecondListener {
        fun onSecondSend(user: User?)
    }
}