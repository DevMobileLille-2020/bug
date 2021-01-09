package com.example.fighter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    fun initListener(navController: NavController) {
        profil.setOnClickListener {
            navController.navigate(R.id.navigation_home)
        }
        shop.setOnClickListener {
            navController.navigate(R.id.navigation_settings)
        }
        settings.setOnClickListener {
            navController.navigate(R.id.navigation_shop)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)

        initListener(navController)
    }
}