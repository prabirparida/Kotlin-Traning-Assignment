package org.course.assignment.model

import org.springframework.stereotype.Component


data class Bill(
    var totalItems: Int = 0,
    var totalPrice: Double = 0.0
)