package com.axis.springlearn.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.Pattern

@Entity
data class Student(
    @Id
    @GeneratedValue
    var id: Int,
    var name: String,
    var gender: String,
    @get:Email(message = "Invalid Email")
    var email: String,
    @get:Pattern(regexp = "^[0-9]{10}") //[range of char or int]{count}
    var phone: String
) {

}