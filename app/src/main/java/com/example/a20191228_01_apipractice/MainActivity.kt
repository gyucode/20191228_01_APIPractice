package com.example.a20191228_01_apipractice

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a20191228_01_apipractice.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValue()
    }

    override fun setupEvents() {
//        로그아웃 버튼이 눌리면
//        로그아웃 확인(제목)/ 정말 로그아웃 하시겠습니까?(내용)
//        확인 =>토스트로 로그아웃/ 취소 버튼보유=>아무일도X
//        사용자 의사 확인
        
        logoutBtn.setOnClickListener {
            val alert = AlertDialog.Builder(mContext)
            alert.setTitle("로그아웃 확인")
            alert.setMessage("정말 로그아웃 하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(mContext,"로그아웃",Toast.LENGTH_SHORT).show()

                ContextUtil.setUserToken(mContext, "")

                val intent = Intent(mContext, LoginActivity::class.java)
                startActivity(intent)

                finish()

            })
            alert.setNegativeButton("취소",null)//취소는 눌러도 아무일 없도록
            alert.show()

        }

    }

    override fun setValue() {

    }

}
