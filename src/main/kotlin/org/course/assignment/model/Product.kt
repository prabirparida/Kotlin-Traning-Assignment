package org.course.assignment.model

import java.util.UUID

data class Product(
        val id: UUID,
        val name: String,
        val imageUrl: String,
        val price: Double,
        val quantity: Int
)
