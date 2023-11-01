package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class RowFragment : Fragment(R.layout.row_fragment) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val buttons = requireArguments().getSerializable("buttons") as List<String>
        val view = inflater.inflate(R.layout.row_fragment, container, false)
        val transaction = childFragmentManager.beginTransaction()
        buttons.forEach {
            val text = bundleOf("text" to it)
            val buttonFragment = ButtonFragment()
            buttonFragment.arguments = text
            transaction.add(R.id.row_wrapper, buttonFragment)
        }
        transaction.commit()
        return view
    }
}