package od.konstantin.feature_booklets.impl.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import od.konstantin.feature_booklets.R
import od.konstantin.feature_booklets.api.domain.models.BookletShortInfo
import od.konstantin.feature_booklets.databinding.ViewHolderBookletInfoBinding
import od.konstantin.krok.ui.extensions.context

class BookletInfoViewHolder private constructor(private val binding: ViewHolderBookletInfoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(bookletInfo: BookletShortInfo) {
        with(binding) {
            bookletTitle.text = context.getString(R.string.booklet_title, bookletInfo.year)
            bookletQuestions.text =
                context.getString(R.string.booklet_questions, bookletInfo.questions)
        }
    }

    companion object {
        fun from(parent: ViewGroup): BookletInfoViewHolder {
            return BookletInfoViewHolder(
                ViewHolderBookletInfoBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }
}