package com.example.curvemessage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import com.example.curvemessage.ui.theme.RegScreen
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private val key = "User"
    private val bd = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)

        prefs.getString(key,"No hay usuario")

        val regActBut = findViewById<Button>(R.id.register)
        regActBut.setOnClickListener{
            val scene = Intent(this,RegScreen::class.java)
            startActivity(scene)
        }

        val logActBut = findViewById<Button>(R.id.Login)
        logActBut.setOnClickListener {
            val scene = Intent(this,LoginScreen::class.java)
            startActivity(scene)
        }
    }
}
