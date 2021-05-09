package od.konstantin.krok.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import od.konstantin.core.ui.extensions.context
import od.konstantin.krok.R
import od.konstantin.krok.databinding.ViewHolderTestBinding

class TestTypeHolder private constructor(private val binding: ViewHolderTestBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(testType: od.konstantin.krok.domain.models.TestType) {
        when (testType) {
            od.konstantin.krok.domain.models.TestType.Booklets -> bindBooklets()
            od.konstantin.krok.domain.models.TestType.Bases -> bindBases()
            od.konstantin.krok.domain.models.TestType.DifficultQuestions -> bindDifficultQuestions()
            od.konstantin.krok.domain.models.TestType.UnfinishedQuestions -> bindUnfinishedQuestions()
        }
    }

    private fun bindBooklets() {
        with(binding) {
            testTypeImage.setImageResource(R.drawable.img_exam_green)
            testTypeTitle.text = context.getString(R.string.test_type_booklets_title)
            testTypeDescription.text = context.getString(R.string.test_type_booklets_description)
        }
    }

    private fun bindBases() {
        with(binding) {
            testTypeImage.setImageResource(R.drawable.img_exam_blue)
            testTypeTitle.text = context.getString(R.string.test_type_bases_title)
            testTypeDescription.text = context.getString(R.string.test_type_bases_description)
        }
    }

    private fun bindDifficultQuestions() {
        with(binding) {
            testTypeImage.setImageResource(R.drawable.img_exam_yellow)
            testTypeTitle.text = context.getString(R.string.test_type_difficult_questions_title)
            testTypeDescription.text =
                context.getString(R.string.test_type_difficult_questions_description)
        }
    }

    private fun bindUnfinishedQuestions() {
        with(binding) {
            testTypeImage.setImageResource(R.drawable.img_exam_purple)
            testTypeTitle.text = context.getString(R.string.test_type_unfinished_tests_title)
            testTypeDescription.text =
                context.getString(R.string.test_type_unfinished_tests_description)
        }
    }

    companion object {
        fun from(parent: ViewGroup): TestTypeHolder {
            return TestTypeHolder(
                ViewHolderTestBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }
}