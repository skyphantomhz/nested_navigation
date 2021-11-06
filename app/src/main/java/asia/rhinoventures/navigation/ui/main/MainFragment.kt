package asia.rhinoventures.navigation.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.plusAssign
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import asia.rhinoventures.navigation.R
import asia.rhinoventures.navigation.util.KeepStateNavigator
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.IllegalArgumentException

class MainFragment : Fragment() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val host: NavHostFragment = childFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return

        navController = host.navController

        val navigator = KeepStateNavigator(requireContext(), childFragmentManager, R.id.nav_host_fragment)
        navController.navigatorProvider += navigator

        setupBottomNavMenu(navController)
    }

    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = requireView().findViewById<BottomNavigationView>(R.id.bnv_home)
        bottomNav!!.setupWithNavController(navController)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return try {
//            val options = NavOptions.Builder()
//                .setLaunchSingleTop(true)
//                .build()
            navController.navigate(item.itemId, null)
            true
        } catch (e: IllegalArgumentException) {
            super.onOptionsItemSelected(item)
        }
    }
}