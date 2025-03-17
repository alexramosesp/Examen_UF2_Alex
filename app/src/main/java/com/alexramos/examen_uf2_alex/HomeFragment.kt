package com.alexramos.examen_uf2_alex

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.alexramos.examen_uf2_alex.databinding.FragmentHomeBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        val db = Firebase.firestore

        /*
        val assignatura = db.collection("Assignatura")

        assignatura.whereGreaterThan("Hores",50)
            .get()
         */
        /*val professor = db.collection("Professors")

        professor.whereEqualTo("Especialitat", "Matemàtiques")
            .get()
*/
        /*
        val assignaturaVariable = "Mates"
            val assignatura = db.collection("Assignatura")
                assignatura.document(assignaturaVariable).collection("Alumnes")
                .get()
         */
        /*
                db.collection("Alumne").whereGreaterThanOrEqualTo("Matriculacions", 3)
                    .get()
         */
            /*
            db.collection("Notes").whereEqualTo("ID_Alumne", 1).get()
             */

        /*
        val professor = db.collection("Professors")
        val data1 = hashMapOf(
            "Nom" to "Sergi",
            "Cognom" to "Font",
            "ID" to "4",
            "Correu" to "sergi@gmail.com",
            "Assignatura" to "",
            "Especialitat" to "AWS",
        )
        professor.document("Sergi").set(data1)
         */


/*
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }
*/

        // Inflate the layout for this fragment
        return binding.root
    }

}