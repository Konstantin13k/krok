package od.konstantin.feature_booklets.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import od.konstantin.core.util.extensions.context
import od.konstantin.feature_booklets.R
import od.konstantin.feature_booklets.data.models.BookletInfo
import od.konstantin.feature_booklets.databinding.ViewHolderBookletInfoBinding

class BookletInfoViewHolder private constructor(private val binding: ViewHolderBookletInfoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(bookletInfo: BookletInfo) {
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