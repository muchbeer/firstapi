package com.muchbeer.start.firstapi.datasource.network

import com.muchbeer.start.firstapi.datasource.FamilyDataSource
import com.muchbeer.start.firstapi.model.Family
import com.muchbeer.start.firstapi.model.FamilyList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network")
class NetworkDataSourceImpl(
    @Autowired private val restTemplate: RestTemplate
) : FamilyDataSource {


    override fun getFamilies(): Collection<Family> {
      /*  val response : ResponseEntity<FamilyList> =
            restTemplate.getForEntity("http://192.168.10.10/family")

        response.body?.results ?: throw IOException ("Could not return family from network")*/
        return emptyList()
    }

    override fun getFamily(familyName: String): Family {
        TODO("Not yet implemented")
    }

    override fun saveFamily(family: Family): Family {
        TODO("Not yet implemented")
    }

    override fun updateFamily(family: Family): Family {
        TODO("Not yet implemented")
    }

    override fun deleteFamily(familName: String) {
        TODO("Not yet implemented")
    }
}