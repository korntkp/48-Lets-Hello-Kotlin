package io.github.shredktp.a48letshellokotlin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Code -> Convert Java file to Kotlin File (Ctrl + Alt + Shift + K)
 * */
public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnGotoMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btnGotoMain = (Button) findViewById(R.id.btn_goto_main);
        btnGotoMain.setText(R.string.third_button_goto_main);
        btnGotoMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_goto_main: {
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }
    }
}
