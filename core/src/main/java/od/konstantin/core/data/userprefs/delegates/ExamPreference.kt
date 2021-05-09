package od.konstantin.core.data.userprefs.delegates

import android.content.SharedPreferences
import od.konstantin.core.domain.models.Exam
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ExamPreference(
    private val key: String,
    private val defValue: Exam?
) : ReadWriteProperty<SharedPreferences, Exam?> {

    override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): Exam? {
        val examName = thisRef.getString(key, defValue?.name)
        return examName?.let { Exam.getExam(it) }
    }

    override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: Exam?) {
        if (value == null) {
            thisRef.edit().remove(key).apply()
        } else {
            thisRef.edit().putString(key, value.name).apply()
        }
    }
}