package com.axis.learnspring.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
@RestController
class CustomResponseEntityExceptionHandler : ResponseEntityExceptionHandler(){

    @ExceptionHandler(StudentNotFoundException::class)
    fun handleStudentNotFoundException(ex : Exception, wr : WebRequest): ResponseEntity<Any>? {
        val response = ExceptionResponse(Date(), "Student not found exception")
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }

}