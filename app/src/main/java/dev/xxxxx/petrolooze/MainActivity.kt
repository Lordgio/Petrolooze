package dev.xxxxx.petrolooze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import dev.xxxxx.feature1.R as Feature1R
import dev.xxxxx.petrolooze.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStartNavigation(supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
    }

    private fun setStartNavigation(host: NavHostFragment) {
        val navInflater = host.navController.navInflater
        val graph = navInflater.inflate(Feature1R.navigation.feature1_graph)
        host.navController.graph = graph
    }
}
