package com.androidlearn.digishop.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.androidlearn.digishop.R
import com.androidlearn.digishop.databinding.ActivityLoginBinding
import com.androidlearn.digishop.models.BaseModel

class LoginActivity : AppCompatActivity() , ILoginView<String> {


    lateinit var binding : ActivityLoginBinding

    lateinit var presenter : LoginPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val intractor : LoginInteractor = LoginInteractor()
        presenter = LoginPresenter(this , intractor)
        binding.button.setOnClickListener {

            presenter.loginUser(binding.edtUsername.text.toString() ,
                                binding.edtPassword.text.toString())
        }


    }

    override fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    override fun onUsernameError() {
        Toast.makeText(applicationContext , "Username Error", Toast.LENGTH_LONG).show()
    }

    override fun onPasswordError() {
        Toast.makeText(applicationContext , "Password Error", Toast.LENGTH_LONG).show()
    }

    override fun onSuccess(responseMessage: String) {
        Toast.makeText(applicationContext , "Login Successfully", Toast.LENGTH_LONG).show()
    }

    override fun onFailureError(errorResponseMessage: String) {
        Toast.makeText(applicationContext , "Error in login", Toast.LENGTH_LONG).show()
    }
}