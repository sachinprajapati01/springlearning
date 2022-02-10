package com.axis.springlearn.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Student(
                    @Id
                    @GeneratedValue
                    var id: Int ,
                   var name : String ,
                   var gender:String ,
                   var email:String ,
                   var phone:String) {

}