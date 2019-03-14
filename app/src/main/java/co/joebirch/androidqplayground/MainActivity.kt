package co.joebirch.androidqplayground

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_settings_panels.setOnClickListener {
            startActivity(Intent(this, SettingsPanelActivity::class.java))
        }
        button_location.setOnClickListener {
            startActivity(Intent(this, LocationActivity::class.java))
        }
    }
}
