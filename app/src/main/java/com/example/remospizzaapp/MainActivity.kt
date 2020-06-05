package com.example.remospizzaapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.webkit.WebSettings.LOAD_NO_CACHE
import android.webkit.WebView
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var myToolBar: androidx.appcompat.widget.Toolbar? = null
        val navHostFragment = fragment as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.navhost)
        myToolBar = findViewById(R.id.toolbar)
        setSupportActionBar(myToolBar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        val bottomView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomView.setOnNavigationItemSelectedListener {

            when(it.itemId) {
                R.id.action_about -> navHostFragment.navController.navigate(R.id.aboutFragment)
                R.id.action_gallery -> navHostFragment.navController.navigate(R.id.galleryFragment)
                R.id.action_location -> navHostFragment.navController.navigate(R.id.locationFragment)
                R.id.action_menu -> navHostFragment.navController.navigate(R.id.menuFragment)
                R.id.action_order -> navHostFragment.navController.navigate(R.id.orderFragment)
            }

            true

        }


    }
}
