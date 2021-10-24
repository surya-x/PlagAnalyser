package com.example.plaganalyser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.InternalCoroutinesApi

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(WordViewModel::class.java)

//        findViewById<Button>(R.id.button).setOnClickListener { onSubmitButtonClick() }
    }

    fun onSubmitButtonClick(view: View){
        val text1 = findViewById<EditText>(R.id.editText1).text.toString()
        val text2 = findViewById<EditText>(R.id.editText2).text.toString()

        if( text1.isEmpty() || text2.isEmpty()){
            // The case when any or both of the texts are empty
            Toast.makeText(this, "Text can't be blank!!", Toast.LENGTH_SHORT).show()
        }
        else{
            viewModel.onSubmit(text1, text2)

        }
    }
}
/*
* 1. Making it only alphanumeric in CalculatePlagiarism class
* */