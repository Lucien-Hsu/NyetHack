fun main(args: Array<String>) {
    val student = Student(StudentStatus.Active("Kotlin101"))
    studentMessage(student.status)
}

fun studentMessage(status: StudentStatus): String {
    return when(status){
        is StudentStatus.NotEnrolled -> "Please choose a course!"
        is StudentStatus.Active -> "You are enrolled in: ${status.courseId}"
        is StudentStatus.Graduate -> "Congratulations!"
        else -> "Error"
    }
}

class Student(var status: StudentStatus)

//密封類別，可在類別內建立多個子類別
sealed class StudentStatus {
    object NotEnrolled : StudentStatus()    //無參數，且為單例，所以用 object 宣告
    class Active(val courseId: String) : StudentStatus()    //有參數，可能有多個，所以用 class 宣告
    object Graduate : StudentStatus()       //無參數，且為單例，所以用 object 宣告
}