package co.joebirch.androidqplayground

import android.content.Intent
import android.os.Bundle
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_share.*

class ShareActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)


        when {
            intent?.action == Intent.ACTION_SEND -> {
                if ("text/plain" == intent.type) {
                    intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
                        text_shared.text = it
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P &&
                        intent.hasExtra(Intent.EXTRA_SHORTCUT_ID)) {
                        val shortcutId = intent.getStringExtra(Intent.EXTRA_SHORTCUT_ID)
                        val e = ""
                    }
                }
            }
        }

    }
}
