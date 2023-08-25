package ir.misterdeveloper.MySpring.repository

import ir.misterdeveloper.MySpring.model.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface StudentRepository : CrudRepository<Student, Int> {
}