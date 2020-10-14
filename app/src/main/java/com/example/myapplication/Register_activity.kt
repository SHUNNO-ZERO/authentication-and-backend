package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register_activity.*

class Register_activity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_activity)
        this.setTitle("Register")

        btn_register.setOnClickListener(this)


        //made a back arrow sign
        supportActionBar?.setHomeButtonEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);


    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_register) {

            val name = edit_name.text.toString()
            val phone = edit_phone.text.toString()
            val email = edit_email.text.toString()
            val userid = edit_userid.text.toString()
            val password = edit_password.text.toString()
            val repassword = edit_repassword.text.toString()
            val weburl = edit_webaddress.text.toString()

            val sharepreferece = getSharedPreferences("userinfo", 0)
            val editor = sharepreferece.edit()

            editor.putString("Name", name)
            editor.putString("Phone", phone)
            editor.putString("Email", email)
            editor.putString("Userid", userid)
            editor.putString("Password", password)
            editor.putString("Weburl", weburl)
            editor.putBoolean("Cheack", true)

            editor.apply()

            Toast.makeText(applicationContext, "Data Register", Toast.LENGTH_LONG).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }



    //back button..........................
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==android.R.id.home){

            this.finish()



        }


        return super.onOptionsItemSelected(item)
    }







}















