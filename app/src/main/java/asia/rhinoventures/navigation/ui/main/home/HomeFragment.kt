package asia.rhinoventures.navigation.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import asia.rhinoventures.navigation.R

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_leaderBoard).setOnClickListener {
            val appNavController = Navigation.findNavController(requireActivity(), R.id.app_host_fragment)
            appNavController.navigate(R.id.action_mainFragment_to_leaderboardFragment)
        }

        view.findViewById<Button>(R.id.btn_leaderBoardInside).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_leaderboardFragment2)
        }
    }
}