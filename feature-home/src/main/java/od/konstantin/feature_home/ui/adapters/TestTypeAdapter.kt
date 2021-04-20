package od.konstantin.feature_home.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import od.konstantin.feature_home.TestType
import od.konstantin.feature_home.ui.TestTypeHolder

class TestTypeAdapter(private val onClick: (TestType) -> Unit) :
    RecyclerView.Adapter<TestTypeHolder>() {

    private val testTypes = TestType.getList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestTypeHolder {
        return TestTypeHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TestTypeHolder, position: Int) {
        holder.bind(testTypes[position])
        val testType = testTypes[position]
        holder.itemView.setOnClickListener {
            onClick(testType)
        }
    }

    override fun getItemCount(): Int = testTypes.size
}