package od.konstantin.core.prefs.delegates

import android.content.SharedPreferences
import od.konstantin.core.exam.Category
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class CategoryPreference(
    private val key: String,
    private val defValue: Category?
) : ReadWriteProperty<SharedPreferences, Category?> {

    override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): Category? {
        val categoryName = thisRef.getString(key, defValue?.name)
        return categoryName?.let { Category.getCategory(it) }
    }

    override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: Category?) {
        if (value == null) {
            thisRef.edit().remove(key).apply()
        } else {
            thisRef.edit().putString(key, value.name).apply()
        }
    }
}