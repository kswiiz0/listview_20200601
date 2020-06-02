package com.phis.listview_20200601.datas

class Student(val name:String, val birthYear:Int, val isMale:Boolean) {

    fun getKoreanAge(thisYear:Int):Int{
        return (thisYear-birthYear)+1
    }


}