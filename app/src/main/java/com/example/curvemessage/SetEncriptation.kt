package com.example.curvemessage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.curvemessage.ui.theme.ChatScreen

class SetEncriptation : AppCompatActivity() {
    private val keypub = "keyPublic"
    private val keypriv = "keyPrivate"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_encriptation)

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val clvView= findViewById<TextView>(R.id.textViewClave)
        clvView.setText(prefs.getString(keypub,"nohayclaveguardada"))
        val savebut = findViewById<Button>(R.id.SaveButton)
        val key = findViewById<EditText>(R.id.editTextKey)

        savebut.setOnClickListener {
            if(key.text.toString()!=""){

                val editor = prefs.edit()
                editor.putString(keypub,key.text.toString())
                editor.putString(keypriv,"Cadena de prueba2")
                editor.apply()
                val scene = Intent(this,ChatScreen::class.java)
                startActivity(scene)
                print("Clave Guardada")
            }else{
                print("Debe llenar la clave")
            }
        }

        val closebut =findViewById<Button>(R.id.logoutButton)

        closebut.setOnClickListener {

        }

    }
}