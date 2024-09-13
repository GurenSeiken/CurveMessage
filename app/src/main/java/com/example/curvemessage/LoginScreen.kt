package com.example.curvemessage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import com.example.curvemessage.ui.theme.ChatScreen
import com.google.firebase.firestore.FirebaseFirestore

class LoginScreen : AppCompatActivity() {
    private val userKey = "User"
    private val bd = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        val logBut = findViewById<Button>(R.id.LoginApp)
        val user =findViewById<EditText>(R.id.editTextUserLogin)
        val pass = findViewById<EditText>(R.id.editTextPasswordLogin)
        var passTemp=""

        logBut.setOnClickListener {
            if(user.text.toString()!="" &&
               pass.text.toString()!=""){
                bd.collection("users").document(user.text.toString()).get().addOnSuccessListener{
                    passTemp=it.get("pass") as String
                }
                if(passTemp==pass.text.toString()){
                    val editor = prefs.edit()
                    editor.putString(userKey,user.text.toString())
                    editor.apply()
                    val scene = Intent(this,ChatScreen::class.java)
                    startActivity(scene)
                }else{
                    print("yorindel")
                }

            }
        }
    }


}