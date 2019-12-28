package com.example.a20191228_01_apipractice

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a20191228_01_apipractice.datas.User
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        setupEvents()
        setValue()
    }
    override fun setupEvents() {

    }

    override fun setValue() {
        val sendUser = intent.getSerializableExtra("user") as User

        userIdTxt.text = sendUser.loginId
        userNameTxt.text = sendUser.name
        userPhoneNumTxt.text = sendUser.phoneNum
        userMemoTxt.text = sendUser.memo


    }

}
