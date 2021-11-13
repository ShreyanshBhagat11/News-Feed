package com.example.newsfeed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener

//import android.widget.Toolbar;
class MainActivity : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var mhome: TabItem? = null
    var mscience: TabItem? = null
    var mhealth: TabItem? = null
    var mtech: TabItem? = null
    var mentertainment: TabItem? = null
    var msports: TabItem? = null
    var pagerAdapter: PagerAdapter? = null
    var mtoolbar: Toolbar? = null
    var api = "31126acddf1443e5b8314f8e76c7a0c7"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mtoolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mtoolbar)
        mhome = findViewById(R.id.home)
        mscience = findViewById(R.id.sciance)
        msports = findViewById(R.id.sports)
        mtech = findViewById(R.id.teechnology)
        mentertainment = findViewById(R.id.entertainment)
        mhealth = findViewById(R.id.health)
        val viewPager = findViewById<ViewPager>(R.id.fragmentcontainer)
        tabLayout = findViewById(R.id.included)
        pagerAdapter = PagerAdapter(supportFragmentManager, 6)
        viewPager.adapter = pagerAdapter
        tabLayout?.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
                if (tab.position == 0 || tab.position == 1 || tab.position == 2 || tab.position == 3 || tab.position == 4 || tab.position == 5) {
                    pagerAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
    }
}