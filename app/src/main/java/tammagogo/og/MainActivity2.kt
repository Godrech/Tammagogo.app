package tammagogo.og

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.VideoView

class MainActivity2 : AppCompatActivity() {

    //declarations
    private lateinit var playButton: Button
    private lateinit var cleanButton: Button
    private lateinit var feedButton: Button
    private lateinit var backButton: Button

    private lateinit var playProgressBar: ProgressBar
    private lateinit var cleanProgressBar: ProgressBar
    private lateinit var feedProgressBar: ProgressBar

    private lateinit var imageView: ImageView
    private lateinit var videoView: VideoView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //intializing

        playButton = findViewById(R.id.playButton)
        cleanButton = findViewById(R.id.cleanButton)
        feedButton = findViewById(R.id.feedButton)
        backButton = findViewById(R.id.backButton)

        playProgressBar = findViewById(R.id.playProgressBar)
        cleanProgressBar = findViewById(R.id.cleanProgressBar)
        feedProgressBar = findViewById(R.id.feedProgressBar)

        imageView = findViewById(R.id.imageView)
        videoView = findViewById(R.id.videoView)

        imageView.visibility = View.VISIBLE
        videoView.visibility = View.GONE

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        //

        feedButton.setOnClickListener {
            playProgressBar.incrementProgressBy(-10)
            cleanProgressBar.incrementProgressBy(-5)
            feedProgressBar.incrementProgressBy(20)

            imageView.visibility = View.GONE
            videoView.visibility = View.VISIBLE

            val videoView = findViewById<VideoView>(R.id.videoView)
            videoView.setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.dogfood}"))
            videoView.start()


        }
        cleanButton.setOnClickListener {
            videoView.pause()
            cleanProgressBar.incrementProgressBy(20)
            feedProgressBar.incrementProgressBy(-5)
            playProgressBar.incrementProgressBy(-10)

            imageView.visibility = View.GONE
            videoView.visibility = View.VISIBLE
            val videoView = findViewById<VideoView>(R.id.videoView)
            videoView.setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.dogwash}"))
            videoView.start()


        }
        playButton.setOnClickListener{
            imageView.visibility = View.GONE
            videoView.visibility = View.VISIBLE
            videoView.start()
            playProgressBar.incrementProgressBy(20)
            cleanProgressBar.incrementProgressBy(-20)
            feedProgressBar.incrementProgressBy(-10)
            // Check if the clean progress bar is at 50%
            if (cleanProgressBar.progress <= 50) {
                // Change the video to another video
                videoView.setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.dogplaydirty}"))
            } else {
                // Set the video to the default clean video
                videoView.setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.dogplay}"))
            }

            // Start playing the video
            videoView.start()

        }

    }
}