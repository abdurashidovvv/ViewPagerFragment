package com.abdurashidov.viewpagerfragment.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.abdurashidov.viewpagerfragment.ImageFragment
import com.abdurashidov.viewpagerfragment.models.User

class MyViewPagerAdapter(fm:FragmentManager, val list:ArrayList<User>):FragmentPagerAdapter(fm){
    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Fragment {
        return ImageFragment.newInstance(list[position].name, list[position].image.toString())
    }

}