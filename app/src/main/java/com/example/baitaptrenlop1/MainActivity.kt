package com.example.baitaptrenlop1

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber: EditText
    private lateinit var radioEven: RadioButton
    private lateinit var radioOdd: RadioButton
    private lateinit var radioSquare: RadioButton
    private lateinit var textViewError: TextView
    private lateinit var listViewResult: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ các view từ layout
        editTextNumber = findViewById(R.id.editTextNumber)
        radioEven = findViewById(R.id.radioEven)
        radioOdd = findViewById(R.id.radioOdd)
        radioSquare = findViewById(R.id.radioSquare)
        textViewError = findViewById(R.id.textViewError)
        listViewResult = findViewById(R.id.listViewResult)
        val buttonShow: Button = findViewById(R.id.buttonShow)

        // Xử lý sự kiện khi nhấn nút Show
        buttonShow.setOnClickListener {
            val input = editTextNumber.text.toString()  // Lưu giá trị của EditText vào biến cục bộ
            if (input.isEmpty() || input.toIntOrNull() == null || input.toInt() <= 0) {
                textViewError.text = "Vui lòng nhập một số nguyên dương lớn hơn 0"
                textViewError.visibility = View.VISIBLE
                listViewResult.adapter = null
            } else {
                textViewError.visibility = View.GONE
                val n = input.toInt()
                val resultList = ArrayList<Int>()

                when {
                    radioEven.isChecked -> {
                        for (i in 0..n step 2) {
                            resultList.add(i)
                        }
                    }
                    radioOdd.isChecked -> {
                        for (i in 1..n step 2) {
                            resultList.add(i)
                        }
                    }
                    radioSquare.isChecked -> {
                        for (i in 0..n) {
                            if (i * i <= n) resultList.add(i * i)
                            else break
                        }
                    }
                }

                // Tạo ArrayAdapter và gán vào ListView
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resultList)
                listViewResult.adapter = adapter
            }
        }
    }
}
