package com.example.bmicalculator.NavigationFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.bmicalculator.R
import kotlinx.android.synthetic.main.fragment_display_output.*

class DisplayOutputFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_output, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val age = arguments?.getInt("age")?.toInt()
        val height = arguments?.getInt("height")?.toInt()
        val weight = arguments?.getInt("weight")?.toInt()
        val heightInMeters = height?.toDouble()?.div(100)

        val BMI = weight!!.toDouble() / (heightInMeters!! * heightInMeters!!)

        if(BMI < 18.5) {
            underWeightPointer.visibility = ImageView.VISIBLE
        } else if(BMI >= 18.5 && BMI <= 24.9) {
            normalPointer.visibility = ImageView.VISIBLE
        } else if(BMI >= 25 && BMI <= 30) {
            overWeightPointer.visibility = ImageView.VISIBLE
        } else {
            obesePointer .visibility = ImageView.VISIBLE
        }

        setValues(age!!, height, weight)
    }

    private fun setValues(age: Int, height: Int, weight: Int) {
        setAgeTV.text = age.toString()
        setHeightTV.text = height.toString()
        setWeightTV.text = weight.toString()
    }
}