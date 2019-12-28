package com.example.a20191228_01_apipractice.datas

import org.json.JSONObject
import java.io.Serializable

class User :Serializable{

    var id = -1  // Int임을 명시 +id가 -1이라면 파싱이 제대로 안됐다.
    var loginId = ""
    var name = ""
    var phoneNum = ""
    var memo = ""

    companion object{
//        JSONObject를 기반으로 => User변수로 변환해주는 기능

        fun getUserObjectFromJson(json:JSONObject) : User{
            val parsedUser = User()
//            기본데이터 => json변수에서 따온 값으로 대체

            parsedUser.id = json.getInt("id")
            parsedUser.loginId = json.getString("login_id")
            parsedUser.name = json.getString("name")
            parsedUser.phoneNum = json.getString("phone")
            parsedUser.memo = json.getString("memo")

            return parsedUser
        }

    }

}