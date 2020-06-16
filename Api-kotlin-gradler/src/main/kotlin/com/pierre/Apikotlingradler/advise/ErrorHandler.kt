package com.pierre.Apikotlingradler.advise

import com.pierre.Apikotlingradler.exception.PromocaoNotFoundException
import com.pierre.Apikotlingradler.model.ErrorMessage
import org.springframework.boot.json.JsonParseException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(JsonParseException::class)
    fun JsonParseExceptionHandler(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse, exception: Exception):
            ResponseEntity<ErrorMessage> {
        
       return ResponseEntity(ErrorMessage("Json Error", exception.message ?: "invalid json"),HttpStatus.BAD_REQUEST)
    }
    
    @ExceptionHandler(PromocaoNotFoundException::class)
     fun PromocaoNotFoundExceptionHandler(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse, exception: Exception): ResponseEntity<ErrorMessage>{
         return ResponseEntity(ErrorMessage("Promocao nao localizada",exception.message !!), HttpStatus.NOT_FOUND)
         
     }
    
}