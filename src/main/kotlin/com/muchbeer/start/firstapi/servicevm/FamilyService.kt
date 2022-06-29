package com.muchbeer.start.firstapi.servicevm

import com.muchbeer.start.firstapi.datasource.FamilyDataSource
import com.muchbeer.start.firstapi.model.Family
import com.muchbeer.start.firstapi.model.Status
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class FamilyService(@Qualifier("localdb") private val repository : FamilyDataSource) {

    fun retrieveFamilies() : Collection<Family> = repository.getFamilies()

    fun retrieveFamily(familName : String) : Family = repository.getFamily(familName)

    fun saveFaFamily(family: Family) : Family = repository.saveFamily(family)

    fun updateFamily(family: Family) : Family = repository.updateFamily(family)

    fun deleteFamily(familName: String) : Unit = repository.deleteFamily(familName)
}