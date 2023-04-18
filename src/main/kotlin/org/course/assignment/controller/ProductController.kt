package org.course.assignment.controller

import org.course.assignment.model.Product
import org.course.assignment.service.ProductService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/products")
class ProductController(val productService: ProductService) {
    @GetMapping(params = ["id"] , produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fetchProduct(
        @RequestParam id: UUID
    ): Any? { return productService.getProductById(id) ?:  "No Product found with id: $id"
    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fetchAllProduct(): List<Product> {
        return productService.getAllProduct()
    }

}