package od.konstantin.core.exam

enum class Category {

    MEDICINE, STOMATOLOGY, PHARMACY;

    companion object {
        fun getCategory(name: String): Category? {
            return values().find { it.name.equals(name, ignoreCase = true) }
        }
    }
}
