package od.konstantin.krok.ui.welcome

import od.konstantin.core.domain.models.Exam
import od.konstantin.core.domain.models.ExamLanguage
import od.konstantin.core.domain.models.Specialization
import od.konstantin.krok.databinding.FragmentWelcomeBinding

inline fun FragmentWelcomeBinding.setOnSpecializationSelectListener(crossinline listener: (Specialization) -> Unit) {
    specializations.addOnButtonCheckedListener { _, checkedId, isChecked ->
        if (isChecked) {
            when (checkedId) {
                medicineSpecializationButton.id -> listener(Specialization.MEDICINE)
                stomatologySpecializationButton.id -> listener(Specialization.DENTISTRY)
                pharmacySpecializationButton.id -> listener(Specialization.PHARMACY)
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