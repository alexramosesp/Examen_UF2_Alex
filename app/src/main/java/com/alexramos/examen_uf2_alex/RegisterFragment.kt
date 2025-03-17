package com.alexramos.examen_uf2_alex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.alexramos.examen_uf2_alex.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import android.widget.SimpleAdapter


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        firebaseAuth = FirebaseAuth.getInstance()


        binding.loginButton.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val pass = binding.passwordInput.text.toString()
            val spinner = binding.spinner
// Create an ArrayAdapter using the string array and a default spinner layout.
            context?.let { it1 ->
                ArrayAdapter.createFromResource(
                    it1,
                    R.array.rol,
                    android.R.layout.simple_spinner_item
                ).also { adapter ->
                    // Specify the layout to use when the list of choices appears.
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    // Apply the adapter to the spinner.
                    spinner.adapter = adapter
                }
            }

            if (email.isNotEmpty() && pass.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener{
                    if (it.isSuccessful){
                        Toast.makeText(requireContext(), "User created successfully!", Toast.LENGTH_SHORT).show()
                        spinner.onItemSelectedListener
                        findNavController().navigate(R.id.loginFragment)
                    }else {
                        Toast.makeText(requireContext(), it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else{
                Toast.makeText(requireContext(), "Required files are incomplete!", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

}