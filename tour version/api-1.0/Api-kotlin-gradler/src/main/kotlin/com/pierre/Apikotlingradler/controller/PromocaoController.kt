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
    fun getById(@PathVariable id: Long) : ResponseEntity<Promocao?> {
       var promocao =  promocaoService.getById(id)
       var status = if (promocao == null) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(promocao, status)
    }
    
    @PostMapping()
    fun create(@RequestBody promocao: Promocao){
      promocaoService.create(promocao)
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable  id: Long){
        promocaoService.delete(id)
    }
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody promocao: Promocao){
        promocaoService.update(id, promocao)
    }
    @RequestMapping
    fun getAll(@RequestParam(required = false, defaultValue = "") localFilter: String) =
      promocaoService.searchByLocal(localFilter)
}