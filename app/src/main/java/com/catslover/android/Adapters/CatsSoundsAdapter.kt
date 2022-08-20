package com.catslover.android.Adapters

import android.app.Activity
import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.recyclerview.widget.RecyclerView
import com.catslover.android.dataclasses.CatSounds
import com.catslover.android.ilovecats.MainActivity
import com.catslover.android.ilovecats.R
import com.catslover.android.ilovecats.databinding.CatsoundrecyclerItemBinding
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class CatsSoundsAdapter(private  val soundsList:List<CatSounds>,private val context: Context):
    RecyclerView.Adapter<CatsSoundsAdapter.CatsSoundViewHolder>() {


    companion object {
        private var mediaPlayer: MediaPlayer? = null
        var handler: Handler = Handler(Looper.getMainLooper())
        var runnable: Runnable = Runnable { }

    }

    init {

        setHasStableIds(true)
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC);

    }


    inner class CatsSoundViewHolder(
        private val binding: CatsoundrecyclerItemBinding,
        private val mcontext: Context,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(catsound: CatSounds) {
            binding.catitem = catsound
            binding.btnShowmeaning.setOnClickListener {
                if (binding.catsmewoMeaning.visibility == View.GONE){
                    binding.catsmewoMeaning.visibility = View.VISIBLE
                }else if (binding.catsmewoMeaning.visibility == View.VISIBLE){

                    binding.catsmewoMeaning.visibility = View.GONE

                }
            }
            binding.btnPlay.setOnClickListener {
                binding.btnPlay.setOnClickListener {
                    if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                        mediaPlayer!!.stop()
                        mediaPlayer!!.reset()
                        mediaPlayer!!.release()
                        mediaPlayer = null

                        handler.removeCallbacks(runnable)
                        binding.seekbar.progress = 0
                        binding.btnPlay.setImageResource(R.drawable.ic_baseline_play_arrow_24)
                    } else {

                        mediaPlayer = MediaPlayer.create(mcontext, catsound.soundTone)
                        binding.seekbar.max = mediaPlayer!!.duration
                        mediaPlayer!!.start()
                        mediaPlayer!!.isLooping = true


                        runnable = object : Runnable {
                            override fun run() {
                                val current_pos = mediaPlayer!!.getCurrentPosition();
                                binding.seekbar.setProgress(current_pos.toInt())

                                handler.postDelayed(this, 1000)
                            }
                        }
                        handler.postDelayed(runnable, 0)

                        binding.btnPlay.setImageResource(R.drawable.ic_baseline_pause_24)
                    }


                }


            }

            binding.seekbar.setOnSeekBarChangeListener(
                object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(
                        seekBar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean,
                    ) {
                        if (fromUser) {
                            if (mediaPlayer != null) {

                                mediaPlayer!!.seekTo(progress)
                                binding.seekbar.setProgress(progress);
                            }
                        }
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        if (mediaPlayer != null) {
                            mediaPlayer!!.seekTo(binding.seekbar.getProgress());

                        }
                    }
                }
            )
        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsSoundViewHolder {
            val binding: CatsoundrecyclerItemBinding = CatsoundrecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
            return CatsSoundViewHolder(binding,context)
        }

        override fun onBindViewHolder(holder: CatsSoundViewHolder, position: Int) {
            val catsoundItem = soundsList[position]
            holder.bind(catsoundItem)


        }

        override fun getItemCount(): Int = soundsList.size
        fun clearMediaPlayer() {
            if (mediaPlayer != null) {
                mediaPlayer!!.stop()
                handler.removeCallbacks(runnable)
                mediaPlayer!!.reset()
                mediaPlayer!!.release()
                mediaPlayer = null
            }
        }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }




}
