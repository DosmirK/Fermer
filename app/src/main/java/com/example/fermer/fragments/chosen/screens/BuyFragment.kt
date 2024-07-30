package com.example.fermer.fragments.chosen.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fermer.R
import com.example.fermer.data.AdvertModel
import com.example.fermer.databinding.FragmentBuyBinding
import com.example.fermer.fragments.chosen.adapter.AdvertAdapter

class BuyFragment : Fragment() {

    private var _binding: FragmentBuyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = listOf(
            AdvertModel(R.mipmap.ic_launcher, "Описание 1", "Цена 1"),
            AdvertModel(R.mipmap.ic_launcher, "Описание 2", "Цена 2"),
            AdvertModel(R.mipmap.ic_launcher, "Описание 3", "Цена 3")
        )

        val adapter = AdvertAdapter(items)
        binding.rvBuy.adapter = adapter

    }

}