package com.example.sharedpreference

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var inputText: EditText? = null
    private var sharedPreferences: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputText = findViewById<EditText>(R.id.editText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val loadButton = findViewById<Button>(R.id.loadButton)

        // Mendapatkan instance dari SharedPreferences
        sharedPreferences = getPreferences(MODE_PRIVATE)
        saveButton.setOnClickListener { v: View? -> saveData() }
        loadButton.setOnClickListener { v: View? -> loadData() }
    }

    private fun saveData() {
        // Mengambil teks dari EditText
        val data = inputText!!.text.toString()

        // Membuat editor SharedPreferences untuk menyimpan data
        val editor = sharedPreferences!!.edit()
        editor.putString("savedData", data)
        editor.apply()

        // Memberi notifikasi bahwa data telah disimpan
        Toast.makeText(this, "Data disimpan!", Toast.LENGTH_SHORT).show()
    }

    private fun loadData() {
        // Mengambil data dari SharedPreferences
        val savedData = sharedPreferences!!.getString("savedData", "")

        // Menampilkan data ke dalam EditText atau memberi notifikasi jika tidak ada data
        if (!savedData!!.isEmpty()) {
            inputText!!.setText(savedData)
            Toast.makeText(this, "Data dimuat!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Tidak ada data yang tersimpan.", Toast.LENGTH_SHORT).show()
        }
    }
}
