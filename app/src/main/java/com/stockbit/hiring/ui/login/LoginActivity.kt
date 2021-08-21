package com.stockbit.hiring.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.stockbit.hiring.MainActivity
import com.stockbit.hiring.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            if (binding.editTextEmail.text!!.isNotEmpty() && binding.editTextPassword.text!!.isNotEmpty()){
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                Snackbar.make(it,"Please fill the username and password", Snackbar.LENGTH_SHORT).show()
            }
        }

    }
}