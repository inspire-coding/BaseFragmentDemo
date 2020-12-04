package com.inspirecoding.basefragmentdemo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.inspirecoding.basefragmentdemo.databinding.FragmentSecondBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class SecondFragment : BaseFragment(R.layout.fragment_second) {

    private val binding by viewBinding (FragmentSecondBinding::bind)

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSecond.setOnClickListener {
            viewModel.navigateTo(NavigationState.FIRST)
        }

        lifecycleScope.launch {
            viewModel.navigateState.collect {
                if (it == NavigationState.FIRST) findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
                Log.d("$TAG**__**", TAG)
            }
        }
    }

}