package uz.shox.fragmentstask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.shox.fragmentstask.fragment.FirstFragment
import uz.shox.fragmentstask.fragment.SecondFragment
import uz.shox.fragmentstask.model.User

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

    override fun onFirstSend(user: User?) {
            secondFragment!!.updateSecondText(user)
    }

    override fun onSecondSend(user: User?) {
        firstFragment!!.updateFirstText(user)
    }


}