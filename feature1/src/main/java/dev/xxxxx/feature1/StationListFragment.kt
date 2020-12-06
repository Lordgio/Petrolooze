package dev.xxxxx.feature1

import android.animation.Animator
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
import com.airbnb.lottie.LottieDrawable
import dagger.hilt.android.AndroidEntryPoint
import dev.xxxxx.feature1.databinding.StationsListFragmentBinding
import javax.inject.Inject

@AndroidEntryPoint
internal class StationListFragment : Fragment() {

    private lateinit var binding: StationsListFragmentBinding
    private val vm: StationListViewModel by viewModels()
    @Inject lateinit var stationAdapter: StationItemAdapter

    private val viewStateObserver = Observer<StationListViewModel.ViewState>{
        loadingAnimation(it.isLoading)
        errorAnimation(it.isError)
        binding.emptyStateGroup.isVisible = it.stationList.isEmpty()
        binding.rvStations.isVisible = it.stationList.isNotEmpty()
        stationAdapter.items = it.stationList
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

        with(binding.lottieAnimation){
            repeatCount = 1
            isVisible = true
            setAnimation(R.raw.error)
            playAnimation()
            addAnimatorListener(object : Animator.AnimatorListener{
                override fun onAnimationStart(p0: Animator?) {
                    //do nothing
                }

                override fun onAnimationEnd(p0: Animator?) {
                    cancelAnimation()
                    isVisible = false
                }

                override fun onAnimationCancel(p0: Animator?) {
                    //do nothing
                }

                override fun onAnimationRepeat(p0: Animator?) {
                    //do nothing
                }

            })
        }
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
