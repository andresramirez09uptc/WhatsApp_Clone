package com.example.whatsapp_clone

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chatListContainer: LinearLayout = findViewById(R.id.chatListContainer)

        val fakeChats = listOf(
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

        for ((index, chat) in fakeChats.withIndex()) {
            val chatView = layoutInflater.inflate(R.layout.chat_item, null) as LinearLayout

            val profileImage: ImageView = chatView.findViewById(R.id.profileImage)
            val contactName: TextView = chatView.findViewById(R.id.contactName)
            val lastMessage: TextView = chatView.findViewById(R.id.lastMessage)
            val messageTime: TextView = chatView.findViewById(R.id.messageTime)

            // Alternar entre dos imágenes de perfil
            if (index % 2 == 0) {
                profileImage.setImageResource(R.drawable.ic_profile)
            } else {
                profileImage.setImageResource(R.drawable.ic_profile_woman)
            }

            contactName.text = chat.name
            lastMessage.text = chat.message
            messageTime.text = chat.time

            chatListContainer.addView(chatView)
        }
    }
}

data class Chat(val name: String, val message: String, val time: String)
