package com.alexramos.examen_uf2_alex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.alexramos.examen_uf2_alex.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginButton.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val pass = binding.passwordInput.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener{
                    if (it.isSuccessful){
                        Toast.makeText(requireContext(), "Log in successfully!", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.homeFragment)
                    }else {
                        Toast.makeText(requireContext(), it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else{
                Toast.makeText(requireContext(), "Required files are incomplete!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }

        return binding.root
    }


}