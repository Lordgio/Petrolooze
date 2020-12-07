package dev.xxxxx.feature1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.lottie.LottieDrawable
import dagger.hilt.android.AndroidEntryPoint
import dev.xxxxx.domainfeature1.Station
import dev.xxxxx.feature1.databinding.StationsListFragmentBinding
import dev.xxxxx.uiextensions.Event
import javax.inject.Inject

@AndroidEntryPoint
internal class StationListFragment : Fragment() {

    private lateinit var binding: StationsListFragmentBinding
    private val vm: StationListViewModel by viewModels()
    @Inject lateinit var stationAdapter: StationItemAdapter

    private val isLoadingObserver = Observer<Event<Boolean>> { event ->
        event.getContentIfNotHandled()?.let { loadingAnimation(it) }
    }

    private val isErrorObserver = Observer<Event<Boolean>> { event ->
        event.getContentIfNotHandled()?.let { errorAnimation(it) }
    }

    private val stationsObserver = Observer<List<Station>>{
        binding.emptyStateGroup.isVisible = it.isEmpty()
        binding.rvStations.isVisible = it.isNotEmpty()
        stationAdapter.items = it
    }

    private fun loadingAnimation(isLoading: Boolean) {
        with(binding){
            if(!isLoading){
                lottieAnimation.isVisible = false
                lottieAnimation.cancelAnimation()
                return
            }

            lottieAnimation.repeatCount = LottieDrawable.INFINITE
            lottieAnimation.isVisible = true
            lottieAnimation.setAnimation(R.raw.searching)
            lottieAnimation.playAnimation()
        }
    }

    private fun errorAnimation(isError: Boolean) {
        if(!isError) return
        findNavController().navigate(R.id.action_feature1Fragment_to_utils_nav_graph)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.loadData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.stations_list_fragment, container, false)

        binding = StationsListFragmentBinding.bind(v)

        stationAdapter.setOnItemClickListener {
            Toast.makeText(context, it.label, Toast.LENGTH_LONG).show()
        }

        with(binding.rvStations){
            layoutManager = LinearLayoutManager(context)
            adapter = stationAdapter
        }

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.stations.observe(viewLifecycleOwner, stationsObserver)
        vm.isLoading.observe(viewLifecycleOwner, isLoadingObserver)
        vm.isError.observe(viewLifecycleOwner, isErrorObserver)
    }

}
