package com.example.a20191228_01_apipractice

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.get
import com.example.a20191228_01_apipractice.adapters.UserAdapter
import com.example.a20191228_01_apipractice.datas.User
import com.example.a20191228_01_apipractice.utils.ConnectServer
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : BaseActivity() {

    val userList = ArrayList<User>()
    var mUserAdapter:UserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValue()
    }
    override fun setupEvents() {
        userListView.setOnItemClickListener { parent, view, position, id ->

            val clickedUser = userList.get(position)

            val intent = Intent(mContext, UserInfoActivity::class.java)
            intent.putExtra("user", clickedUser)
            startActivity(intent)
        }
    }

    override fun setValue() {
        mUserAdapter = UserAdapter(mContext, R.layout.user_list_item, userList)
        userListView.adapter = mUserAdapter
    }

    override fun onResume() {
        super.onResume()

        ConnectServer.getRequestUserList(mContext, object :ConnectServer.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                val code = json.getInt("code")

                runOnUiThread {
                    if(code == 200){

                        userList.clear()

                        val data = json.getJSONObject("data")
                        val users = data.getJSONArray("users")

                        for (i in 0..(users.length() - 1) ){
                            val userJson = users.getJSONObject( i )

                            val userDataObject = User.getUserObjectFromJson(userJson)
                            userList.add(userDataObject)



                        }
                        mUserAdapter?.notifyDataSetChanged()
                    }
                    else{
                        Toast.makeText(mContext,"서버에 문제가 있습니다",Toast.LENGTH_SHORT).show()

                    }
                }

            }
        })

    }

}
