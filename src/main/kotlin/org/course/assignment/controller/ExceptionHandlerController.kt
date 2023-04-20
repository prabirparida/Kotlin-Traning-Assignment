package org.course.assignment.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
class ExceptionHandlerController : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [ProductNotFoundException::class])
    fun handleUnknownProductIdException(e: ProductNotFoundException) = ResponseEntity
        .status(HttpStatus.NOT_FOUND).body(e.message)

}

// TODO give the exception a nice message
class ProductNotFoundException(id: UUID): Exception("No Product found with id: $id") {

}
