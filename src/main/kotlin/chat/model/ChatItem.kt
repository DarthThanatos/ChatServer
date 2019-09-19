package chat.model

data class ChatItem(
    var chatItemId: Int?,
    val chatId: Int,
    var user: User?,
    val text: String = "",
    val creationTime: String,
    var likedByMe: Boolean = false,
    var amountOfLikes: Int = 0,
    var reportedByMe: Boolean = false,
    val fileInfos: List<FileInfo> = listOf(),
    val parentId: Int? = null
)