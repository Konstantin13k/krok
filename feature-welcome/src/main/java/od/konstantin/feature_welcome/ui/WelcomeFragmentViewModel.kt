package od.konstantin.feature_welcome.ui

import od.konstantin.core.exam.Category
import od.konstantin.core.exam.Exam
import od.konstantin.core.exam.ExamLanguage
import od.konstantin.core.prefs.UserPrefs
import od.konstantin.krok.ui.base.BaseViewModel
import od.konstantin.krok.ui.base.screenstate.EmptyState
import javax.inject.Inject


class WelcomeFragmentViewModel @Inject constructor(
    private val userPrefs: UserPrefs
) : BaseViewModel<EmptyState, WelcomeCommand>(EmptyState) {

    private var selectedSpecialization: Category? = null
    private var selectedExam: Exam? = null
    private var selectedExamLanguage: ExamLanguage? = null

    fun chooseSpecialization(specialization: Category) {
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
                userPrefs.userCategory = selectedSpecialization
                userPrefs.userExam = selectedExam
                userPrefs.examLanguage = selectedExamLanguage
                executeCommand(WelcomeCommand.NavigateToMainScreen)
            }
        }
    }
}