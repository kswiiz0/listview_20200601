package com.phis.listview_20200601.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.phis.listview_20200601.R
import com.phis.listview_20200601.datas.Student
import java.util.*

class StudentAdapter(context: Context, resId: Int, list: List<Student>) :
    ArrayAdapter<Student>(context, resId, list) {

    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        /*안드로이드는 데이터사이즈만큼 모든 뷰를 그리지 않는다.
         * 화면에 다 찰정도까지만 객체(뷰)를 생성하고, 스크롤이 발생할때
         * 화면에서 빠지는 뷰를 가져와서 재사용한다.
         * 그렇기 때문에 아래 if문 소스가 추가되는것이다.
         * 최초에는 데이터를 채울만큼의 뷰를 생성한다.
         */

        if ( tempRow == null){
            tempRow = inf.inflate(R.layout.student_list_view, null)
        }
        val row = tempRow!!

        val nameAndAgeTxt = row.findViewById<TextView>(R.id.nameAndAgeTxt)
        val genderTxt = row.findViewById<TextView>(R.id.genderTxt)

        val data = mList.get(position)

        if ( data.isMale ){
            genderTxt.text = "남성"
        }else{
            genderTxt.text = "여성"
        }

//        val thisYear = 2020
//        val birthYear = data.birthYear
//        nameAndAgeTxt.text = "${data.name}(${thisYear-birthYear+1}세)"


        val cal = Calendar.getInstance()
        val thisYear = cal.get(Calendar.YEAR).toInt()

        nameAndAgeTxt.text = "${data.name}(${data.getKoreanAge(thisYear)}세)"

        return row
    }


}