package od.konstantin.core.api.prefs

import od.konstantin.core.api.domain.models.Category
import od.konstantin.core.api.domain.models.Exam
import od.konstantin.core.api.domain.models.ExamLanguage

interface UserPrefs {

    var userCategory: Category?

    var userExam: Exam?

    var examLanguage: ExamLanguage?

    fun deleteAllPrefs()
}

fun UserPrefs.isNeedToFillProfile(): Boolean {
    return userCategory == null || userExam == null || examLanguage == null
}