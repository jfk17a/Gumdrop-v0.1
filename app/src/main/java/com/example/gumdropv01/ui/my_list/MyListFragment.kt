package com.example.gumdropv01.ui.my_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gumdropv01.R

class MyListFragment : Fragment() {

    private lateinit var myListViewModel: MyListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myListViewModel =
            ViewModelProviders.of(this).get(MyListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        myListViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}