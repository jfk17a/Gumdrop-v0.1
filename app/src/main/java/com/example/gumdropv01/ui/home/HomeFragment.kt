package com.example.gumdropv01.ui.home

import android.os.Bundle
import java.text.SimpleDateFormat
import java.util.Date
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gumdropv01.R
import kotlinx.android.synthetic.*

class HomeFragment : Fragment() {

    private lateinit var txtTimerDay:TextView
    private lateinit var txtTimerHour:TextView
    private lateinit var txtTimerMinute:TextView
    private lateinit var txtTimerSecond:TextView
    private lateinit var tvEvent:TextView
    private lateinit var handler:Handler
    private lateinit var runnable:Runnable
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        txtTimerDay = root.findViewById(R.id.txtTimerDay) as TextView
        txtTimerHour = root.findViewById(R.id.txtTimerHour) as TextView
        txtTimerMinute = root.findViewById(R.id.txtTimerMinute) as TextView
        txtTimerSecond = root.findViewById(R.id.txtTimerSecond) as TextView
        tvEvent = root.findViewById(R.id.tvhappyevent) as TextView
        countDownStart()
        //homeViewModel.text.observe(this, Observer {
        //    textView.text = it
        //})
        return root
    }

    fun countDownStart() {
        handler = Handler()
        runnable = object:Runnable {
            public override fun run() {
                handler.postDelayed(this, 1000)
                try
                {
                    val dateFormat = SimpleDateFormat(
                        "yyyy-MM-dd")
                    // Please here set your event date//YYYY-MM-DD
                    val futureDate = dateFormat.parse("2015-12-25")
                    val currentDate = Date()
                    if (!currentDate.after(futureDate))
                    {
                        var diff = (futureDate.getTime() - currentDate.getTime())
                        val days = diff / (24 * 60 * 60 * 1000)
                        diff -= days * (24 * 60 * 60 * 1000)
                        val hours = diff / (60 * 60 * 1000)
                        diff -= hours * (60 * 60 * 1000)
                        val minutes = diff / (60 * 1000)
                        diff -= minutes * (60 * 1000)
                        val seconds = diff / 1000
                        txtTimerDay.setText("" + String.format("%02d", days))
                        txtTimerHour.setText("" + String.format("%02d", hours))
                        txtTimerMinute.setText(("" + String.format("%02d", minutes)))
                        txtTimerSecond.setText(("" + String.format("%02d", seconds)))
                    }
                    else
                    {
                        tvEvent.setVisibility(View.VISIBLE)
                        tvEvent.setText("The event started!")
                        txtTimerDay.setText("" + String.format("%02d", "00"))
                        txtTimerHour.setText("" + String.format("%02d", "00"))
                        txtTimerMinute.setText(("" + String.format("%02d", "00")))
                        txtTimerSecond.setText(("" + String.format("%02d", "00")))
                    }
                }
                catch (e:Exception) {
                    e.printStackTrace()
                }
            }
        }
        handler.postDelayed(runnable, 1 * 1000)
    }

}