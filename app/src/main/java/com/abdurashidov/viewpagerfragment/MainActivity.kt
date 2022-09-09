package com.abdurashidov.viewpagerfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdurashidov.viewpagerfragment.adapters.MyViewPagerAdapter
import com.abdurashidov.viewpagerfragment.databinding.ActivityMainBinding
import com.abdurashidov.viewpagerfragment.models.User

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

            //Ko'proq fragmentdan foydalanishda adapterda when ni ishlatib alohida return qiling.!

    }

    private fun loadData() {
        list= ArrayList()
        list.add(User("Erdog'on", R.drawable.img))
        list.add(User("Rasul Kusherbayev", R.drawable.img_1))
        list.add(User("Blinken", R.drawable.img_2))
    }
}