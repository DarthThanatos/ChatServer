package chat.model

data class Chat(
    val chatId: Int,
    val chatItems: MutableList<ChatItem> = mutableListOf()
){
    companion object {
        fun defaultChat() = Chat(-1)
    }
}