package od.konstantin.core.util.extensions

import od.konstantin.core.api.prefs.UserPrefs
import java.util.*

private const val EMPTY_STRING = ""

val UserPrefs.specialization: String
    get() = this.userCategory?.name?.lowercase(Locale.getDefault()) ?: EMPTY_STRING

val UserPrefs.exam: String
    get() = this.userExam?.name?.toLowerCase(Locale.getDefault()) ?: EMPTY_STRING

val UserPrefs.examLang: String
    get() = this.examLanguage?.name?.toLowerCase(Locale.getDefault()) ?: EMPTY_STRING