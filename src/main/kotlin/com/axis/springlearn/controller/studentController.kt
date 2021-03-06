package com.axis.springlearn.controller

import com.axis.springlearn.model.Student
import com.axis.springlearn.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class studentController (@Autowired val studentService: StudentService){
    //Method    //Endpoint
    @GetMapping("/hello")
    fun display():String{
        return "Hello Empire"
    }
    @GetMapping("/students")
    fun getStudents(): MutableList<Student> {
       return studentService.findAll()
    }

    @GetMapping("/path/{id}")
    fun getPathVariable( @PathVariable id:Int  ):String{
        return "Recived Path Variable $id"
    }
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

    @GetMapping("/student/{id}")
    fun getStudent(@PathVariable id: Int): Student? {
        println("Start")
        val student = studentService.findOne(id)
        println("End")
        return student
    }



    @PostMapping("/student")
    fun addStudent( @RequestBody student:Student): Boolean{
        return studentService.saveOrUpdate(student)
    }
    @DeleteMapping("/student/{id}")
    fun deleteStudent( @PathVariable id:Int): String?{
        return studentService.delete(id)
    }
    @PutMapping("/student")
    fun editStudent(@RequestBody student: Student):Boolean{
        return studentService.saveOrUpdate(student)
    }
//    Add Student
//    Edit Student
//    Delete Student
//    Get Student
//    Get All Student

}