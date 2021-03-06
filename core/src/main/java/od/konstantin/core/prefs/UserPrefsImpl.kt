package od.konstantin.core.prefs

import android.content.Context
import android.content.SharedPreferences
import od.konstantin.core.di.AppScope
import od.konstantin.core.prefs.delegates.CategoryPreference
import od.konstantin.core.prefs.delegates.ExamLanguagePreference
import od.konstantin.core.prefs.delegates.ExamPreference

@AppScope
internal class UserPrefsImpl constructor(
    context: Context,
) : UserPrefs,
    SharedPreferences by context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE) {

    override var userCategory by CategoryPreference(
        key = "user_category",
        defValue = null
    )

    override var userExam by ExamPreference(
        key = "user_exam",
        defValue = null
    )

    override var examLanguage by ExamLanguagePreference(
        key = "exam_language",
        defValue = null
    )

    override fun deleteAllPrefs() = this.edit().clear().apply()
}