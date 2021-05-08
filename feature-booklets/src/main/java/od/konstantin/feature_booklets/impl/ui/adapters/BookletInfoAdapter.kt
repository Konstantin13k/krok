package od.konstantin.feature_booklets.impl.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import od.konstantin.feature_booklets.api.domain.models.BookletShortInfo

class BookletInfoAdapter : ListAdapter<BookletShortInfo, BookletInfoViewHolder>(BookletInfoComparator) {

    override fun onBindViewHolder(holder: BookletInfoViewHolder, position: Int) {
        val bookletInfo = getItem(position)
        holder.bind(bookletInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookletInfoViewHolder {
        return BookletInfoViewHolder.from(parent)
    }
}