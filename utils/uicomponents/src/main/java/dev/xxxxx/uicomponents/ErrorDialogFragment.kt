package dev.xxxxx.uicomponents

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.navigation.findNavController
import dev.xxxxx.uicomponents.databinding.FragmentErrorDialogBinding

class ErrorDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentErrorDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_error_dialog, container, false)
        binding = FragmentErrorDialogBinding.bind(v)
        startAnimation()
        return v
    }

    private fun startAnimation(){
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
                    findNavController().popBackStack()
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

}