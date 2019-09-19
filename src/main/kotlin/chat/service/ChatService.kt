package chat.service

import chat.mock.ChatMocker
import chat.model.Chat
import chat.model.ChatItem
import chat.model.User
import org.springframework.stereotype.Service
import kotlin.random.Random

interface ChatService{
    fun addItem(item: ChatItem): ChatItem?
    fun getChat(chatId: Int): Chat
    fun getAllChats(): List<Chat>
    fun createChat(): Chat
    fun likeCommentItem(item: ChatItem): ChatItem?
    fun reportChatItem(item: ChatItem): ChatItem?
}

@Suppress("unused")
@Service
class ChatServiceImpl: ChatService{

    private val chats: MutableMap<Int, Chat> = mutableMapOf()

    init{
        val mockedChat = ChatMocker.getMockedChat()
        chats[mockedChat.chatId] = mockedChat
    }

    override fun addItem(item: ChatItem): ChatItem?{
        item.chatItemId = Random.nextInt()
        item.user = User(Random.nextInt(), "anonim", "https://www.w3schools.com/howto/img_avatar.png")
        println(item)
        if(chats.containsKey(item.chatId)){
            chats[item.chatId]!!.comments.add(item)
            return item
        }
        println("WARNING: chat with id ${item.chatId} not found, chat item ignored")
        return null
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

    override fun likeCommentItem(item: ChatItem): ChatItem? {
        if(chats.containsKey(item.chatId)){
            return chats[item.chatId]!!.comments.find { it.chatItemId == item.chatItemId }!!
                .apply { likedByMe = true; amountOfLikes += 1 }
        }
        println("WARNING: chat with id ${item.chatId} not found, chat item ignored")
        return null
    }

    override fun reportChatItem(item: ChatItem): ChatItem? {
        if(chats.containsKey(item.chatId)){
            return chats[item.chatId]!!.comments.find { it.chatItemId == item.chatItemId }!!.apply { reportedByMe = true }
        }
        println("WARNING: chat with id ${item.chatId} not found, chat item ignored")
        return null
    }
}