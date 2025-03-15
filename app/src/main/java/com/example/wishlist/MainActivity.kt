import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.R

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: WishlistAdapter
    private lateinit var itemName: EditText
    private lateinit var itemPrice: EditText
    private lateinit var itemUrl: EditText
    private lateinit var addButton: Button
    private lateinit var wishlistRecyclerView: RecyclerView

    private val wishlistItems = mutableListOf<WishlistItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        itemName = findViewById(R.id.itemName)
        itemPrice = findViewById(R.id.itemPrice)
        itemUrl = findViewById(R.id.itemUrl)
        addButton = findViewById(R.id.addButton)
        wishlistRecyclerView = findViewById(R.id.wishlistRecyclerView)

        // Set up RecyclerView
        adapter = WishlistAdapter(wishlistItems)
        wishlistRecyclerView.adapter = adapter
        wishlistRecyclerView.layoutManager = LinearLayoutManager(this)

        // Add button listener
        addButton.setOnClickListener {
            val name = itemName.text.toString()
            val price = itemPrice.text.toString()
            val url = itemUrl.text.toString()

            if (name.isNotBlank() && price.isNotBlank() && url.isNotBlank()) {
                // Add new item to list
                val newItem = WishlistItem(name, price, url)
                wishlistItems.add(newItem)
                adapter.notifyItemInserted(wishlistItems.size - 1)

                // Clear input fields
                itemName.text.clear()
                itemPrice.text.clear()
                itemUrl.text.clear()
            } else {
                // Handle empty fields (e.g., show a toast)
                Toast.makeText(this, "All fields must be filled out", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
