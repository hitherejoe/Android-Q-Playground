package co.joebirch.androidqplayground

import android.annotation.SuppressLint
import android.content.Context
import android.net.wifi.p2p.WifiP2pConfig
import android.net.wifi.p2p.WifiP2pManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_wifi_connect.*

class WifiConnectActivity : AppCompatActivity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi_connect)

        button_connect.setOnClickListener {
            connectToWifi()
        }
    }

    @SuppressLint("NewApi")
    private fun connectToWifi() {
        val manager = getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager
        val channel = manager.initialize(this, mainLooper, null)

        val config = WifiP2pConfig.Builder()
            .setNetworkName("networkName")
            .setPassphrase("passphrase")
            .enablePersistentMode(false)
            .setGroupOperatingBand(WifiP2pConfig.GROUP_OWNER_BAND_5GHZ)
            .build()

        manager.createGroup(channel, config, object : WifiP2pManager.ActionListener {
            override fun onSuccess() {
                manager.connect(channel, config, object : WifiP2pManager.ActionListener {
                    override fun onSuccess() {

                    }

                    override fun onFailure(p0: Int) {

                    }
                })
            }

            override fun onFailure(p0: Int) {

            }
        })
    }
}
