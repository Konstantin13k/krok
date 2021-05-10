package od.konstantin.krok.presentation.welcome

import od.konstantin.core.presentation.command.Command

sealed class WelcomeCommand : Command {
    object NavigateToMainScreen : WelcomeCommand()
    object ErrorNeedSelectSpecialization : WelcomeCommand()
    object ErrorNeedSelectExam : WelcomeCommand()
    object ErrorNeedSelectExamLanguage : WelcomeCommand()
}