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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import dev.xxxxx.domainfeature1.Station
import dev.xxxxx.feature1.databinding.StationsListFragmentBinding
import javax.inject.Inject

@AndroidEntryPoint
internal class StationListFragment : Fragment() {

    private lateinit var binding: StationsListFragmentBinding
    private val vm: StationListViewModel by viewModels()
    @Inject lateinit var stationAdapter: StationItemAdapter

    private val viewStateObserver = Observer<StationListViewModel.ViewState>{
        binding.progressBar.isVisible = it.isLoading
        stationAdapter.items = it.stationList
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
        vm.viewState.observe(viewLifecycleOwner, viewStateObserver)
        vm.loadData()
    }

}
