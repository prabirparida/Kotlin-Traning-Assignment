package org.course.assignment.service

import org.course.assignment.model.Product
import org.course.assignment.repository.ProductRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Component
class ProductService(private val repository: ProductRepository) {
    fun getProductById(id: UUID): Product? {
        return repository.findByIdOrNull(id)
    }
    fun getAllProduct(): List<Product>{
        return repository.findAll()
    }
}