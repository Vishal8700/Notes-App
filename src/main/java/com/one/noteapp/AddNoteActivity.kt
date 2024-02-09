package com.one.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.one.noteapp.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root) // Set the root view of the binding

        db = NoteDatabaseHelper(this)

        // Access the save button using the binding instance
//        binding.saveButton.setOnClickListener {
//            val title = binding.titleEditText.text.toString()
//            val content = binding.contentEditText.text.toString()
//            val note = Note(0, title, content)
//            db.insertNote(note)
//            finish()
//            Toast.makeText(this, " Note Saved Successfully ", Toast.LENGTH_SHORT).show()
//
//        }
        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                val note = Note(0, title, content)
                db.insertNote(note)
                finish()
                Toast.makeText(this, "Note Saved Successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter both title and content", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
