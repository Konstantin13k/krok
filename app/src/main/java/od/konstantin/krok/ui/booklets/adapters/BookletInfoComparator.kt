package od.konstantin.krok.ui.booklets.adapters

import androidx.recyclerview.widget.DiffUtil
import od.konstantin.krok.domain.models.booklets.BookletShortInfo

object BookletInfoComparator : DiffUtil.ItemCallback<BookletShortInfo>() {

    override fun areItemsTheSame(oldItem: BookletShortInfo, newItem: BookletShortInfo): Boolean {
        return oldItem.bookletId == newItem.bookletId
    }

    override fun areContentsTheSame(oldItem: BookletShortInfo, newItem: BookletShortInfo): Boolean {
        return oldItem == newItem
    }
}