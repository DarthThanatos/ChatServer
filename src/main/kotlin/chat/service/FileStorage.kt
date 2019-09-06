package chat.service

import org.springframework.core.io.Resource
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Path
import java.util.stream.Stream

import java.nio.file.Files
import java.nio.file.Paths

import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import org.springframework.util.FileSystemUtils

interface FileStorage {
    fun store(file: MultipartFile)
    fun loadFile(filename: String): Resource
    fun deleteAll()
    fun init()
    fun loadFiles(): Stream<Path>
}

@Suppress("unused")
@Service
class FileStorageImpl: FileStorage{

    private val rootLocation: Path = Paths.get("filestorage")

    override fun store(file: MultipartFile){
        Files.copy(
            file.inputStream,
            this.rootLocation.resolve(file.originalFilename)
        )
    }

    override fun loadFile(filename: String): Resource{
        val file = rootLocation.resolve(filename)
        val resource = UrlResource(file.toUri())

        if(resource.exists() || resource.isReadable) {
            return resource
        }else{
            throw RuntimeException("FAIL!")
        }
    }

    override fun deleteAll(){
        FileSystemUtils.deleteRecursively(rootLocation.toFile())
    }

    override fun init(){
        Files.createDirectory(rootLocation)
    }

    override fun loadFiles(): Stream<Path>{
        return Files.walk(this.rootLocation, 1)
            .filter{path -> path != this.rootLocation }
            .map(this.rootLocation::relativize)
    }
}