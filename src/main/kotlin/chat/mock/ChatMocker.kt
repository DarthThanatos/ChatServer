package chat.mock

import chat.model.Chat
import chat.model.ChatItem
import chat.model.FileInfo
import chat.model.User

val BASE_URL = "http://192.168.0.100:8080"

class ChatMocker{
    companion object {
        fun getMockedChat(): Chat {
            val chatId = 666
            val title = "Beta HCG kto pomoże odczytać?"
            val comments = arrayListOf(getMockedResponseChildItem(chatId, 888, null), getMockedResponseChildItem(chatId, 777, null), getMockedChildlessChatItem(chatId, 444, 777), getMockedChildlessChatItem(chatId, 555, 888))
            val mockedChat = Chat(chatId, title, 1, getMockedRootChatItem(chatId), comments)
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
                fileInfos = listOf(
                    FileInfo(
                        filename = "20190517_34.jpg",
                        url = "$BASE_URL/files/Screenshot_20190826-120920.png",
                        sizeDesc = "32,73 Kb"
                    ),
                    FileInfo(
                        filename = "20190517_34.jpg",
                        url = "$BASE_URL/files/Screenshot_20190826-120920-1.png",
                        sizeDesc = "32,73 Kb"
                    ),
                    FileInfo(
                        filename = "20190517_34.jpg",
                        url = "$BASE_URL/files/Screenshot_20190826-120920-2.png",
                        sizeDesc = "32,73 Kb"
                    )
                ),
                creationTime = "2019-09-01 09:00:00"

            )

        private fun getMockedResponseChildItem(chatId: Int, chatItemId: Int, parentId: Int?): ChatItem =
            ChatItem(
                chatItemId,
                chatId,
                User(
                    56,
                    "ala34",
                    "https://www.w3schools.com/howto/img_avatar2.png"
                ),
                fileInfos = listOf(
                    FileInfo(
                        filename = "20190517_34.jpg",
                        url = "$BASE_URL/files/Screenshot_20190826-120920.png",
                        sizeDesc = "32,73 Kb"
                    ),
                    FileInfo(
                        filename = "20190517_34.jpg",
                        url = "$BASE_URL/files/Screenshot_20190826-120920-1.png",
                        sizeDesc = "32,73 Kb"
                    ),
                    FileInfo(
                        filename = "20190517_34.jpg",
                        url = "$BASE_URL/files/Screenshot_20190826-120920-2.png",
                        sizeDesc = "32,73 Kb"
                    ),
                    FileInfo(
                        filename = "20190517_34.jpg",
                        url = "$BASE_URL/files/Screenshot_20190826-120920-3.png",
                        sizeDesc = "32,73 Kb"
                    ),
                    FileInfo(
                        filename = "20190517_34.jpg",
                        url = "$BASE_URL/files/Screenshot_20190826-120920-4.png",
                        sizeDesc = "32,73 Kb"
                    )
                ),
                text = "Miedzy 4 a 6 tygodniem. Beta raczej nie określa wieku ciąży, jak widać są bardzo dużo rozbieznosci. To badanie robi się w celu potwierdzenia lub wykluczenia ciazy oraz ewentualnie sprawdza się przyrost. Proponuję udać się do lekarza na USG za jakiś tydzień.",
                creationTime = "2019-09-02 01:00:00",
                parentId = parentId,
                amountOfLikes = 40,
                likedByMe = true,
                reportedByMe = true
            )

        private fun getMockedChildlessChatItem(chatId: Int, chatItemId: Int, parentId: Int?): ChatItem =
            ChatItem(
                chatItemId,
                chatId,
                User(
                    55,
                    "robcio",
                    "https://www.w3schools.com/howto/img_avatar.png"
                ),
                text = "Witam, byłam na badaniu Beta Hcg i nie potrafię odczytać dobrze, ktoś pomoże?",
                creationTime = "2019-09-01 09:00:00",
                parentId = parentId,
                amountOfLikes = 15
            )
    }

}