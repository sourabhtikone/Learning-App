package com.example.enr_thelearningapp;

import android.app.Application;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

public class poemViewHolder extends RecyclerView.ViewHolder {

     View mview;
     SimpleExoPlayer exoPlayer;
     private PlayerView mExoplayerView;



     public poemViewHolder(@NonNull View itemView) {
        super(itemView);
        mview=itemView;
    }

    public void setVideo(final Application ctx ,String title,final String url){

        TextView mtextView=mview.findViewById(R.id.poemtitle);
        mExoplayerView=mview.findViewById(R.id.exoplayer_view);


        mtextView.setText(title);
        try {
            BandwidthMeter bandwidthMeter=new DefaultBandwidthMeter.Builder(ctx).build();

            TrackSelector trackSelector=new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer=(SimpleExoPlayer) ExoPlayerFactory.newSimpleInstance(ctx);
            Uri video=Uri.parse(url);
            DefaultHttpDataSourceFactory dataSourceFactory=new DefaultHttpDataSourceFactory("video");
            ExtractorsFactory extractorsFactory=new DefaultExtractorsFactory();
            MediaSource mediaSource=new ExtractorMediaSource(video,dataSourceFactory,extractorsFactory,null,null);

            mExoplayerView.setPlayer((exoPlayer));
            exoPlayer.prepare(mediaSource);
            exoPlayer.setPlayWhenReady(false);
        }catch (Exception e){
            Log.e("poemViewHolder","exoplayer error" +e.toString());
        }
    }
}
