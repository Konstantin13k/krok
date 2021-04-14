package od.konstantin.core.exam

enum class ExamLanguage(val lang: String) {

    ENGLISH("en"), UKRAINIAN("uk"), RUSSIAN("ru");

    companion object {
        fun getLanguage(lang: String): ExamLanguage {
            return values().find { it.lang.equals(lang, ignoreCase = true) } ?: ENGLISH
        }
    }
}