package com.example.mediastreamer.ui

import android.content.Context
import android.util.AttributeSet
import com.example.mediastreamer.MediaStreamer
import com.google.android.exoplayer2.ui.StyledPlayerView

class MediaStreamerControls @JvmOverloads constructor(
    context: Context,
    attrs:AttributeSet,
    defStyle:Int = 0
) : StyledPlayerView(context,attrs,defStyle){

    fun setStreamer(mediaStreamer: MediaStreamer){
        player = mediaStreamer.getPlayer()
    }
}