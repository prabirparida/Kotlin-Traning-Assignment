package org.course.assignment.repository

import org.course.assignment.model.Bill
import org.course.assignment.model.Item
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.util.*

@Component
@Repository
class OrderRepository(
    val productRepository: ProductRepository
) {
    companion object{
        lateinit var bill: Bill
    }

    fun getCalculateBill(items: List<Item>): Bill? {
        val productIds = items.map { it.id }
        val products = productRepository.findAllById(productIds)
        val finalId = products.map { it.id }
        val sortItem = items.filter { it.id in finalId }.sortedBy { it.id }
        val sortProduct = products.filter { it.id in finalId }.sortedBy { it.id }
        bill.totalItems = 0
        bill.totalPrice = 0.0
        for (i in 0..finalId.size){
            if(sortItem[i].quantity < sortProduct[i].quantity){
                bill.totalItems += sortItem[i].quantity
                bill.totalPrice += (sortItem[i].quantity * sortProduct[i].price)
            }
        }
        return bill
    }
}