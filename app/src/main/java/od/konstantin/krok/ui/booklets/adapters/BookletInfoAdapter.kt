package od.konstantin.krok.ui.booklets.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import od.konstantin.krok.R
import od.konstantin.krok.domain.models.booklets.BookletShortInfo

class BookletInfoAdapter : ListAdapter<BookletShortInfo, RecyclerView.ViewHolder>(
    BookletInfoComparator
) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val bookletInfo = getItem(position)
        if (holder is BookletInfoViewHolder) {
            holder.bind(bookletInfo)
        } else if (holder is BookletInfoWithSubBookletViewHolder) {
            holder.bind(bookletInfo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (R.layout.view_holder_booklet_with_subbooklet_info == viewType) {
            BookletInfoWithSubBookletViewHolder.from(parent)
        } else {
            BookletInfoViewHolder.from(parent)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).hasSubBooklet) {
            R.layout.view_holder_booklet_with_subbooklet_info
        } else {
            R.layout.view_holder_booklet_info
        }
    }
}