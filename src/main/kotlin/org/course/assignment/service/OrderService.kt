package org.course.assignment.service

import org.course.assignment.model.Bill
import org.course.assignment.model.Item
import org.course.assignment.repository.OrderRepository
import org.springframework.stereotype.Component

@Component
class OrderService(
    val orderRepository: OrderRepository
) {
    fun calculateBill(items: List<Item>): Bill? {
        return orderRepository.getCalculateBill(items)
    }
}