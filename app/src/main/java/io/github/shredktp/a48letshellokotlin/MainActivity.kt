package io.github.shredktp.a48letshellokotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_hello.text = getString(R.string.main_tv_hello_kotlin)

        val btnGotoSecond = findViewById(R.id.btn_goto_second)
        btnGotoSecond.setOnClickListener {
            GotoSecondActivity()
        }
    }

    private fun GotoSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}
