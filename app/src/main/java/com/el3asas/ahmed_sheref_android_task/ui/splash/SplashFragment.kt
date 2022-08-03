package com.el3asas.ahmed_sheref_android_task.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.el3asas.ahmed_sheref_android_task.R
import com.el3asas.ahmed_sheref_android_task.data.local.Pref
import com.el3asas.ahmed_sheref_android_task.databinding.FragmentSplashBinding
import com.el3asas.utils.binding.FragmentBinding
import com.el3asas.utils.utils.navigate
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment(override val bindingInflater: (LayoutInflater) -> ViewBinding = FragmentSplashBinding::inflate) :
    FragmentBinding<FragmentSplashBinding>() {

    @Inject
    lateinit var pref: Pref

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.constraintLayout2.addTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                if (currentId == R.id.end) {
                    setupView()
                }
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {
            }
        })
    }

    private fun setupView() {
        if (pref.isUserLogin) {
            navigate(
                findNavController(),
                SplashFragmentDirections.actionSplashFragmentToHomeFragment()
            )
        } else {
            navigate(
                findNavController(),
                SplashFragmentDirections.actionSplashFragmentToLoginFragment()
            )
        }

    }

}