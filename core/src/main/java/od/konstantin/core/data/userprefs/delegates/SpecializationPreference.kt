package od.konstantin.core.data.userprefs.delegates

import android.content.SharedPreferences
import od.konstantin.core.domain.models.Specialization
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SpecializationPreference(
    private val key: String,
    private val defValue: Specialization?
) : ReadWriteProperty<SharedPreferences, Specialization?> {

    override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): Specialization? {
        val categoryName = thisRef.getString(key, defValue?.name)
        return categoryName?.let { Specialization.getCategory(it) }
    }

    override fun setValue(
        thisRef: SharedPreferences,
        property: KProperty<*>,
        value: Specialization?
    ) {
        if (value == null) {
            thisRef.edit().remove(key).apply()
        } else {
            thisRef.edit().putString(key, value.name).apply()
        }
    }
}