package chat.controller

import chat.model.FileInfo
import chat.service.FileStorage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@Suppress("unused")
@RestController
class UploadFileController{

    @Autowired
    private lateinit var fileStorage: FileStorage

    @PostMapping("/files/new")
    fun uploadMultipartFile(@RequestParam("file") file: MultipartFile) : FileInfo{
    	println("uploaded file: $file")
        try{
            fileStorage.store(file)
        }catch(e: Exception){
            e.printStackTrace()
        }
        return FileInfo("yolo.png", "32 kb", "http://192.168.0.73:8080/files/Screenshot_20190826-120920.png")
    }

    @PostMapping ("/files/new/url")
    fun uploadUrl(@RequestBody url: String): FileInfo{
        return FileInfo("yolo.png", "32 kb", "http://192.168.0.73:8080/files/Screenshot_20190826-120920.png")
    }
}