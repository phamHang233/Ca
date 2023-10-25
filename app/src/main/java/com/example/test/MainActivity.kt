package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var input: TextView = findViewById(R.id.input)
        var output: TextView = findViewById(R.id.output)
        val btn0: Button = findViewById(R.id.btn0)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btn4: Button = findViewById(R.id.btn4)
        val btn5: Button = findViewById(R.id.btn5)
        val btn6: Button = findViewById(R.id.btn6)
        val btn7: Button = findViewById(R.id.btn7)
        val btn8: Button = findViewById(R.id.btn8)
        val btn9: Button = findViewById(R.id.btn9)
        val btnMul: Button = findViewById(R.id.btnMul)
        val btnDiv: Button = findViewById(R.id.btndiv)
        val btnAdd: Button = findViewById(R.id.btnadd)
        val btnMinus: Button = findViewById(R.id.btnminus)
        val clearbtn: Button = findViewById(R.id.CBtn)
        val equalbtn: Button = findViewById(R.id.btnequal)
        val backbtn: Button = findViewById(R.id.BSBtn)

        clearbtn.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        backbtn.setOnClickListener {
            val currentInput = input.text.toString()
            if (currentInput.isNotEmpty()) {
                input.text = currentInput.substring(0, currentInput.length - 1)
            }
        }

        btn0.setOnClickListener {
            input.text = "${input.text}0"
        }
        btn1.setOnClickListener {
            input.text = "${input.text}1"
        }
        btn2.setOnClickListener {
            input.text = "${input.text}2"
        }
        btn3.setOnClickListener {
            input.text = "${input.text}3"
        }
        btn4.setOnClickListener {
            input.text = "${input.text}4"
        }
        btn5.setOnClickListener {
            input.text = "${input.text}5"
        }
        btn6.setOnClickListener {
            input.text = "${input.text}6"
        }
        btn7.setOnClickListener {
            input.text = "${input.text}7"
        }
        btn8.setOnClickListener {
            input.text = "${input.text}8"
        }
        btn9.setOnClickListener {
            input.text = "${input.text}9"
        }
        btnMinus.setOnClickListener {
            input.text = "${input.text}-"
        }
        btnAdd.setOnClickListener {
            input.text = "${input.text}+"
        }
        btnMul.setOnClickListener {
            input.text = "${input.text}x"
        }
        btnDiv.setOnClickListener {
            input.text = "${input.text}/"
        }

        equalbtn.setOnClickListener {
            var expression = input.text.replace(Regex("x"), "*")
            val result = evaluateExpression(expression)
            output.text = result.toString()
        }
    }

    fun evaluateExpression(expression: String): Int {
        var num1 = 0
        var num2 = 0
        var operator = ' '
        var currentNumber = StringBuilder()

        for (char in expression) {
            if (char.isDigit()) {
                currentNumber.append(char)
            } else if (char in "+-*/") {
                operator = char
                num1 = currentNumber.toString().toInt()
                currentNumber.clear()
            }
        }
        num2 = currentNumber.toString().toInt()

        return when (operator) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> num1 / num2
            else -> throw IllegalArgumentException("Toán tử không hợp lệ.")
        }
    }

}