package com.axis.springlearn.controller

import com.axis.springlearn.model.Student
import com.axis.springlearn.service.StudentServiceTwo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
class studentControllerTwo (@Autowired val studentService: StudentServiceTwo){
    //Method    //Endpoint
//    @GetMapping("/hello")
//    fun display():String{
//        return "Hello Empire"
//    }
    @GetMapping("/studentstwo")
    fun getStudents(): List<Student> {
       return studentService.retriveAllStudent()
    }
//
//    @GetMapping("/path/{id}")
//    fun getPathVariable( @PathVariable id:Int  ):String{
//        return "Recived Path Variable $id"
//    }

//    @GetMapping("/student/{id}")
//    fun getStudent( @PathVariable id: Int ):Student?{
//        return studentService.findOne(id)
//    }
    //if not found it return nothing but we have to push status so


//    @GetMapping("/student/{id}")
//    fun getStudent( @PathVariable id: Int ):ResponseEntity<Student>{
//        val student= studentService.findOne(id)
//        if(student == null){
//            return ResponseEntity<Student> (HttpStatus.NOT_FOUND )
//        }
//        return ResponseEntity<Student>(student,HttpStatus.OK)
//    }

    //We can do this also with exception handling by throwing exception in find function

    @GetMapping("/studenttwo/{id}")
    fun getStudent(@PathVariable id: Int): Optional<Student>{
        println("Start")
        val student = studentService.retriveStudent(id)
        println("End")
        return student
    }

//
//
    @PostMapping("/studenttwo")
    fun addStudent( @RequestBody student:Student): Student{
        return studentService.add(student)
    }
    @DeleteMapping("/studenttwo/{id}")
    fun deleteStudent( @PathVariable id:Int){
        return studentService.removeStudent(id)
    }
    @PutMapping("/studenttwo")
    fun editStudent(@RequestBody student: Student):Student{
        return studentService.add(student)
    }
//    Add Student
//    Edit Student
//    Delete Student
//    Get Student
//    Get All Student

}