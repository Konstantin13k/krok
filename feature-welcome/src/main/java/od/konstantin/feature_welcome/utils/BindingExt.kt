package od.konstantin.feature_welcome.utils

import od.konstantin.core.api.domain.models.Category
import od.konstantin.core.api.domain.models.Exam
import od.konstantin.core.api.domain.models.ExamLanguage
import od.konstantin.feature_welcome.databinding.FragmentWelcomeBinding

inline fun FragmentWelcomeBinding.setOnSpecializationSelectListener(crossinline listener: (Category) -> Unit) {
    specializations.addOnButtonCheckedListener { _, checkedId, isChecked ->
        if (isChecked) {
            when (checkedId) {
                medicineSpecializationButton.id -> listener(Category.MEDICINE)
                stomatologySpecializationButton.id -> listener(Category.STOMATOLOGY)
                pharmacySpecializationButton.id -> listener(Category.PHARMACY)
                else -> throw IllegalArgumentException("Unknown specialization id: $checkedId")
            }
        }
    }
}

inline fun FragmentWelcomeBinding.setOnExamSelectListener(crossinline listener: (Exam) -> Unit) {
    exams.addOnButtonCheckedListener { _, checkedId, isChecked ->
        if (isChecked) {
            when (checkedId) {
                krok1Button.id -> listener(Exam.KROK_1)
                krok2Button.id -> listener(Exam.KROK_2)
                else -> throw IllegalArgumentException("Unknown exam id: $checkedId")
            }
        }
    }
}

inline fun FragmentWelcomeBinding.setOnExamLanguageSelectListener(crossinline listener: (ExamLanguage) -> Unit) {
    examLanguages.addOnButtonCheckedListener { _, checkedId, isChecked ->
        if (isChecked) {
            when (checkedId) {
                ukrainianLanguageButton.id -> listener(ExamLanguage.UKRAINIAN)
                russianLanguageButton.id -> listener(ExamLanguage.RUSSIAN)
                englishLanguageButton.id -> listener(ExamLanguage.ENGLISH)
                else -> throw IllegalArgumentException("Unknown specialization id: ${checkedId}")
            }
        }
    }
}