package org.course.assignment.repository

import org.course.assignment.model.Bill
import org.course.assignment.model.Item
import org.course.assignment.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class OrderRepository @Autowired constructor(
    val productRepository: ProductRepository,
    val productService: ProductService
) {


    fun getCalculateBill(items: List<Item>): Bill? {
        val productIds = items.map { it.id }
        val products = productRepository.findAllById(productIds)
        val finalId = products.map { it.id }
        val sortItem = items.filter { it.id in finalId }.sortedBy { it.id }
        val sortProduct = products.filter { it.id in finalId }.sortedBy { it.id }
        var bill: Bill = Bill()
        bill.totalItems = 0
        bill.totalPrice = 0.0
        for (i in 0 until finalId.size - 1) {
            if (sortItem[i].quantity < sortProduct[i].quantity) {
                bill.totalItems += sortItem[i].quantity
                bill.totalPrice += (sortItem[i].quantity * sortProduct[i].price)
            }
        }
        return bill
// return null
    }
}
