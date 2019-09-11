package chat.controller

import chat.service.FileStorage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@Suppress("unused")
@RestController
class UploadFileController{

    @Autowired
    private lateinit var fileStorage: FileStorage

    @PostMapping("/files/new")
    fun uploadMultipartFile(@RequestParam("file") file: MultipartFile){
    	println("uploaded file: $file")
        fileStorage.store(file)
    }
}