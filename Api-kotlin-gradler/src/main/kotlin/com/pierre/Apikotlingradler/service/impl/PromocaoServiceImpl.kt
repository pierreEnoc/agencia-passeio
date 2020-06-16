package com.pierre.Apikotlingradler.service.impl

import com.pierre.Apikotlingradler.model.Promocao
import com.pierre.Apikotlingradler.repository.PromocaoRepository
import com.pierre.Apikotlingradler.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class PromocaoServiceImpl( val promocaoRepository: PromocaoRepository) : PromocaoService {
    
    override fun create(promocao: Promocao) {
        promocaoRepository.save(promocao)
    }
    
    
    override fun getById(id: Long): Promocao? {
        return promocaoRepository.findById(id).orElseGet(null)
    }
    
    override fun delete(id: Long) {
        promocaoRepository.deleteById(id)
    }
    
    override fun update(id: Long, promocao: Promocao) {
        create(promocao)
    }
    
    override fun searchByLocal(local: String): List<Promocao> =
            listOf()
    
    override fun getAll(start: Int, size : Int): List<Promocao> {
       val pages:Pageable = PageRequest.of(start, size)
        return promocaoRepository.findAll(pages).toList()
    }
    
    override fun count(): Long =
        promocaoRepository.count()
}