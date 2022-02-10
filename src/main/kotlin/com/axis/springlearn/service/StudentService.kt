package com.axis.springlearn.service

import com.axis.learnspring.exception.StudentNotFoundException
import com.axis.springlearn.model.Student
import org.springframework.stereotype.Service

@Service
class StudentService {

    val students = mutableListOf<Student>(
        Student(1, "sachin", "male", "gmail", "12345678"),
        Student(2, "sachin2", "male", "gmail", "123456780"),
        Student(3, "sachin3","male","gmail","123456789")
    )

    fun findOne(id: Int): Student? {
        for (student in students) {
            if(student.id == id) {
                return student
            }
        }
        //return null
        throw StudentNotFoundException("Student not found")
    }

    fun findAll(): MutableList<Student> {
        return students
    }



    fun delete(id :Int) :String?{
        for(student in students){
            if(student.id == id ){
                students.remove(student)
                return "Deleted Succesfully"
            }
        }
        throw StudentNotFoundException("Student not found")
    }
    fun saveOrUpdate(student: Student): Boolean {
        if(findOne(student.id) !=null) {
            delete(student.id)
        }
            return students.add(student)
        }

}