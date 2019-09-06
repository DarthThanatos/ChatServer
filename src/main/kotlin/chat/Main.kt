package chat

import chat.service.FileStorage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@Suppress("unused")
@SpringBootApplication
class Application{

    @Autowired
    private lateinit var fileStorage: FileStorage

    @Bean
    fun run() = CommandLineRunner{
        fileStorage.deleteAll()
        fileStorage.init()
    }
}


fun main(args: Array<String>){
    SpringApplication.run(Application::class.java, *args)
}
