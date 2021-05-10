package od.konstantin.core.domain.models

enum class Specialization {

    MEDICINE, DENTISTRY, PHARMACY;

    companion object {
        fun getCategory(name: String): Specialization? {
            return values().find { it.name.equals(name, ignoreCase = true) }
        }
    }
}
