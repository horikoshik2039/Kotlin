package com.example.kotlinpractice01

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EventListenerPracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_listner_practice)

        val btClick = findViewById<Button>(R.id.btClick)
        val btClear = findViewById<Button>(R.id.btClear)
        btClick.setOnClickListener(HelloListener())
        btClear.setOnClickListener(HelloListener())
    }
    private inner class HelloListener : View.OnClickListener{
        @SuppressLint("SetTextI18n")
        override fun onClick(view: View?) {
            val input = findViewById<EditText>(R.id.etName)
            val output = findViewById<TextView>(R.id.tvOutput)

            //変数idがnullでなければそのまま処理をし、nullであれば処理をせずnullを返す(nullPoは発生しない)
            when(view?.id){
                R.id.btClick -> {
                    output.text = (input.text.toString() + "さん、 こんにちは！")
                }
                R.id.btClear -> {
                    input.setText("")
                    output.text = ""
                }
            }
        }
    }
}