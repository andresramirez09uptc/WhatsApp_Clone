package com.example.whatsapp_clone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp_clone.databinding.ChatItemBinding

class ChatAdapter(
    private val onChatDeleted: (Chat) -> Unit
) : ListAdapter<Chat, ChatAdapter.ChatViewHolder>(ChatDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = ChatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat = getItem(position)
        holder.bind(chat, onChatDeleted)
    }

    class ChatViewHolder(
        private val binding: ChatItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(chat: Chat, onChatDeleted: (Chat) -> Unit) {
            binding.profileImage.setImageResource(
                if (adapterPosition % 2 == 0) R.drawable.ic_profile else R.drawable.ic_profile_woman
            )
            binding.contactName.text = chat.name
            binding.lastMessage.text = chat.message
            binding.messageTime.text = chat.time

            binding.root.setOnLongClickListener {
                onChatDeleted(chat)
                true
            }
        }
    }
}

class ChatDiffCallback : DiffUtil.ItemCallback<Chat>() {
    override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean {
        return oldItem == newItem
    }
}
