package com.muchbeer.start.firstapi.datasource

import com.muchbeer.start.firstapi.model.Family
import com.muchbeer.start.firstapi.model.Status

interface FamilyDataSource {

    fun getFamilies() : Collection<Family>

    fun getFamily(familyName : String) : Family

    fun saveFamily(family: Family) : Family

    fun updateFamily(family: Family) : Family

    fun deleteFamily(familName: String)
}