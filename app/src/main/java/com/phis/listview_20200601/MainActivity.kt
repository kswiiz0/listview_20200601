package com.phis.listview_20200601

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

        listViewStudents.setOnItemClickListener { parent, view, position, id ->
            //아래와 동일한 코드 val clickedStudent = students[position]
            val clickedStudent = students.get(position)
            Toast.makeText(mContext, clickedStudent.name, Toast.LENGTH_SHORT).show()


        }

        /*Return을 true로 하면 LongClick 전용으로 사용되고,
         *        false로 할 경우 일반 Click로 같이 실행된다.
        */
        listViewStudents.setOnItemLongClickListener { parent, view, position, id ->
//            val clickedStudent = students[position]
//            Toast.makeText(mContext, "${clickedStudent.name}를 삭제", Toast.LENGTH_SHORT).show()

            val alert = AlertDialog.Builder(mContext)
            alert.setTitle("삭제 확인")
            alert.setMessage("정말 이 학생을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                //아이테 삭제
                students.removeAt(position)
                //리스트뷰(어뎁터)에게 데이터셋의 변경상태를 전달한다.
                studentAdapter.notifyDataSetChanged()
            })

            alert.setNegativeButton("취소", null)
            alert.show()

            return@setOnItemLongClickListener true
        }



    }

    override fun setValues() {
        students.add(Student("조경진", 1988, true))
        students.add(Student("김미영", 2010, false))
        students.add(Student("김성우", 1982, true))
        students.add(Student("김형근", 1989, true))
        students.add(Student("이용희", 1992, true))
        students.add(Student("이지수", 1984, false))



        studentAdapter = StudentAdapter(mContext, R.layout.student_list_view, students)
        listViewStudents.adapter = studentAdapter


    }

}
