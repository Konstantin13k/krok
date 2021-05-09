package od.konstantin.core.domain.models

enum class Exam {

    KROK_1, KROK_2;

    companion object {
        fun getExam(name: String): Exam? {
            return values().find { it.name.equals(name, ignoreCase = true) }
        }
    }
}