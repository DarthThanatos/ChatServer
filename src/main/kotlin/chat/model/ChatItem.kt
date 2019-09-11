package chat.model

import java.time.LocalDate

data class ChatItem(
    val chatItemId: Int,
    val chatId: Int,
    val user: User,
    val text: String = "",
    val creationTime: String,
    val fileInfo: FileInfo? = null,
    val children: List<ChatItem>? = null
)