package od.konstantin.core.api.domain.models

enum class Exam {

    KROK_1, KROK_2, KROK_3, KROK_M, KROK_B;

    companion object {
        fun getExam(name: String): Exam? {
            return Exam.values().find { it.name.equals(name, ignoreCase = true) }
        }
    }
}