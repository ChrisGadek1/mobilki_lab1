package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class ButtonFragment : Fragment(R.layout.button_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textArg: String = requireArguments().getString("text", "")
        view.findViewById<Button>(R.id.calculator_button).apply {
            text = textArg
        }
    }
}