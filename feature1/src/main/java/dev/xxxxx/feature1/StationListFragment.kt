package dev.xxxxx.feature1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.lottie.LottieDrawable
import dev.xxxxx.domainfeature1.Station
import dev.xxxxx.feature1.databinding.StationsListFragmentBinding
import dev.xxxxx.uiextensions.EventObserver
import dev.xxxxx.uiextensions.viewBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

internal class StationListFragment: Fragment(R.layout.stations_list_fragment) {

    private val binding by viewBinding(StationsListFragmentBinding::bind)
    private val vm: StationListViewModel by viewModel()

    private val click = object : (Station) -> Unit {
        override fun invoke(station: Station) {
            Toast.makeText(context, station.label, Toast.LENGTH_LONG).show()
        }
    }

    private val stationAdapter: StationItemAdapter by inject { parametersOf(click) }

    private val viewStateObserver = EventObserver<StationListViewState> { event ->
        when(event){
            is StationListViewState.Loading -> loadingAnimation(event.isLoading)
            is StationListViewState.Error -> errorAnimation()
        }
    }

    private val stationsObserver = Observer<List<Station>>{
        binding.emptyStateGroup.isVisible = it.isEmpty()
        binding.rvStations.isVisible = it.isNotEmpty()
        stationAdapter.submitList(it)
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

    private fun errorAnimation() {
        findNavController().navigate(R.id.action_feature1Fragment_to_utils_nav_graph)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.loadData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.rvStations){
            layoutManager = LinearLayoutManager(context)
            adapter = stationAdapter
        }

        vm.stations.observe(viewLifecycleOwner, stationsObserver)
        vm.viewState.observe(viewLifecycleOwner, viewStateObserver)
    }

}
