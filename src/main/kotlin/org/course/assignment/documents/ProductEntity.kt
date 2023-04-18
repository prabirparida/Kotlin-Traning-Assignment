package org.course.assignment.documents

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document("Product")
data class ProductEntity(
        @Id
        val id: UUID,
        val name: String,
        val imageUrl: String,
        val price: Double,
        val quantity: Int
)
