package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_profile_activity.*

class Profile_activity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_activity)
        this.setTitle("Profile")
        loadimage()

        showdetails()

        btn_edit_profile.setOnClickListener(this)
        btn_logout.setOnClickListener(this)
        btn_update_pass.setOnClickListener(this)
        btn_profile_web.setOnClickListener(this)


    }

    private fun showdetails() {
        val sharepreferece = getSharedPreferences("userinfo",0)
        tv_name_value.setText(sharepreferece.getString("Name",""))
        tv_name_phone_value.setText(sharepreferece.getString("Phone",""))
        tv_email_value.setText(sharepreferece.getString("Email",""))
    }

    //For loding image on profile using Gridle  library

    private fun loadimage() {
        val media = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg"
        if (media !== null) {
            Glide.with(this)
                .load(media)
                .into(iv_profile)
        } else {
            iv_profile.setImageResource(R.drawable.ic_launcher_background)
        }

    }
//   Listner

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_edit_profile)
        {
            val intent = Intent(this,Register_activity::class.java)
            startActivity(intent)
        }

        if(v?.id == R.id.btn_logout)
        {
            val sharepreferece = getSharedPreferences("userinfo",0)
            val editor = sharepreferece.edit()

            editor.putString("Email","email")
            editor.putString("Password","pass")
            editor.putBoolean("Cheack",false)
            editor.apply()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        if(v?.id == R.id.btn_update_pass)
        {
            val intent = Intent(this,UpdatePassword::class.java)
            startActivity(intent)
        }

        if(v?.id == R.id.btn_profile_web)
        {
            val intent = Intent(this,Wev_view_activity::class.java)
            startActivity(intent)
        }

    }

}