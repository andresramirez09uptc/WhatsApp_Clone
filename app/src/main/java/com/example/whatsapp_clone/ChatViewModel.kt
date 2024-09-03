package com.example.whatsapp_clone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatViewModel : ViewModel() {

    private val _uiState = MutableLiveData<ChatUIState>()
    val uiState: LiveData<ChatUIState> = _uiState

    init {
        val initialChats = listOf(
            Chat("Carlos Ramírez", "Hola, ¿cómo estás?", "12:45 PM"),
            Chat("Laura Pérez", "Nos vemos mañana.", "11:30 AM"),
            Chat("Juan Gómez", "¿Puedes enviarme los documentos?", "Ayer"),
            Chat("María Rodríguez", "Claro, estaré ahí.", "Lunes"),
            // Añadir los 11 chats restantes...
        )
        _uiState.value = ChatUIState(chats = initialChats)
    }

    fun removeChat(chat: Chat) {
        val currentList = _uiState.value?.chats ?: return
        _uiState.value = ChatUIState(chats = currentList.filter { it != chat })
    }
}
