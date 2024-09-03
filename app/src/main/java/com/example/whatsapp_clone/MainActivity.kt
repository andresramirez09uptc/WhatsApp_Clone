package com.example.whatsapp_clone

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsapp_clone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val chatViewModel: ChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        chatViewModel.uiState.observe(this) { state ->
            (binding.recyclerViewChats.adapter as ChatAdapter).submitList(state.chats)
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerViewChats.layoutManager = LinearLayoutManager(this)
        val chatAdapter = ChatAdapter { chat ->
            chatViewModel.removeChat(chat)
            Toast.makeText(this, getString(R.string.chat_deleted, chat.name), Toast.LENGTH_SHORT).show()
        }
        binding.recyclerViewChats.adapter = chatAdapter
    }
}
