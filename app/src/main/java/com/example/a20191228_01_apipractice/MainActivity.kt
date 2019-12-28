package com.example.a20191228_01_apipractice

import android.os.Bundle

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)
        setupEvents()
        setValue()
    }
    override fun setupEvents() {

    }

    override fun setValue() {

    }

}
