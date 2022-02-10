package com.axis.springlearn.repository

import com.axis.springlearn.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student,Int>{

}
