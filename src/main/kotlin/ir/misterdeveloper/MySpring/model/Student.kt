package ir.misterdeveloper.MySpring.model

import jakarta.persistence.Entity
import jakarta.persistence.Id


@Entity
data class Student(

    @Id
    var id: Int,
    var nameStudent: String,
    var numberStudent: String

) {
    constructor() : this(-1, "", "")
}