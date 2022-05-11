package uz.shox.fragmentstask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.shox.fragmentstask.fragment.FirstFragment
import uz.shox.fragmentstask.fragment.SecondFragment

class SecondActivity : AppCompatActivity(), FirstFragment.FirstListener, SecondFragment.SecondListener {

    var firstFragment: FirstFragment? = null
    var secondFragment: SecondFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        firstFragment = FirstFragment()
        secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.firstFragment,firstFragment!!)
            .replace(R.id.secondFragment,secondFragment!!)
            .commit()
    }

    override fun onFirstSend(str: String?) {
            secondFragment!!.updateSecondText("Google")
    }

    override fun onSecondSend(str: String?) {
        firstFragment!!.updateFirstText(str)
    }


}