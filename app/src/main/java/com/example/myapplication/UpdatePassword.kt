package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_update_password.*

class UpdatePassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_password)
        this.setTitle("Update Password")

        btn_saveid.setOnClickListener(View.OnClickListener {
            val oldpass =edtext_oldpassword.text.toString()
            val newpass =edtext_newpassword.text.toString()

            val sharepreferece = getSharedPreferences("userinfo",0)
            val save_password =(sharepreferece.getString("Password",""))

            if(oldpass.equals(save_password)){
                val sharepreferece = getSharedPreferences("userinfo",0)
                val editor = sharepreferece.edit()
                editor.putString("Password",newpass)
                editor.apply()
                Toast.makeText(applicationContext,"Password Save Successfully.",Toast.LENGTH_LONG).show()

                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(applicationContext,"Paword Incorrect",Toast.LENGTH_LONG).show()
            }

        })
    }
}