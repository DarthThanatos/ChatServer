package chat.model

data class ChatItem(
    val chatItemId: Int,
    val chatId: Int,
    val user: User,
    val text: String = "",
    val creationTime: String,
    val fileInfos: List<FileInfo> = listOf(),
    val children: List<ChatItem>? = null
)