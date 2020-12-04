package com.inspirecoding.basefragmentdemo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.inspirecoding.basefragmentdemo.databinding.FragmentFirstBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class FirstFragment : BaseFragment (R.layout.fragment_first) {

    private val binding by viewBinding (FragmentFirstBinding::bind)

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvFirst.setOnClickListener {
            viewModel.navigateTo(NavigationState.SECOND)
        }

        lifecycleScope.launch {
            viewModel.navigateState.collect {
                if (it == NavigationState.SECOND) findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                Log.d("$TAG**__**", TAG)
            }
        }
    }

}