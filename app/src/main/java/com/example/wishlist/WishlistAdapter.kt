import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.R


class WishlistAdapter(private val items: MutableList<WishlistItem>) :
    RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNameTv: TextView = itemView.findViewById(R.id.itemNameTv)
        val itemPriceTv: TextView = itemView.findViewById(R.id.itemPriceTv)
        val itemUrlTv: TextView = itemView.findViewById(R.id.itemUrlTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.wishlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemNameTv.text = item.name
        holder.itemPriceTv.text = item.price
        holder.itemUrlTv.text = item.url
    }

    override fun getItemCount(): Int = items.size
}
