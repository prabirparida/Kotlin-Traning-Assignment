package org.course.assignment.controller

import org.course.assignment.model.Bill
import org.course.assignment.model.Item
import org.course.assignment.model.Items
import org.course.assignment.service.OrderService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(val orderService: OrderService) {
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun getOrder(
        @RequestBody items: Items
    ): Bill? {
        return orderService.calculateBill(items.items)
    }
}