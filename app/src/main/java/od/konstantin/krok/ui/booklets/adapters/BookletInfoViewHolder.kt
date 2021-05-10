package od.konstantin.krok.ui.booklets.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import od.konstantin.core.ui.extensions.context
import od.konstantin.krok.R
import od.konstantin.krok.databinding.ViewHolderBookletInfoBinding

class BookletInfoViewHolder private constructor(private val binding: ViewHolderBookletInfoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(bookletInfo: od.konstantin.krok.domain.models.booklets.BookletShortInfo) {
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