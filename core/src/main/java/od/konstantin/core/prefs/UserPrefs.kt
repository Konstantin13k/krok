package od.konstantin.core.prefs

import android.content.Context
import android.content.SharedPreferences
import od.konstantin.core.di.AppScope
import od.konstantin.core.prefs.delegates.CategoryPreference
import od.konstantin.core.prefs.delegates.ExamLanguagePreference
import od.konstantin.core.prefs.delegates.ExamPreference
import javax.inject.Inject

@AppScope
class UserPrefs @Inject constructor(
    context: Context,
) : SharedPreferences by context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE) {

    var userCategory by CategoryPreference(
        key = "user_category",
        defValue = null
    )

    var userExam by ExamPreference(
        key = "user_exam",
        defValue = null
    )

    var examLanguage by ExamLanguagePreference(
        key = "exam_language",
        defValue = null
    )

    fun deleteAllPrefs() = this.edit().clear().apply()
}