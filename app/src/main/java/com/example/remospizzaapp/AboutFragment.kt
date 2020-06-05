package com.example.remospizzaapp

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_about.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

            //configureVideoView()

        }
    }

//    private fun configureVideoView() {
//
//        videoView.setVideoPath(
//            "https://www.remospizza.com/assets/bella-firenze/video/remo_60hd.mp4")
//
//        videoView.start()
//    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val view = inflater.inflate(R.layout.fragment_about, container, false)

        //val recView = view.findViewById(R.id.aboutFragment) as RecyclerView
//        aboutRecyclerView.apply{
//            layoutManager = LinearLayoutManager(activity)
//
//
//        }
            val aboutusText: TextView = view.findViewById(R.id.textView)
            //aboutusText.text = "hewll"
            //val video:VideoView = view.findViewById(R.id.videoView)

        val videoToView:VideoView = view.findViewById(R.id.videoView)
        val url = Uri.parse("https://www.remospizza.com/assets/bella-firenze/video/remo_60hd.mp4")

        var TAG = "VideoPlayer"
        videoToView.setVideoURI(url)
        videoToView.isSoundEffectsEnabled = false
//        val mediaController = MediaController(view.context)
//        mediaController?.setAnchorView(videoToView)
//        videoToView.setMediaController(mediaController)

//        videoToView.setOnPreparedListener { mp ->
//            mp.isLooping = true
//            Log.i(TAG, "Duration = " + videoToView.duration)
//        }
        videoToView.start()
        val pause:ImageView = view.findViewById(R.id.pause)
        pause.visibility = View.INVISIBLE
        videoToView.setOnClickListener{
            if(videoToView.isPlaying){
                videoToView.pause()
                videoToView.isSoundEffectsEnabled = false
                pause.visibility = View.VISIBLE
            }else {
                videoToView.start()
                videoToView.isSoundEffectsEnabled = true
                pause.visibility = View.INVISIBLE
            }
        }



        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AboutFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AboutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
