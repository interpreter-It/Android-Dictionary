package com.example.dictionary

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedWriter
import java.io.FileNotFoundException
import java.io.IOException
import java.io.OutputStreamWriter


class MyDictionary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_dictionary)
    }

    fun newWorld(view: View) {
        val textView = findViewById<TextView>(R.id.editTextTextMultiLine)
        val textEn = textView.text.toString()
        val textView1 = findViewById<TextView>(R.id.editTextTextMultiLine2)
        val textRu = textView1.text.toString()
        if (textEn.isNotEmpty() && textRu.isNotEmpty()){
            try {
                // отрываем поток для записи
                val bw = BufferedWriter(
                    OutputStreamWriter(
                        openFileOutput("Dictionary.txt", MODE_APPEND)
                    )
                )
                // пишем данные
                bw.append("$textEn - $textRu\n")
                // закрываем поток
                bw.close()
                Toast.makeText(this, "Слово записано", LENGTH_SHORT).show()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}