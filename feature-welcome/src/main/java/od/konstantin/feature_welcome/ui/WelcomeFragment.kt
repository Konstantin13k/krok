package od.konstantin.feature_welcome.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import od.konstantin.core.di.CoreComponentHolder
import od.konstantin.feature_welcome.R
import od.konstantin.feature_welcome.databinding.FragmentWelcomeBinding
import od.konstantin.feature_welcome.di.DaggerWelcomeComponent
import od.konstantin.feature_welcome.di.WelcomeModule
import od.konstantin.feature_welcome.utils.setOnExamLanguageSelectListener
import od.konstantin.feature_welcome.utils.setOnExamSelectListener
import od.konstantin.feature_welcome.utils.setOnSpecializationSelectListener
import od.konstantin.krok.ui.base.BaseFragment
import od.konstantin.krok.ui.base.screenstate.EmptyState
import od.konstantin.krok.ui.extensions.viewBindings

class WelcomeFragment :
    BaseFragment<EmptyState, WelcomeCommand, WelcomeFragmentViewModel>(
        R.layout.fragment_welcome
    ) {

    private val binding by viewBindings { FragmentWelcomeBinding.bind(it) }

    override fun onInitDependencyInjection() {
        DaggerWelcomeComponent.factory().create(
            CoreComponentHolder.coreComponent,
            WelcomeModule(this)
        ).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        with(binding) {
            confirmButton.setOnClickListener {
                viewModel.confirm()
            }
            setOnSpecializationSelectListener {
                viewModel.chooseSpecialization(it)
            }
            setOnExamSelectListener {
                viewModel.chooseExam(it)
            }
            setOnExamLanguageSelectListener {
                viewModel.chooseExamLanguage(it)
            }
        }
    }

    override fun executeCommand(command: WelcomeCommand) {
        when (command) {
            WelcomeCommand.NavigateToMainScreen -> navigateToMainScreen()
            WelcomeCommand.ErrorNeedSelectSpecialization -> {
                showToast(getString(R.string.need_select_specialization))
            }
            WelcomeCommand.ErrorNeedSelectExam -> {
                showToast(getString(R.string.need_select_exam))
            }
            WelcomeCommand.ErrorNeedSelectExamLanguage -> {
                showToast(getString(R.string.need_select_exam_language))
            }
        }
    }

    private fun navigateToMainScreen() {
        findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToMainScreenFragment())
    }

    private fun showToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }
}