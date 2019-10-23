package valka.msgshareapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import valka.msgshareapp.Constants
import valka.msgshareapp.R
import valka.msgshareapp.showToast

class SecondActivity : AppCompatActivity(){

    companion object{
        val TAG:String = SecondActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        //Safe call ?.
        //Safe call with let ?.let{}

        val bundle:Bundle? = intent.extras

        bundle?.let {
            val msg =  bundle.getString(Constants.USER_MSG_KEY)

            showToast(msg)
            txvUserMessage.text = msg
        }

    }
}