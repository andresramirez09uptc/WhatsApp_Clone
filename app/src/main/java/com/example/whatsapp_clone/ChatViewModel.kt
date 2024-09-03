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
            Chat("Andrés López", "¡Qué bueno verte después de tanto tiempo!", "Semana pasada"),
            Chat("Diana Martínez", "¡Feliz cumpleaños!", "Mes pasado"),
            Chat("Luis Torres", "Te llamo más tarde.", "10 de marzo"),
            Chat("Carolina Gutiérrez", "¡Ya tengo las entradas!", "28 de febrero"),
            Chat("Jorge Vargas", "¿Vamos a cenar hoy?", "6:00 PM"),
            Chat("Ana Morales", "Necesito tu ayuda con un proyecto.", "Hoy"),
            Chat("Santiago Muñoz", "Nos vemos en la reunión.", "Ayer"),
            Chat("Paula Sánchez", "Voy a llegar un poco tarde.", "Domingo"),
            Chat("Felipe Herrera", "Envíame el informe cuando puedas.", "Miércoles"),
            Chat("Isabel Ruiz", "Te mando los archivos en un momento.", "Jueves"),
            Chat("Camilo Cárdenas", "¿Estás disponible para una llamada?", "Viernes")
        )
        _uiState.value = ChatUIState(chats = initialChats)
    }

    fun removeChat(chat: Chat) {
        val currentList = _uiState.value?.chats ?: return
        _uiState.value = ChatUIState(chats = currentList.filter { it != chat })
    }
}
