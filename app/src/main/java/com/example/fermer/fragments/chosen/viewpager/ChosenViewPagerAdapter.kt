package com.example.fermer.fragments.chosen.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fermer.fragments.chosen.screens.BuyFragment
import com.example.fermer.fragments.chosen.screens.SellFragment

class ChosenViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SellFragment()
            else -> BuyFragment()
        }
    }
}