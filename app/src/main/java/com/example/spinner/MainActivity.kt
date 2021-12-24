package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array = resources.getStringArray(R.array.spinner_array)

        val sideA = findViewById<EditText>(R.id.sideA)
        val sideB = findViewById<EditText>(R.id.sideB)
        val sideC = findViewById<EditText>(R.id.sideC)
        val solution = findViewById<TextView>(R.id.solution)
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner!=null){
            val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,array)
            spinner.adapter = adapter
        }
        val getSolution = findViewById<Button>(R.id.getSolution)
        getSolution.setOnClickListener {
            try {
                val a = sideA.text.toString().toInt()
                val b = sideB.text.toString().toInt()
                val c = sideC.text.toString().toInt()

                var result=""
                when (spinner.selectedItemId) {
                    0L ->  result = sum(a, b, c).toString()
                    1L -> result = square(a, b, c).toString()
                    2L -> result = volume(a, b, c).toString()
                }
                solution.text = result
            }
            catch (e:NumberFormatException){
                solution.text = "Ошибка ввода"
            }
        }
    }
}
fun sum(a:Int,b:Int,c:Int):Int {
    return (a+b+c)*4
}
fun square(a:Int,b:Int,c:Int):Int{
    return (a*b+a*c+b*c)*2
}
fun volume(a:Int,b:Int,c:Int):Int{
    return a*b*c
}