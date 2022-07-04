package com.zoltanlorinczi.project_retrofit.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zoltanlorinczi.project_retorfit.R
import com.zoltanlorinczi.project_retorfit.databinding.FragmentLoginBinding

/**
 * Author:  Zoltan Lorinczi
 * Date:    11/12/2021
 */
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        FragmentLoginBinding.inflate(inflater).apply {
            binding = this
            initViews()
        }.root

    private fun initViews() {
        val openListButton: Button = binding.buttonOpenList
        val openActivityButton: Button = binding.buttonOpenSecondActivity

        openListButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_listFragment)
        }

        openActivityButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_second_activity)
        }
    }
}