package org.course.assignment

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.sun.jna.platform.unix.solaris.LibKstat.KstatNamed.UNION.STR
import org.course.assignment.model.Product
import org.course.assignment.repository.ProductRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils
import java.lang.IllegalArgumentException
import java.util.*

@SpringBootApplication
@EnableMongoRepositories(basePackages = ["org.course.assignment"])
class AssignmentApplication {

    companion object{
        private val logger = LoggerFactory.getLogger(AssignmentApplication ::class.java)
        private const val FILE_PATH = "products.json"
    }

    @Bean
    fun productReader(productRepository: ProductRepository) = CommandLineRunner {
        val objectMapper = jacksonObjectMapper()
        val file = try {
            ResourceUtils.getFile("classpath:products.json")
        } catch (e: Exception) {
            logger.error("cannot find a file")
            throw e
        }

        val products: List<Product> = try {
            objectMapper.readValue(file)
        } catch (e: Exception) {
            logger.error("'$FILE_PATH' holds invalid data")
            throw IllegalStateException("'$FILE_PATH' file must be valid")
        }

        productRepository.saveAll(products)
    }

}

fun main(args: Array<String>) {
    runApplication<AssignmentApplication>(*args)
}
