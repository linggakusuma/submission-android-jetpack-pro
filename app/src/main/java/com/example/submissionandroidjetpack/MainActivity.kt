package com.example.submissionandroidjetpack

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.submissionandroidjetpack.databinding.ActivityMainBinding
import com.example.submissionandroidjetpack.utils.ext.setTransparentStatusBarBlack
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val navController by lazy {
        findNavController(R.id.nav_host_fragment).apply {
            addOnDestinationChangedListener { _, destination, _ ->
                supportActionBar?.title = destination.label
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setTransparentStatusBarBlack()
        setUpNavController()
    }

    private fun setUpNavController() {
        binding.apply {
            setSupportActionBar(toolbar)
            NavigationUI.setupWithNavController(toolbar, navController)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }
}
