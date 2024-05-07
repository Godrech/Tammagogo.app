package tammagogo.og

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView

class MainActivity : AppCompatActivity() {

    private lateinit var playGameButton: Button
    private lateinit var videoView2: VideoView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView2 = findViewById(R.id.videoView2)
        playGameButton = findViewById(R.id.playGameButton)

        playGameButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()

        // Start video playback when the activity is resumed
        videoView2.setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.intro}"))
        videoView2.start()
    }


}