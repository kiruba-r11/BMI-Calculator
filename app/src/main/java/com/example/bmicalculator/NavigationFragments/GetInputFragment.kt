package com.example.bmicalculator.NavigationFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.bmicalculator.R
import kotlinx.android.synthetic.main.fragment_get_input.*

class GetInputFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_get_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var navController = findNavController()

        decreaseAgeFAB.setOnClickListener {
            decreaseAge(ageTV)
        }

        increaseAgeFAB.setOnClickListener {
            increaseAge(ageTV)
        }

        decreaseHeightFAB.setOnClickListener {
            decreaseHeight(heightTV)
        }

        increaseHeightFAB.setOnClickListener {
            increaseHeight(heightTV)
        }

        decreaseWeightFAB.setOnClickListener {
            decreaseWeight(weightTV)
        }

        increaseWeightFAB.setOnClickListener {
            increaseWeight(weightTV)
        }

        calculateBtn.setOnClickListener {

            val age = ageTV.text.toString().toInt()
            val height = heightTV.text.toString().toInt()
            val weight = weightTV.text.toString().toInt()

            val bundle = bundleOf(
                "age" to age ,
                "height" to height ,
                "weight" to weight
            )

            navController.navigate(R.id.action_getInputFragment_to_displayOutputFragment , bundle)
        }

    }

    private fun increaseWeight(weightTV: TextView) {
        val weight = weightTV.text.toString().toInt() + 1
        weightTV.text = weight.toString()
    }

    private fun decreaseWeight(weightTV: TextView) {
        val weight = weightTV.text.toString().toInt() - 1
        if(weight <= 0)
            Toast.makeText(context , "Invalid Weight", Toast.LENGTH_SHORT).show()
        else
            weightTV.text = weight.toString()
    }

    private fun increaseHeight(heightTV: TextView) {
        val height = heightTV.text.toString().toInt() + 1
        heightTV.text = height.toString()
    }

    private fun decreaseHeight(heightTV: TextView) {
        val height = heightTV.text.toString().toInt() - 1
        if(height <= 0)
            Toast.makeText(context , "Invalid Height", Toast.LENGTH_SHORT).show()
        else
            heightTV.text = height.toString()
    }

    private fun increaseAge(ageTV: TextView) {
        val age = ageTV.text.toString().toInt() + 1
        ageTV.text = age.toString()

    }

    private fun decreaseAge(ageTV: TextView) {
        val age = ageTV.text.toString().toInt() - 1
        if(age <= 0)
            Toast.makeText(context , "Invalid Age", Toast.LENGTH_SHORT).show()
        else
            ageTV.text = age.toString()
    }
}

