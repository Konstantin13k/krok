package od.konstantin.krok.ui.welcome

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import od.konstantin.core.presentation.screenstate.EmptyState
import od.konstantin.core.ui.BaseFragment
import od.konstantin.core.ui.extensions.viewBindings
import od.konstantin.krok.R
import od.konstantin.krok.databinding.FragmentWelcomeBinding
import od.konstantin.krok.presentation.welcome.WelcomeCommand
import od.konstantin.krok.presentation.welcome.WelcomeFragmentViewModel

@AndroidEntryPoint
class WelcomeFragment :
    BaseFragment<EmptyState, WelcomeCommand, WelcomeFragmentViewModel>(
        R.layout.fragment_welcome,
        WelcomeFragmentViewModel::class.java
    ) {

    private val binding by viewBindings { FragmentWelcomeBinding.bind(it) }

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