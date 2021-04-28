package od.konstantin.feature_welcome.ui

import od.konstantin.core.exam.Category
import od.konstantin.core.exam.Exam
import od.konstantin.core.exam.ExamLanguage
import od.konstantin.krok.ui.base.screenstate.ScreenState

sealed class WelcomeFragmentState : ScreenState {

    object NothingSelected : WelcomeFragmentState()

    data class SelectedUserExamOptions(
        val selectedSpecialization: Category?,
        val selectedExam: Exam?,
        val selectedExamLanguage: ExamLanguage?,
    ) : WelcomeFragmentState()
}
