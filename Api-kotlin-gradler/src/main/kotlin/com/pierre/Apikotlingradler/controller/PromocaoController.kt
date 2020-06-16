package com.pierre.Apikotlingradler.controller

import com.pierre.Apikotlingradler.exception.PromocaoNotFoundException
import com.pierre.Apikotlingradler.model.ErrorMessage
import com.pierre.Apikotlingradler.model.Promocao
import com.pierre.Apikotlingradler.model.RespostaJson
import com.pierre.Apikotlingradler.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping(value = ["/promocoes"])
class PromocaoController {
    @Autowired
    lateinit var promocaoService: PromocaoService
    
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Any> {
        var promocao = promocaoService.getById(id)
        return if (promocao != null)
            return ResponseEntity(promocao, HttpStatus.OK)
        else
            return ResponseEntity(ErrorMessage("Promocao Nao Localizado", "promocao ${id} nao localizada"), HttpStatus.NOT_FOUND)
        
    }
    
    @PostMapping()
    fun create(@RequestBody promocao: Promocao): ResponseEntity<RespostaJson> {
        promocaoService.create(promocao)
        val respostaJson = RespostaJson("Created", Date())
        return ResponseEntity(respostaJson, HttpStatus.CREATED)
    }
    
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        var status = HttpStatus.NOT_FOUND
        if (promocaoService.getById(id) != null) {
            status = HttpStatus.ACCEPTED
            promocaoService.delete(id)
        }
        return ResponseEntity(Unit, status)
    }
    
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody promocao: Promocao): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if (promocaoService.getById(id) != null) {
            promocaoService.update(id, promocao)
            status = HttpStatus.ACCEPTED
        }
        return ResponseEntity(Unit, status)
    }
    
    @RequestMapping
    fun getAll(@RequestParam(required = false, defaultValue = "0") start: Int,
               @RequestParam(required = false, defaultValue = "3") size: Int): ResponseEntity<List<Promocao>> {
        
        val list = promocaoService.getAll(start, size)
        val status = if (list.size == 0) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(list, status)
    }
    
    @GetMapping("/count")
    fun count(): ResponseEntity<Map<String, Long>> =
            ResponseEntity.ok().body(mapOf("count" to promocaoService.count()))
    
}