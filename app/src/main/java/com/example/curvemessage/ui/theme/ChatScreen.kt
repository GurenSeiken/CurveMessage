package com.example.curvemessage.ui.theme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.curvemessage.R
import com.example.curvemessage.SetEncriptation
import com.google.firebase.firestore.FirebaseFirestore

class ChatScreen : AppCompatActivity() {

    private val bd = FirebaseFirestore.getInstance()
    private val userKey = "User"
    private val usr="US1"
    private val keypub = "keyPublic"
    private val mpty=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_chat_screen)

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)

        val t1=findViewById<TextView>(R.id.textView2)
        val t2=findViewById<TextView>(R.id.textView4)
        val t3=findViewById<TextView>(R.id.textView5)
        val t4=findViewById<TextView>(R.id.textView6)
        val t5=findViewById<TextView>(R.id.textView7)
        val t6=findViewById<TextView>(R.id.textView8)

        var name=""
        var conttt=""
        var usserr=""
        var conttt2=""
        var name2=""
        var conttt3=""
        var name3=""
        var conttt4=""
        var name4=""
        var conttt5=""
        var name5=""
        var conttt6=""
        var name6=""
        var kei=""

        kei=prefs.getString(keypub,"nohayclave").toString()

        usserr= prefs.getString(userKey,"nohayusuario").toString()

        val upBut=findViewById<ImageButton>(R.id.Update)
        upBut.setOnClickListener{

            bd.collection("messages").document("isepulveda").get().addOnSuccessListener{
                name= it.get("usurious") as String
                conttt= it.get("content") as String
            }
            if(kei=="b99c3179d9a9ead03dce62cafffdad290f6023b8823c4af94b00f162d445cd98" || kei=="03ec37d4d904dff3db043150ec4171d95731e3fb6cf4cdd60e69f996a7c17cf01b"){
                t1.setText(name+"\n"+conttt)
            }else{
                t1.setText(name+"\n"+"No se pudo desencriptar el mensaje")
            }

            bd.collection("messages").document("jgtovar").get().addOnSuccessListener{
                name2= it.get("usurious") as String
                conttt2= it.get("content") as String
            }

            if(kei=="3bf5a8ef8ea9399c146d4fd85fac56580a2588c90eac21505980f6ee405eb99b" || kei=="02cdf2b28ab5c9239e4dabdca3488af4cbd0a85fe263e7ce56d289f0f54a5de805"||kei=="03ec37d4d904dff3db043150ec4171d95731e3fb6cf4cdd60e69f996a7c17cf01b"){
                t2.setText(name2+"\n"+conttt2)
            }else{
                t2.setText(name2+"\n"+"No se pudo desencriptar el mensaje")
            }

            bd.collection("messages").document("GurenSeiken").get().addOnSuccessListener{
                name3= it.get("usurious") as String
                conttt3= it.get("content") as String
            }
            if(kei=="03d41dd09356bb745f1d53b17fdc53e476aa95fc7b232bc83ee97028ee94d96b69"){
                t3.setText(name3+"\n"+conttt3)
            }else{
                t3.setText(name3+"\n"+"No se pudo desencriptar el mensaje")
            }


            bd.collection("messages").document("Kuroko").get().addOnSuccessListener{
                name4= it.get("usurious") as String
                conttt4= it.get("content") as String
            }

            if(kei=="8fa3101c3633fa942f98cabc4f995d42142a73bbe3f15c29d3073011227404c5"||kei=="02cdf2b28ab5c9239e4dabdca3488af4cbd0a85fe263e7ce56d289f0f54a5de805"){
                t4.setText(name4+"\n"+conttt4)
            }else{
                t4.setText(name4+"\n"+"No se pudo desencriptar el mensaje")
            }

            bd.collection("messages").document("LordPetroski").get().addOnSuccessListener{
                name5= it.get("usurious") as String
                conttt5= it.get("content") as String
            }
            if(kei=="03d41dd09356bb745f1d53b17fdc53e476aa95fc7b232bc83ee97028ee94d96b69"||kei=="b99c3179d9a9ead03dce62cafffdad290f6023b8823c4af94b00f162d445cd98"||kei=="8fa3101c3633fa942f98cabc4f995d42142a73bbe3f15c29d3073011227404c5"){
                t5.setText(name5+"\n"+conttt5)
            }else{
                t5.setText(name5+"\n"+"No se pudo desencriptar el mensaje")
            }
            bd.collection("messages").document("SuperBigote").get().addOnSuccessListener{
                name6= it.get("usurious") as String
                conttt6= it.get("content") as String
            }
            if(kei=="8fa3101c3633fa942f98cabc4f995d42142a73bbe3f15c29d3073011227404c5"){
                t6.setText(name6+"\n"+conttt6)
            }else{
                t6.setText(name6+"\n"+"No se pudo desencriptar el mensaje")
            }
        }

        val setBut = findViewById<ImageButton>(R.id.SettingsBut)

        setBut.setOnClickListener {
            val scene = Intent(this,SetEncriptation::class.java)
            startActivity(scene)
        }

        val cont=findViewById<EditText>(R.id.editTextMess)
        val sendBut=findViewById<ImageButton>(R.id.sendBut)
        sendBut.setOnClickListener{

            bd.collection("messages").document(usserr).set(
                hashMapOf(
                    "usurious" to usserr,
                    "content" to cont.text.toString()
                )
            )
            cont.setText(mpty)
        }
    }
}