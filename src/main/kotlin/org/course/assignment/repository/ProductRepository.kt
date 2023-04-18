package org.course.assignment.repository

import org.course.assignment.model.Product
import org.course.assignment.model.Products
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepository: MongoRepository<Product, UUID> {
    fun save(product: Product): Product
    override fun findAll(): List<Product>
}