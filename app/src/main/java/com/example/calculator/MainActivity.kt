package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val buttons = bundleOf("buttons" to
                    listOf(
                        listOf("1", "2", "3", "/"),
                        listOf("4", "5", "6", "-"),
                        listOf("7", "8", "9", "*"),
                        listOf("C", "0", ".", "=")
                    )
            )
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<KeyboardFragment>(R.id.calculator_fragment_container, args = buttons)
            }
        }
    }
}