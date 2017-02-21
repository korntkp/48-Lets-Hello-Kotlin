package io.github.shredktp.a48letshellokotlin;

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btn_goto_third_activity.setOnClickListener(View.OnClickListener {
            goToThirdActivity()
        })

        btn_show_toast.setOnClickListener({
            Toast.makeText(applicationContext, getString(R.string.second_toast_message), Toast.LENGTH_SHORT).show()
        })
    }

    private fun goToThirdActivity() {
        Toast.makeText(applicationContext, "Goto Third", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ThirdActivity::class.java)
        startActivity(intent)
    }
}
