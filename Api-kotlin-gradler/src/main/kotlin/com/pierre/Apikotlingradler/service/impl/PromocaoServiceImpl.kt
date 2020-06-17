package com.pierre.Apikotlingradler.service.impl

import com.pierre.Apikotlingradler.model.Promocao
import com.pierre.Apikotlingradler.repository.PromocaoRepository
import com.pierre.Apikotlingradler.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class PromocaoServiceImpl( val promocaoRepository: PromocaoRepository) : PromocaoService {
    
    override fun create(promocao: Promocao) {
        promocaoRepository.save(promocao)
    }
    
    
    override fun getById(id: Long): Promocao? {
        return promocaoRepository.findByIdOrNull(id)
    }
    
    override fun delete(id: Long) {
        promocaoRepository.deleteById(id)
    }
    
    override fun update(id: Long, promocao: Promocao) {
        create(promocao)
    }
    
    override fun searchByLocal(local: String): List<Promocao> =
            listOf()
    
    override fun findAll(pageable: Pageable): Page<Promocao> {
        //fun  (pageable: Pageable): Page<Promocao?> {
            return promocaoRepository.findAll(pageable)
       // }
    }
    
    
    // override fun getAll(start: Int, size : Int): List<Promocao> {
      // val pages:Pageable = PageRequest.of(start, size, Sort.by("local").ascending())
      //  return promocaoRepository.findAll(pages).toList()
   // }
    
    override fun count(): Long =
        promocaoRepository.count()
    
    override fun getAllSortedByLocal(): List<Promocao> =
        promocaoRepository.findAll(Sort.by("local").descending()).toList()
    
}