package com.el3asas.ahmed_sheref_android_task.ui.home

import android.view.View
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.el3asas.ahmed_sheref_android_task.models.ProductsItem
import com.el3asas.ahmed_sheref_android_task.ui.MainActivity
import com.el3asas.utils.base.BaseViewModel
import com.el3asas.utils.utils.getData
import com.el3asas.utils.utils.loadActivity
import com.el3asas.utils.utils.navigate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : BaseViewModel(), ProductsAdapter.ProductItemCLickListener {
    val userName = repository.userName

    val recyclerViewAdapter = ProductsAdapter(this)
    private val _isError: MutableStateFlow<String?> = MutableStateFlow(null)
    val isError: StateFlow<String?> = _isError

    var welcomeScreenShowed = false

    init {
        getData()
    }

    val getWelcomeText: String
        get() {
            val calendar = Calendar.getInstance()
            return when (calendar.get(Calendar.HOUR_OF_DAY)) {
                in 5..12 -> "Good morning "
                in 12..18 -> "Good afternoon "
                else -> "Good evening "
            }
        }

    private fun getData() {
        viewModelScope.launch {
            getData(
                repository.getProductsData(),
                onSuccess = { response ->
                    response?.products?.filterNotNull()?.let {
                        recyclerViewAdapter.setData(it)
                    }
                },
                onError = {
                    _isError.value = it
                },
                isLoading
            )
        }
    }

    override fun onProductItemClickListener(v: View, position: Int, item: ProductsItem) {
        val dir = HomeFragmentDirections.actionHomeFragmentToDetailsBottomSheet(
            recyclerViewAdapter.getItem(position)
        )
        navigate(v.findNavController(), dir)
    }

    fun logout(v: View) {
        repository.logout {
            loadActivity(v.context, MainActivity::class.java)
        }
    }

}
