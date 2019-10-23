package valka.msgshareapp.activities

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import valka.msgshareapp.Constants
import valka.msgshareapp.R
import valka.msgshareapp.showToast

class MainActivity : AppCompatActivity() {

    companion object{
        val TAG:String = MainActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener{
            Log.i(TAG, "Button was clicked !")
            showToast(resources.getString(R.string.btn_was_clicked),Toast.LENGTH_LONG)
        }

        btnSendMsgToNextActivity.setOnClickListener{

            val message: String= userMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.USER_MSG_KEY, message)
            startActivity((intent))
        }

        btnShareToOtherApps.setOnClickListener{
            val message: String= userMessage.text.toString()
            val intent=Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"share to:"))
        }

        btnREcyclerView.setOnClickListener {
            val intent = Intent(this, HobbiesActivtity::class.java)
            startActivity(intent)
        }
    }
}
