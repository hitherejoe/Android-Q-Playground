package co.joebirch.androidqplayground

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import kotlinx.android.synthetic.main.activity_settings_panel.*

class SettingsPanelActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE_CONNECTIVITY = 1544
        const val REQUEST_CODE_NFC = 1544
        const val REQUEST_CODE_VOLUME = 1544
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_panel)

        button_connectivity.setOnClickListener {
            openSettingsPanel(Settings.Panel.ACTION_INTERNET_CONNECTIVITY, REQUEST_CODE_CONNECTIVITY)
        }

        button_nfc.setOnClickListener {
            openSettingsPanel(Settings.Panel.ACTION_NFC, REQUEST_CODE_NFC)
        }

        button_volume.setOnClickListener {
            openSettingsPanel(Settings.Panel.ACTION_VOLUME, REQUEST_CODE_VOLUME)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun openSettingsPanel(panel: String, code: Int) {
        val panelIntent = Intent(panel)
        startActivity(panelIntent)
    }
}
