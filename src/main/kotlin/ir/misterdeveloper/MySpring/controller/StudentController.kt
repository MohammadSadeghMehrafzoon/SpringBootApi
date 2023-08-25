package ir.misterdeveloper.MySpring.controller


import com.google.gson.Gson
import ir.misterdeveloper.MySpring.model.Student
import ir.misterdeveloper.MySpring.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController {

    lateinit var studentRepository: StudentRepository

    @Autowired
    fun set_student_repository(studentRepo: StudentRepository) {
        studentRepository = studentRepo
    }

    @GetMapping("/getAllStudent")
    fun getAllStudent(): ResponseEntity<MutableIterable<Student>> {

        val dataFromDatabase = studentRepository.findAll()
        return ResponseEntity.ok(dataFromDatabase)

    }

    @PostMapping("/addNewStudent")
    fun insertNewStudent(@RequestBody data: String): ResponseEntity<String> {


        val gson = Gson()
        val newStudent = gson.fromJson<Student>(data, Student::class.java)

        studentRepository.save(newStudent)

        return ResponseEntity.ok("Your data has been added")

    }

    @DeleteMapping("/student/deleteStudent{id}")
    fun deleteStudent(@PathVariable("id") id: Int): ResponseEntity<String> {

        studentRepository.deleteById(id)

        return ResponseEntity.ok("The student has been removed")

    }

    @PutMapping("/student/updateStudent{id}")
    fun updateDataStudent(@PathVariable("id") id: Int, @RequestBody data: String): ResponseEntity<String> {

        val gson = Gson()
        val updateStudent: Student = gson.fromJson(data, Student::class.java)
        studentRepository.save(updateStudent)

        return ResponseEntity.ok("The student has been updated")

    }


}