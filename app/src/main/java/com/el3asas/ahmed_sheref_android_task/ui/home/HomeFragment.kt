package com.el3asas.ahmed_sheref_android_task.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.el3asas.ahmed_sheref_android_task.R
import com.el3asas.ahmed_sheref_android_task.databinding.FragmentHomeBinding
import com.el3asas.utils.binding.FragmentBinding
import com.el3asas.utils.utils.customSnackBar
import com.el3asas.utils.utils.navigate
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment(override val bindingInflater: (LayoutInflater) -> ViewBinding = FragmentHomeBinding::inflate) :
    FragmentBinding<FragmentHomeBinding>() {

    private val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = this@HomeFragment.viewModel
            lifecycleOwner = this@HomeFragment
            executePendingBindings()
        }

        binding.toolBar.inflateMenu(R.menu.too_bar_menu)
        binding.toolBar.setOnMenuItemClickListener {
            Timber.d("---------------------- ${it.itemId}")
            if (it.itemId == R.id.logout) {
                Timber.d("---------------------- ${it.itemId}")
                viewModel.logout(requireView())
            }
            return@setOnMenuItemClickListener false
        }

        lifecycleScope.launchWhenResumed {
            viewModel.isError.collect {
                it?.let { it1 ->
                    customSnackBar(
                        requireView(),
                        it1,
                        com.el3asas.utils.R.drawable.ic_outline_error_outline_24
                    ) {}
                }
            }
        }

        openWelcomeDialog()
    }


    private fun openWelcomeDialog() {
        if (viewModel.welcomeScreenShowed.not()) {
            viewModel.welcomeScreenShowed = true
            val dir = HomeFragmentDirections.actionHomeFragmentToWelcomeFragment()
            navigate(findNavController(), dir)
        }
    }

}