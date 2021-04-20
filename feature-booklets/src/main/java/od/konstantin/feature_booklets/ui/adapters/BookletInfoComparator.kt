package od.konstantin.feature_booklets.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import od.konstantin.feature_booklets.data.models.BookletInfo

object BookletInfoComparator : DiffUtil.ItemCallback<BookletInfo>() {

    override fun areItemsTheSame(oldItem: BookletInfo, newItem: BookletInfo): Boolean {
        return oldItem.bookletId == newItem.bookletId
    }

    override fun areContentsTheSame(oldItem: BookletInfo, newItem: BookletInfo): Boolean {
        return oldItem == newItem
    }
}