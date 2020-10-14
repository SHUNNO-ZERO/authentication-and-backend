package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setTitle("Login")
        val sharepreferece = getSharedPreferences("userinfo",0)
        val cheack = sharepreferece.getBoolean("Cheack",false)
        if(cheack==true)
        {
            val intent = Intent(this,Profile_activity::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener(this)
        tv_register.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_login)
        {
            //Sharepreference

            val sharepreferece = getSharedPreferences("userinfo",0)
            val save_password =(sharepreferece.getString("Password",""))
            val save_email=(sharepreferece.getString("Email",""))

            // edit text details
            val edit_email=edtext_email.text.toString()
            val edit_password =edtext_password.text.toString()

            if(save_email.equals(edit_email) && save_password.equals(edit_password)){
                val intent = Intent(this,Profile_activity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"Wrong email or password",Toast.LENGTH_LONG).show()
            }

        }

        if(v?.id==R.id.tv_register)
        {
            val intent = Intent(this, Register_activity::class.java)
            startActivity(intent)
        }
    }


}