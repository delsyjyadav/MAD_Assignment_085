package com.example.mad_assignment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddNoteActivity : AppCompatActivity() {

    private lateinit var noteTitle: EditText
    private lateinit var noteContent: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        // Initialize views
        noteTitle = findViewById(R.id.et_note_title)
        noteContent = findViewById(R.id.et_note_content)
        saveButton = findViewById(R.id.btn_save_note)

        // Set save button click listener
        saveButton.setOnClickListener {
            saveNote()
        }
    }

    private fun saveNote() {
        val title = noteTitle.text.toString()
        val content = noteContent.text.toString()

        if (title.isNotEmpty() && content.isNotEmpty()) {
            // Save note logic (implement Room DB save logic here)
            Toast.makeText(this, "Note saved!", Toast.LENGTH_SHORT).show()
            finish()  // Close activity after saving
        } else {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }
}
