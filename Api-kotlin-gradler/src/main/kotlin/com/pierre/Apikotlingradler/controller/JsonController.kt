package com.pierre.Apikotlingradler.controller

import com.pierre.Apikotlingradler.model.Cliente
import com.pierre.Apikotlingradler.model.SimpleObject
import com.pierre.Apikotlingradler.model.Telefone
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class JsonController {
    
    @GetMapping("/json")
    fun getJson() = SimpleObject()
    
    @GetMapping("/cliente")
    fun getTelefone(): Cliente{
        var telefone = Telefone("11","949948474", "fixo")
        var cliente = Cliente(1,"pierre", Date(),telefone)
        return cliente
    }
   
    
}