package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_wev_view_activity.*

class Wev_view_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wev_view_activity)
        this.setTitle("Web View")

        val sharepreferece = getSharedPreferences("userinfo",0)
        val save_url =(sharepreferece.getString("Weburl",""))

        var weburl ="https://"
        weburl+=save_url

        web_viewid.loadUrl(weburl)

    }
}
