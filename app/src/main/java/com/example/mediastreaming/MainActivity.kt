package com.example.mediastreaming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceView
import com.example.mediastreamer.MediaStreamer
import com.example.mediastreamer.MediaStreamerImpl
import com.example.mediastreamer.ui.MediaStreamerControls

class MainActivity : AppCompatActivity() {
    private lateinit var mediaStreamer: MediaStreamer
    private lateinit var medisStreamerControls: MediaStreamerControls
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaStreamer = MediaStreamerImpl(this)
        medisStreamerControls = findViewById(R.id.streamer_controls)
        medisStreamerControls.setStreamer(mediaStreamer)
        mediaStreamer.setSource("https://devstreaming-cdn.apple.com/videos/streaming/examples/bipbop_16x9/bipbop_16x9_variant.m3u8")
    }
}