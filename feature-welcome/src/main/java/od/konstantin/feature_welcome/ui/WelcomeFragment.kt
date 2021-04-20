package od.konstantin.feature_welcome.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.collect
import od.konstantin.core.di.CoreComponentHolder
import od.konstantin.core.util.extensions.viewBindings
import od.konstantin.feature_welcome.R
import od.konstantin.feature_welcome.databinding.FragmentWelcomeBinding
import od.konstantin.feature_welcome.di.DaggerWelcomeComponent
import od.konstantin.feature_welcome.utils.setOnExamLanguageSelectListener
import od.konstantin.feature_welcome.utils.setOnExamSelectListener
import od.konstantin.feature_welcome.utils.setOnSpecializationSelectListener
import javax.inject.Inject

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    @Inject
    lateinit var viewModelFactory: WelcomeFragmentViewModelFactory

    private val viewModel: WelcomeFragmentViewModel by viewModels {
        viewModelFactory
    }

    private val binding by viewBindings { FragmentWelcomeBinding.bind(it) }

    override fun onAttach(context: Context) {
        DaggerWelcomeComponent.factory().create(CoreComponentHolder.coreComponent)
            .inject(this)

        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        initListeners()
    }

    private fun initObservers() {
        lifecycleScope.launchWhenCreated {
            viewModel.eventsFlow.collect { event ->
                when (event) {
                    WelcomeFragmentViewModel.Event.NavigateToMainScreen -> navigateToMainScreen()
                    WelcomeFragmentViewModel.Event.ErrorNeedSelectSpecialization -> {
                        showToast(getString(R.string.need_select_specialization))
                    }
                    WelcomeFragmentViewModel.Event.ErrorNeedSelectExam -> {
                        showToast(getString(R.string.need_select_exam))
                    }
                    WelcomeFragmentViewModel.Event.ErrorNeedSelectExamLanguage -> {
                        showToast(getString(R.string.need_select_exam_language))
                    }
                }
            }
        }
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

    private fun navigateToMainScreen() {
        findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToMainScreenFragment())
    }

    private fun showToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }
}