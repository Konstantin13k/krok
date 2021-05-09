package od.konstantin.core.domain.userprefs

import java.util.*

private const val EMPTY_STRING = ""

fun UserPrefs.isNeedToFillProfile(): Boolean {
    return userSpecialization == null || userExam == null || examLanguage == null
}

val UserPrefs.specialization: String
    get() = this.userSpecialization?.name?.lowercase(Locale.getDefault()) ?: EMPTY_STRING

val UserPrefs.exam: String
    get() = this.userExam?.name?.lowercase(Locale.getDefault()) ?: EMPTY_STRING

val UserPrefs.examLang: String
    get() = this.examLanguage?.name?.lowercase(Locale.getDefault()) ?: EMPTY_STRING