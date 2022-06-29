package com.zoltanlorinczi.project_retrofit.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.zoltanlorinczi.project_retorfit.R
import com.zoltanlorinczi.project_retrofit.api.MarketPlaceRepository
import com.zoltanlorinczi.project_retrofit.viewmodel.LoginViewModel
import com.zoltanlorinczi.project_retrofit.viewmodel.LoginViewModelFactory

/**
 * Author:  Zoltan Lorinczi
 * Date:    11/12/2021
 */
class LoginFragment : Fragment() {

    companion object {
        private val TAG: String? = LoginFragment::class.java.canonicalName
    }

    private var loginViewModel: LoginViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = LoginViewModelFactory(MarketPlaceRepository())
        loginViewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_login, container, false).apply {
            initViews(this)
        }

    private fun initViews(view: View) {
        val userNameEditText: EditText = view.findViewById(R.id.edittext_name_login_fragment)
        val passwordEditText: EditText = view.findViewById(R.id.edittext_password_login_fragment)
        val button: Button = view.findViewById(R.id.button_login_fragment)

        button.setOnClickListener {
            val userName = userNameEditText.text.toString()
            val password = passwordEditText.text.toString()

            loginViewModel?.login(userName, password)

            loginViewModel?.isSuccessful?.observe(this.viewLifecycleOwner) {
                Log.d(TAG, "Logged in successfully = $it")
                if (it) {
                    findNavController().navigate(R.id.action_loginFragment_to_listFragment)
                }
            }
        }
    }
}