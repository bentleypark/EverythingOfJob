package com.bentley.everythingofjob.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bentley.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject
constructor() : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}