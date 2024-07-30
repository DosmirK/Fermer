package com.example.fermer.fragments.chosen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fermer.databinding.FragmentChosenBinding
import com.example.fermer.fragments.chosen.viewpager.ChosenViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class ChosenFragment : Fragment() {

    private var _binding: FragmentChosenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChosenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = ChosenViewPagerAdapter(this)
        binding.apply {
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = when (position) {
                    0 -> "Продать"
                    else -> "Купить"
                }
            }.attach()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}