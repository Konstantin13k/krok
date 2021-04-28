package od.konstantin.feature_welcome.ui

import od.konstantin.krok.ui.base.command.Command

sealed class WelcomeCommand : Command {
    object NavigateToMainScreen : WelcomeCommand()
    object ErrorNeedSelectSpecialization : WelcomeCommand()
    object ErrorNeedSelectExam : WelcomeCommand()
    object ErrorNeedSelectExamLanguage : WelcomeCommand()
}