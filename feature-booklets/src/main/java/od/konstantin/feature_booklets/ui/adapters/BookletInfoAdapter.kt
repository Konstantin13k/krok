package od.konstantin.feature_booklets.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import od.konstantin.feature_booklets.data.models.BookletInfo

class BookletInfoAdapter : ListAdapter<BookletInfo, BookletInfoViewHolder>(BookletInfoComparator) {

    override fun onBindViewHolder(holder: BookletInfoViewHolder, position: Int) {
        val bookletInfo = getItem(position)
        holder.bind(bookletInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookletInfoViewHolder {
        return BookletInfoViewHolder.from(parent)
    }
}