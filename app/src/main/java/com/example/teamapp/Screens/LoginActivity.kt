package com.example.teamapp.Screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.teamapp.R
import com.example.teamapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onFocus()
    }
    private fun onFocus(){
        binding.edtEmail.setOnFocusChangeListener {
                _, f ->
            if(!f){
                binding.ctnEmail.helperText=validedEmail()
            }
        }
    }
    private fun validedEmail():String?{
        val email=binding.edtEmail.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return "Invalid Email"
        }
        return null
    }
}