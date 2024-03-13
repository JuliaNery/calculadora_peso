package com.example.gerenciapeso

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.ComponentActivity
import android.widget.TextView;
import android.widget.Toast

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup: RadioGroup = findViewById(R.id.rdGpGen)
        val editTextHeight = findViewById<EditText>(R.id.edTxtAlt)
        val btn = findViewById<Button>(R.id.btnSend)
        val result = findViewById<EditText>(R.id.edTxtAlt)

        btn.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            val selectedRadioButton: RadioButton = findViewById(selectedRadioButtonId)
            val heightText = editTextHeight.text.toString()
            if (selectedRadioButtonId == -1) {
                showToast("Selecione o sexo.")
                return@setOnClickListener
            }

            if (heightText.isBlank()) {
                showToast("Digite a altura.")
                return@setOnClickListener
            }

            val height = heightText.toDouble()
            val weight = if (selectedRadioButton.text == "Masculino") {
                (72.7 * height) - 58
            } else {
                (62.1 * height) - 44.7
            }

            var message = ("O peso ideal é: %.2f kg".format(weight)).toString()
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
