package edu.farmingdale.alrajab.bcs421.database

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import edu.farmingdale.alrajab.bcs421.databinding.ActivitySharedPrefBinding

class SharedPref : AppCompatActivity() {

    private lateinit var binding: ActivitySharedPrefBinding
    private  val sharedPref ="Name"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPrefBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences(sharedPref, Context.MODE_PRIVATE)

        binding.saveButton.setOnClickListener {saveToSharePref(sharedPref) }
        binding.readButton.setOnClickListener {readFromSharePref(sharedPref) }
        binding.updateButton.setOnClickListener {updateSharePref(sharedPref)}
    }


    private fun saveToSharePref(sharedPref: SharedPreferences) {
        val firstName = binding.firstName.text.toString()
        val lastName = binding.lastName.text.toString()
        val editor = sharedPref.edit()
        editor.putString("firstName", firstName)
        editor.putString("lastName", lastName)
        editor.apply()
        toast("Name Saved!")
    }

    private fun readFromSharePref(sharedPref: SharedPreferences) {
        val firstName = sharedPref.getString("firstName", "Default First Name")
        val lastName = sharedPref.getString("lastName", "Default Last Name")
        binding.firstName.setText(firstName)
        binding.lastName.setText(lastName)

    }

    private fun updateSharePref(sharedPref: SharedPreferences) {
        val editor = sharedPref.edit()
        // You can modify this part to update specific fields only if needed
        editor.putString("firstName", binding.firstName.text.toString())
        editor.putString("lastName", binding.lastName.text.toString())
        editor.apply()
        toast("Update Successful!")
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

