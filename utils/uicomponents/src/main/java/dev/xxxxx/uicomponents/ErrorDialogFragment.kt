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
import dev.xxxxx.uiextensions.viewBinding

class ErrorDialogFragment : DialogFragment(R.layout.fragment_error_dialog) {

    private val binding by viewBinding(FragmentErrorDialogBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startAnimation()
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