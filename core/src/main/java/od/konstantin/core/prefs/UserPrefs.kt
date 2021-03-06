package od.konstantin.core.prefs

import od.konstantin.core.exam.Category
import od.konstantin.core.exam.Exam
import od.konstantin.core.exam.ExamLanguage

interface UserPrefs {

    var userCategory: Category?

    var userExam: Exam?

    var examLanguage: ExamLanguage?

    fun deleteAllPrefs()
}

fun UserPrefs.isNeedToFillProfile(): Boolean {
    return userCategory == null || userExam == null || examLanguage == null
}