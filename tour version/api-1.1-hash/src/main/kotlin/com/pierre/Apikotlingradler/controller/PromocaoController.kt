package com.pierre.Apikotlingradler.controller

import com.pierre.Apikotlingradler.model.Promocao
import com.pierre.Apikotlingradler.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["/promocoes"])
class PromocaoController {
    @Autowired
    lateinit var promocaoService: PromocaoService
    
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Promocao?> {
        var promocao = promocaoService.getById(id)
        var status = if (promocao == null) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(promocao, status)
    }
    
    @PostMapping()
    fun create(@RequestBody promocao: Promocao): ResponseEntity<Any> {
        promocaoService.create(promocao)
        return ResponseEntity(Unit, HttpStatus.CREATED)
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
    fun getAll(@RequestParam(required = false, defaultValue = "") localFilter: String): ResponseEntity<List<Promocao>> {
        var status = HttpStatus.OK
        val listaPromocoes = promocaoService.searchByLocal(localFilter)
        if (listaPromocoes.size == 0) {
            status = HttpStatus.NOT_FOUND
        }
        return ResponseEntity(listaPromocoes, status)
    }
    
}