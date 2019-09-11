package chat.service

import chat.mock.ChatMocker
import chat.model.Chat
import chat.model.ChatItem
import org.springframework.stereotype.Service

interface ChatService{
    fun addItem(item: ChatItem)
    fun getChat(chatId: Int): Chat
    fun getAllChats(): List<Chat>
    fun createChat(): Chat
}

@Suppress("unused")
@Service
class ChatServiceImpl: ChatService{

    private val chats: MutableMap<Int, Chat> = mutableMapOf()

    init{
        val mockedChat = ChatMocker.getMockedChat()
        chats[mockedChat.chatId] = mockedChat
    }

    override fun addItem(item: ChatItem) {
        val chatItems = mutableListOf<ChatItem>()
        if(chats.containsKey(item.chatId)){
//            chatItems.addAll(chats[item.chatId]!!.chatItems)
        }
        else{
            println("WARNING: chat with id ${item.chatId} not found, chat item ignored")
        }
        chatItems.add(item)
    }

    override fun getChat(chatId: Int): Chat
        = chats.getOrDefault(chatId, Chat.defaultChat())

    override fun getAllChats(): List<Chat>
        = chats.values.toList()

    override fun createChat(): Chat {
        val maxKey = chats.keys.max() ?: -1
        val newKey = maxKey + 1
        val chat = Chat(newKey)
        chats[newKey] = chat
        return chat
    }

}