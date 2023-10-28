package edu.farmingdale.alrajab.bcs421.database

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import edu.farmingdale.alrajab.bcs421.databinding.ActivityDatabaseBinding
import kotlin.random.Random

class DatabaseActivity : AppCompatActivity() {

    private lateinit var binding:  ActivityDatabaseBinding

    private lateinit var dbHelper:NameRepository

    // ToDO: Database link to be completed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper= NameRepository.getInstance(this)

        binding.readData.setOnClickListener { readData() }
        binding.writeData.setOnClickListener { writeData() }


    }

    private fun writeData() {
        dbHelper.addUser(User("Course "+Random.nextInt(6000),
            "CSC "+Random.nextInt(6000)))

    }

    private fun readData() {
        val allUsers = dbHelper.getAll()
        allUsers.forEach { Log.d("Data", "${it.firstName}, ${it.lastName}") }

        val intent = Intent(this, MainActivity2::class.java)
        startActivity(
            Intent(this,MainActivity2::class.java)
        )
        //dbHelper.getAll().forEach { Log.d("Data",it.firstName+" , "+ it.lastName) }

    }

}
