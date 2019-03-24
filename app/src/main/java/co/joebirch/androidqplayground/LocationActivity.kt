package co.joebirch.androidqplayground

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_location.*

class LocationActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE_FOREGROUND = 1544
        const val REQUEST_CODE_BACKGROUND = 1545
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        button_foreground.setOnClickListener {
            requestPermission()
        }
        button_background.setOnClickListener {
            requestBackgroundPermission()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_CODE_FOREGROUND -> handlePermissionForForeground()
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun requestPermission() {
        val hasLocationPermission = ActivityCompat.checkSelfPermission(this,
            Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

        if (hasLocationPermission) {
            // handle location update
        } else {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), REQUEST_CODE_FOREGROUND)
        }
    }

    private fun requestBackgroundPermission() {
        val hasForegroundLocationPermission = ActivityCompat.checkSelfPermission(this,
            Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

        if (hasForegroundLocationPermission) {
            val hasBackgroundLocationPermission = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED

            if (hasBackgroundLocationPermission) {
                // handle location update
            } else {
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION), REQUEST_CODE_BACKGROUND)
            }
        } else {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION), REQUEST_CODE_BACKGROUND)
        }
    }

    private fun handlePermissionForForeground() {

    }
}
