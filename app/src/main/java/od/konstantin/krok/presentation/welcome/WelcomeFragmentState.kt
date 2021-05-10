package od.konstantin.krok.presentation.welcome

import od.konstantin.core.domain.models.Specialization
import od.konstantin.core.domain.models.Exam
import od.konstantin.core.domain.models.ExamLanguage
import od.konstantin.core.presentation.screenstate.ScreenState

sealed class WelcomeFragmentState : ScreenState {

    object NothingSelected : WelcomeFragmentState()

    data class SelectedUserExamOptions(
        val selectedSpecialization: Specialization?,
        val selectedExam: Exam?,
        val selectedExamLanguage: ExamLanguage?,
    ) : WelcomeFragmentState()
}
