package od.konstantin.krok.ui.booklets.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class BookletInfoAdapter : ListAdapter<od.konstantin.krok.domain.models.booklets.BookletShortInfo, BookletInfoViewHolder>(
    BookletInfoComparator
) {

    override fun onBindViewHolder(holder: BookletInfoViewHolder, position: Int) {
        val bookletInfo = getItem(position)
        holder.bind(bookletInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookletInfoViewHolder {
        return BookletInfoViewHolder.from(parent)
    }
}