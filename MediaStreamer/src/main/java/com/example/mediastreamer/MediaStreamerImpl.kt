package com.example.mediastreamer

import android.content.Context
import android.view.SurfaceView
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy

class MediaStreamerImpl(
    private val context: Context) : MediaStreamer {

    private val defaultRenderersFactory = DefaultRenderersFactory(context)
        .forceEnableMediaCodecAsynchronousQueueing()
    // selects the tack provided by media source
    private val trackSelector:DefaultTrackSelector = DefaultTrackSelector(context)
    // it takes care of media buffering
    private val loadControl:DefaultLoadControl = DefaultLoadControl.Builder().build()
    private val dataSourceFactory:DataSource.Factory = DefaultHttpDataSource.Factory()
    private val loadErrorHandlingPolicy = DefaultLoadErrorHandlingPolicy()
    private val mediaSourceFactory:DefaultMediaSourceFactory = DefaultMediaSourceFactory(context)
        .setLoadErrorHandlingPolicy(loadErrorHandlingPolicy)
        .setDataSourceFactory(dataSourceFactory)


    // creating the exoplayer instance
    private val exoplayer:ExoPlayer = ExoPlayer.Builder(context)
        .setLoadControl(loadControl)
        .setRenderersFactory(defaultRenderersFactory)
        .setTrackSelector(trackSelector)
        .setMediaSourceFactory(mediaSourceFactory)
        .build()


    override fun setSurface(surface:SurfaceView){
        exoplayer.setVideoSurfaceView(surface)
    }

    override fun getPlayer(): ExoPlayer {
        return exoplayer
    }

    override fun setSource(source:String){
        exoplayer.setMediaItem(MediaItem.fromUri(source))
        exoplayer.prepare()
        exoplayer.play()
    }

}