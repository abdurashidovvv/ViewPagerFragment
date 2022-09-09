package com.abdurashidov.viewpagerfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.abdurashidov.viewpagerfragment.adapters.MyViewPagerAdapter
import com.abdurashidov.viewpagerfragment.databinding.ActivityMainBinding
import com.abdurashidov.viewpagerfragment.databinding.ItemTabViewBinding
import com.abdurashidov.viewpagerfragment.models.User
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var list:ArrayList<User>
    private lateinit var myViewPagerAdapter: MyViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        myViewPagerAdapter=MyViewPagerAdapter(supportFragmentManager, list)
        binding.myViewPager.adapter=myViewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.myViewPager)

            //Ko'proq fragmentdan foydalanishda adapterda when ni ishlatib alohida return qiling.!

        setTab()

    }

    private fun setTab() {
        val tabCount = binding.tabLayout.tabCount

        for (i in 0 until tabCount){
            val tabItemView=ItemTabViewBinding.inflate(layoutInflater)
            val tab=binding.tabLayout.getTabAt(i)
            tab?.customView=tabItemView.root

            tabItemView.tabTv.text=list[i].name

            if (i==0){
                tabItemView.imageIndicator.visibility=View.VISIBLE
            }else{
                tabItemView.imageIndicator.visibility=View.GONE
            }


            binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val customView=tab?.customView
                    customView?.findViewById<ImageView>(R.id.image_indicator)?.visibility=View.VISIBLE
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    val customView=tab?.customView
                    customView?.findViewById<ImageView>(R.id.image_indicator)?.visibility=View.GONE
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    TODO("Not yet implemented")
                }
            })

        }

    }

    private fun loadData() {
        list= ArrayList()
        list.add(User("Erdog'on", R.drawable.img))
        list.add(User("Kusherbayev", R.drawable.img_1))
        list.add(User("Blinken", R.drawable.img_2))
    }
}