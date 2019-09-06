package chat.controller

import chat.model.Chat
import chat.model.ChatItem
import chat.service.ChatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Suppress("unused")
@RestController
class ChatController{

    @Autowired
    private lateinit var chatService: ChatService

    @PostMapping("/chat")
    fun postChatItem(@RequestBody chatItem: ChatItem){
        chatService.addItem(chatItem)
    }

    @GetMapping("/chat/{chatId}")
    fun getChat(@PathVariable("chatId") chatId: Int): List<ChatItem>
        = chatService.getChat(chatId)

    @PostMapping("/chat/new")
    fun newChat(): Chat = chatService.createChat()

    @GetMapping("/chat")
    fun getAllChats(): List<Chat> = chatService.getAllChats()

    @GetMapping("/chat/int")
    fun getTestInt(): Int = 77

    @GetMapping("/chat/int-list")
    fun getTestIntList(): List<Int> = listOf(55,66)

}