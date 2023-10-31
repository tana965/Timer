package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentSecond:Int = 0
    var threadId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (findViewById<TextView>(R.id.textView2)).text = currentSecond.toString()
    }

     fun click(view: View){
         val button:Button = findViewById(R.id.button)
         val textView:TextView = findViewById(R.id.textView2)
         val editText:EditText = findViewById(R.id.editTextText)


         val run = Runnable{

             val eText=editText.text.toString()
             for(i in eText.toInt() downTo 0){
        (textView.post(Runnable{
            textView.text = i.toString()

        }))
                 Thread.sleep(1000)
                 if(i ==0){button.post{
                     button.isEnabled = true

                 }

                 }

        }
        }
        val thread:Thread = Thread(run)
         threadId = thread.id

         if (threadId != 0.toLong()){
             thread.start()
             button.isEnabled = false
         }

     }


}







