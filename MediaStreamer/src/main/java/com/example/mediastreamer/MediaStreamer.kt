package com.example.mediastreamer

import android.view.SurfaceView
import com.google.android.exoplayer2.ExoPlayer

interface MediaStreamer {
    fun setSource(source:String)
    fun setSurface(surfaceView: SurfaceView)
    fun getPlayer():ExoPlayer
}