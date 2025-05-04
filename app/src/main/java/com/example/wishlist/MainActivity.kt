package com.example.wishlist

import WishlistAdapter
import WishlistItem
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: WishlistAdapter
    private lateinit var itemName: EditText
    private lateinit var itemPrice: EditText
    private lateinit var itemUrl: EditText
    private lateinit var addButton: Button
    private lateinit var wishlistRecyclerView: RecyclerView

    private val wishListItems = mutableListOf<WishlistItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemName = findViewById(R.id.itemName)
        itemPrice = findViewById(R.id.itemPrice)
        itemUrl = findViewById(R.id.itemUrl)
        addButton = findViewById(R.id.addButton)
        wishlistRecyclerView = findViewById(R.id.wishlistRecyclerView)

        adapter = WishlistAdapter(wishListItems)
        wishlistRecyclerView.adapter = adapter
        wishlistRecyclerView.layoutManager = LinearLayoutManager(this)

        addButton.setOnClickListener {
            val name = itemName.text.toString()
            val price = itemPrice.text.toString()
            val url = itemUrl.text.toString()

            if (name.isNotEmpty() && price.isNotEmpty() && url.isNotEmpty()) {
                wishListItems.add(WishlistItem(name, price, url))
                adapter.notifyItemInserted(wishListItems.size - 1)
                itemName.text.clear()
                itemPrice.text.clear()
                itemUrl.text.clear()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
