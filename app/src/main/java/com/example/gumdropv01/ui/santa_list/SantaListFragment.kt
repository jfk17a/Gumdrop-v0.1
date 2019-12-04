package com.example.gumdropv01.ui.santa_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gumdropv01.R

class SantaListFragment : Fragment() {

    private lateinit var santaListViewModel: SantaListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        santaListViewModel =
            ViewModelProviders.of(this).get(SantaListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        santaListViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}