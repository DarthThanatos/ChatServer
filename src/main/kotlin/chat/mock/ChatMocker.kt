package chat.mock

import chat.model.Chat
import chat.model.ChatItem
import chat.model.User

class ChatMocker{
    companion object {
        fun getMockedChat(): Chat {
            val chatItemId = 333
            val chatId = 666
            val mockedChat = Chat(chatId)
            mockedChat.chatItems.add(
                ChatItem(
                    chatItemId,
                    chatId,
                    User(
                        55,
                        "robcio",
                        "testUrl"
                    ),
                    text = "init")
            )
            return mockedChat
        }
    }
}