package com.phis.listview_20200601

import android.os.Bundle
import android.widget.ArrayAdapter
import com.phis.listview_20200601.adapters.StudentAdapter
import com.phis.listview_20200601.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    val students = ArrayList<Student>()
    lateinit var studentAdapter: StudentAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {

    }

    override fun setValues() {
        students.add(Student("조경진",1988,true))
        students.add(Student("김미영",2010,false))
        students.add(Student("김성우",1982,true))
        students.add(Student("김형근",1989,true))
        students.add(Student("이용희",1992,true))
        students.add(Student("이지수",1984,false))



        studentAdapter = StudentAdapter(mContext, R.layout.student_list_view, students)
        studentListView.adapter = studentAdapter




    }

}
