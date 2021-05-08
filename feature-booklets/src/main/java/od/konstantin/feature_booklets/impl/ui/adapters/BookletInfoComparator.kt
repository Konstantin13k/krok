package od.konstantin.feature_booklets.impl.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import od.konstantin.feature_booklets.api.domain.models.BookletShortInfo

object BookletInfoComparator : DiffUtil.ItemCallback<BookletShortInfo>() {

    override fun areItemsTheSame(oldItem: BookletShortInfo, newItem: BookletShortInfo): Boolean {
        return oldItem.bookletId == newItem.bookletId
    }

    override fun areContentsTheSame(oldItem: BookletShortInfo, newItem: BookletShortInfo): Boolean {
        return oldItem == newItem
    }
}