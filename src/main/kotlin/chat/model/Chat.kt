package chat.model

data class Chat(
    val chatId: Int,
    val title: String = "",
    val commentsAmount: Int = 0,
    val chatRoot: ChatItem? = null
){
    companion object {
        fun defaultChat() = Chat(-1)
    }
}