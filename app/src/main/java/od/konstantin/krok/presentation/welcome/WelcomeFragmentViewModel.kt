package od.konstantin.krok.presentation.welcome

import dagger.hilt.android.lifecycle.HiltViewModel
import od.konstantin.core.domain.models.Exam
import od.konstantin.core.domain.models.ExamLanguage
import od.konstantin.core.domain.models.Specialization
import od.konstantin.core.domain.userprefs.UserPrefs
import od.konstantin.core.presentation.BaseViewModel
import od.konstantin.core.presentation.screenstate.EmptyState
import javax.inject.Inject

@HiltViewModel
class WelcomeFragmentViewModel @Inject constructor(
    private val userPrefs: UserPrefs
) : BaseViewModel<EmptyState, WelcomeCommand>(EmptyState) {

    private var selectedSpecialization: Specialization? = null
    private var selectedExam: Exam? = null
    private var selectedExamLanguage: ExamLanguage? = null

    fun chooseSpecialization(specialization: Specialization) {
        selectedSpecialization = specialization
    }

    fun chooseExam(exam: Exam) {
        selectedExam = exam
    }

    fun chooseExamLanguage(language: ExamLanguage) {
        selectedExamLanguage = language
    }

    fun confirm() {
        when {
            selectedSpecialization == null -> executeCommand(WelcomeCommand.ErrorNeedSelectSpecialization)
            selectedExam == null -> executeCommand(WelcomeCommand.ErrorNeedSelectExam)
            selectedExamLanguage == null -> executeCommand(WelcomeCommand.ErrorNeedSelectExamLanguage)
            else -> {
                userPrefs.userSpecialization = selectedSpecialization
                userPrefs.userExam = selectedExam
                userPrefs.examLanguage = selectedExamLanguage
                executeCommand(WelcomeCommand.NavigateToMainScreen)
            }
        }
    }
}