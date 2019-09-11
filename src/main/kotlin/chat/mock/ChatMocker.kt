package chat.mock

import chat.model.Chat
import chat.model.ChatItem
import chat.model.FileInfo
import chat.model.User

class ChatMocker{
    companion object {
        fun getMockedChat(): Chat {
            val chatId = 666
            val title = "Beta HCG kto pomoże odczytać?"
            val mockedChat = Chat(chatId, title, 1, getMockedRootChatItem(chatId))
            return mockedChat
        }

        private fun getMockedRootChatItem(chatId: Int): ChatItem =
            ChatItem(
                333,
                chatId,
                User(
                    55,
                    "robcio",
                    "https://www.w3schools.com/howto/img_avatar.png"
                ),
                text = "Witam, byłam na badaniu Beta Hcg i nie potrafię odczytać dobrze, ktoś pomoże?",
                fileInfo = FileInfo(
                    filename = "20190517_34.jpg",
                    url = "http://192.168.0.73:8080/files/Screenshot_20190826-120920.png",
                    sizeDesc = "32,73 Kb"
                ),
                child = getMockedResponseChildItem(chatId),
                creationTime = "2019-09-01 09:00:00"

            )

        private fun getMockedResponseChildItem(chatId: Int): ChatItem =
            ChatItem(
                555,
                chatId,
                User(
                    56,
                    "ala34",
                    "https://www.w3schools.com/howto/img_avatar2.png"
                ),
                text = "Miedzy 4 a 6 tygodniem. Beta raczej nie określa wieku ciąży, jak widać są bardzo dużo rozbieznosci. To badanie robi się w celu potwierdzenia lub wykluczenia ciazy oraz ewentualnie sprawdza się przyrost. Proponuję udać się do lekarza na USG za jakiś tydzień.",
                creationTime = "2019-09-02 01:00:00"
            )


    }

}