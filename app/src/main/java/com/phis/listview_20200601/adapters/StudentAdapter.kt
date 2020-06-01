package com.phis.listview_20200601.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.phis.listview_20200601.R
import com.phis.listview_20200601.datas.Student

class StudentAdapter(context: Context, resId: Int, list: List<Student>) :
    ArrayAdapter<Student>(context, resId, list) {

    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if ( tempRow == null){
            tempRow = inf.inflate(R.layout.student_list_view, null)
        }

        val row = tempRow!!
        return row
    }


}