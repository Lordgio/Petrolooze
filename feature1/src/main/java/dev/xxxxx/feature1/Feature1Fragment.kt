package dev.xxxxx.feature1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.xxxxx.feature1.databinding.StationsListFragmentBinding

class Feature1Fragment : Fragment() {

    private lateinit var binding: StationsListFragmentBinding
    private lateinit var rvStations: RecyclerView
    private val stations = listOf(
        Station("1","Repsol","CR CM-219, 4,9", "Mondéjar","Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("2","Repsol","CR CM-219, 4,9", "Mondéjar","Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("3","Repsol","CR CM-219, 4,9", "Mondéjar","Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("4","Repsol","CR CM-219, 4,9", "Mondéjar","Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("5","Repsol","CR CM-219, 4,9", "Mondéjar","Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("6","Repsol","CR CM-219, 4,9", "Mondéjar","Guadalajara", "1,209", "1,309", "1,089", "1,139"),
        Station("7","Repsol","CR CM-219, 4,9", "Mondéjar","Guadalajara", "1,209", "1,309", "1,089", "1,139")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.stations_list_fragment, container, false)
        binding = StationsListFragmentBinding.bind(v)
        rvStations = binding.rvStations
        rvStations.layoutManager = LinearLayoutManager(context)
        rvStations.adapter = StationItemAdapter(stations){
            Toast.makeText(context, it.label, Toast.LENGTH_LONG).show()
        }
        return v
    }

}
