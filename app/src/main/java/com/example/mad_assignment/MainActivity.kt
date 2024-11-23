package com.example.mad_assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var addNoteButton: Button
    private lateinit var btnOpenDrawer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the drawer layout and navigation view
        drawerLayout = findViewById(R.id.drawerLayout)
        navView = findViewById(R.id.nav_view)

        // Initialize the buttons
        addNoteButton = findViewById(R.id.btn_add_note)
        btnOpenDrawer = findViewById(R.id.btn_open_drawer)

        // Set click listener to navigate to AddNoteActivity
        addNoteButton.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }

        // Set click listener to open the navigation drawer
        btnOpenDrawer.setOnClickListener {
            if (!drawerLayout.isDrawerOpen(navView)) {
                drawerLayout.openDrawer(navView)
            } else {
                drawerLayout.closeDrawer(navView)
            }
        }

        // Handle navigation menu item clicks
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.mItem1 -> {
                    // Navigate to ArchiveActivity
                    val archiveIntent = Intent(this, ArchiveActivity::class.java)
                    startActivity(archiveIntent)
                }
                R.id.mItem2 -> {
                    // Navigate to TrashActivity
                    val trashIntent = Intent(this, TrashActivity::class.java)
                    startActivity(trashIntent)
                }
                // Add more cases if needed for other menu items (e.g., Settings, Help & Feedback)
            }
            // Close the drawer after an item is selected
            drawerLayout.closeDrawers()
            true
        }
    }
}
