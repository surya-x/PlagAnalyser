package com.example.plaganalyser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: WordViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(WordViewModel::class.java)
//        viewModel = ViewModelProvider(
//            this,
//            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
//        ).get(WordViewModel::class.java)
    }

    fun submitButtonClick(view: View){
        val text1 = findViewById<EditText>(R.id.editText1).text.toString()
        val text2 = findViewById<EditText>(R.id.editText2).text.toString()

        if( text1.isEmpty() || text2.isEmpty()){
            // The case when any or both of the texts are empty
            Toast.makeText(this, "Text can't be blank!!", Toast.LENGTH_SHORT).show()
        }
        else{
            // The case when both the texts aren't empty

        }
    }
}