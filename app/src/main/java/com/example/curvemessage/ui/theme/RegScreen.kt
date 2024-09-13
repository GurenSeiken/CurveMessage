package com.example.curvemessage.ui.theme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.curvemessage.LoginScreen
import com.example.curvemessage.R
import com.google.firebase.firestore.FirebaseFirestore

class RegScreen : AppCompatActivity() {

    private val bd = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_screen)
        val name = findViewById<EditText>(R.id.editTextName)
        val lastName = findViewById<EditText>(R.id.editTextLastName)
        val nickName = findViewById<EditText>(R.id.editTextNickName)
        val pass = findViewById<EditText>(R.id.editTextPassword)
        val butRegister = findViewById<Button>(R.id.RegisterAct)

        butRegister.setOnClickListener{
            if(name.text.toString()!="" &&
                lastName.text.toString()!="" &&
                nickName.text.toString()!="" &&
                pass.text.toString()!=""
                ){
                print("Deberia de guardarse el registro y volver a la pantalla de iniciar sesion")

                bd.collection("users").document(nickName.text.toString()).set(
                    hashMapOf("name" to name.text.toString(),
                        "lastname" to lastName.text.toString(),
                        "pass" to pass.text.toString()
                    )
                )


                val scene =Intent(this, LoginScreen::class.java)
                startActivity(scene)
            }else{
                print("los datos están incorrectos")
            }

        }


    }
}