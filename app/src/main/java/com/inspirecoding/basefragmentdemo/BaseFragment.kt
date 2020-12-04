package com.inspirecoding.basefragmentdemo

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kotlinx.coroutines.ExperimentalCoroutinesApi

abstract class BaseFragment (@LayoutRes val contentLayoutId : Int) : Fragment(contentLayoutId) {

    val TAG = this.javaClass.simpleName

    @ExperimentalCoroutinesApi
    val viewModel by viewModels<MainViewModel>()



}