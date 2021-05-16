package od.konstantin.krok.ui.booklets.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import od.konstantin.core.ui.extensions.context
import od.konstantin.krok.R
import od.konstantin.krok.databinding.ViewHolderBookletWithSubbookletInfoBinding
import od.konstantin.krok.domain.models.booklets.BookletShortInfo

class BookletInfoWithSubBookletViewHolder private constructor(private val binding: ViewHolderBookletWithSubbookletInfoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(bookletInfo: BookletShortInfo) {
        with(binding) {
            bookletTitle.text = context.getString(R.string.booklet_title, bookletInfo.year)
            bookletQuestions.text =
                context.getString(R.string.booklet_questions, bookletInfo.questions)

            subbookletTitle.text = context.getString(R.string.sub_booklet_title)
            subbookletQuestions.text = context.getString(
                R.string.booklet_questions,
                bookletInfo.subBookletInfo?.questions ?: 0
            )
        }
    }

    companion object {
        fun from(parent: ViewGroup): BookletInfoWithSubBookletViewHolder {
            return BookletInfoWithSubBookletViewHolder(
                ViewHolderBookletWithSubbookletInfoBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }
}