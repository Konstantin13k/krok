package od.konstantin.feature_welcome.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import od.konstantin.core.exam.Category
import od.konstantin.core.exam.Exam
import od.konstantin.core.exam.ExamLanguage
import od.konstantin.core.prefs.UserPrefs
import javax.inject.Inject


class WelcomeFragmentViewModel @Inject constructor(
    private val userPrefs: UserPrefs
) : ViewModel() {

    private var selectedSpecialization: Category? = null
    private var selectedExam: Exam? = null
    private var selectedExamLanguage: ExamLanguage? = null

    sealed class Event {
        object NavigateToMainScreen : Event()
        object ErrorNeedSelectSpecialization : Event()
        object ErrorNeedSelectExam : Event()
        object ErrorNeedSelectExamLanguage : Event()
    }

    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()

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
            selectedSpecialization == null -> onEvent(Event.ErrorNeedSelectSpecialization)
            selectedExam == null -> onEvent(Event.ErrorNeedSelectExam)
            selectedExamLanguage == null -> onEvent(Event.ErrorNeedSelectExamLanguage)
            else -> {
                userPrefs.userCategory = selectedSpecialization
                userPrefs.userExam = selectedExam
                userPrefs.examLanguage = selectedExamLanguage
                onEvent(Event.NavigateToMainScreen)
            }
        }
    }

    private fun onEvent(event: Event) {
        viewModelScope.launch {
            eventChannel.send(event)
        }
    }
}