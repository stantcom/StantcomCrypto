package com.example.stantcomcrypto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isGone
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.stantcomcrypto.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity() {
    private var _binding: LoginActivityBinding? = null
    private val binding get() = _binding!!

    private val fragmentHost: NavHostFragment
        get() = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.loginToolbar)

        navController = fragmentHost.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.loginWelcomeFragment
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        setOnDestinationListenerToPersonalizedUX()

    }

    private fun setOnDestinationListenerToPersonalizedUX(){
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.loginWelcomeFragment -> {
                    binding.loginToolbar.isGone = true
                }
            }
        }
    }

}