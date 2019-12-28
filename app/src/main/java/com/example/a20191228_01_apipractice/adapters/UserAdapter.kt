package com.example.a20191228_01_apipractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.a20191228_01_apipractice.R
import com.example.a20191228_01_apipractice.datas.User

class UserAdapter(context: Context, resId:Int, list:ArrayList<User>) :
    ArrayAdapter<User>(context, resId, list){
    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if(tempRow == null){
            tempRow = inf.inflate(R.layout.user_list_item, null)

        }

        val row = tempRow!!

        val data = mList.get(position)



        return row
    }
}