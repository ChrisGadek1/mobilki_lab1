package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class KeyboardFragment : Fragment(R.layout.keyboard_fragment){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val buttons = requireArguments().getSerializable("buttons") as List<List<String>>
        val view = inflater.inflate(R.layout.keyboard_fragment, container, false)
        val transaction = childFragmentManager.beginTransaction()
        buttons.forEach {
            val buttons = bundleOf("buttons" to it)
            val rowFragment = RowFragment()
            rowFragment.arguments = buttons
            transaction.add(R.id.keyboard_wrapper, rowFragment)
        }
        transaction.commit()
        return view
    }
}