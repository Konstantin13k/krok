package od.konstantin.core.prefs.delegates

import android.content.SharedPreferences
import od.konstantin.core.exam.ExamLanguage
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ExamLanguagePreference(
    private val key: String,
    private val defValue: ExamLanguage?
) : ReadWriteProperty<SharedPreferences, ExamLanguage?> {

    override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): ExamLanguage? {
        val examName = thisRef.getString(key, defValue?.lang)
        return examName?.let { ExamLanguage.getLanguage(it) }
    }

    override fun setValue(
        thisRef: SharedPreferences,
        property: KProperty<*>,
        value: ExamLanguage?
    ) {
        if (value == null) {
            thisRef.edit().remove(key).apply()
        } else {
            thisRef.edit().putString(key, value.lang).apply()
        }
    }
}