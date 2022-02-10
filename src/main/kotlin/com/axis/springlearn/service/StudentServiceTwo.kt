package com.axis.springlearn.service

import com.axis.learnspring.exception.StudentNotFoundException
import com.axis.springlearn.model.Student
import com.axis.springlearn.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class StudentServiceTwo (@Autowired val studentRepository: StudentRepository){

    fun add(student: Student ) :Student{
        return studentRepository.save(student)
    }
    fun retriveAllStudent():List<Student>{
        return studentRepository.findAll()
    }
    fun retriveStudent(id : Int) :Optional<Student> {
        return studentRepository.findById(id)
    }
    fun removeStudent(id :Int){
        return studentRepository.deleteById(id)
    }
}