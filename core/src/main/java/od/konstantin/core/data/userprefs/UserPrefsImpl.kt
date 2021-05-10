package od.konstantin.core.data.userprefs

import android.content.Context
import android.content.SharedPreferences
import od.konstantin.core.data.userprefs.delegates.ExamLanguagePreference
import od.konstantin.core.data.userprefs.delegates.ExamPreference
import od.konstantin.core.data.userprefs.delegates.SpecializationPreference
import od.konstantin.core.domain.userprefs.UserPrefs


internal class UserPrefsImpl(
    context: Context,
) : UserPrefs,
    SharedPreferences by context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE) {

    override var userSpecialization by SpecializationPreference(
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