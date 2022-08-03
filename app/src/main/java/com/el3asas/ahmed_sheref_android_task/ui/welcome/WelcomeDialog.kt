package com.el3asas.ahmed_sheref_android_task.ui.welcome

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.el3asas.ahmed_sheref_android_task.databinding.DialogWelcomeBinding
import com.el3asas.utils.binding.DialogFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeDialog(override val bindingInflater: (LayoutInflater) -> ViewBinding = DialogWelcomeBinding::inflate) :
    DialogFragmentBinding<DialogWelcomeBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            dismiss()
        }, 2000)
    }
}