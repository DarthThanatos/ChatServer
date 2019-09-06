package chat.model

data class ChatItem(
    val chatItemId: Int,
    val chatId: Int,
    val user: User,
    val text: String,
    val fileInfo: FileInfo? = null
)