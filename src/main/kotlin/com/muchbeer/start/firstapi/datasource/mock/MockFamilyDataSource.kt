package com.muchbeer.start.firstapi.datasource.mock

import com.muchbeer.start.firstapi.datasource.FamilyDataSource
import com.muchbeer.start.firstapi.model.Family
import com.muchbeer.start.firstapi.model.Status
import org.springframework.stereotype.Repository

@Repository("localdb")
class MockFamilyDataSource : FamilyDataSource {

    val families = mutableListOf(Family("Muchbeer", "5", "RC"),
        Family("Sanyiwa", "3", "Christian"),
        Family("Ghalib", "4", "Muslim"))


    override fun getFamilies(): Collection<Family> = families


    override fun getFamily(familyName: String): Family {
       return families.firstOrNull {
           it.family_name == familyName
       } ?: throw NoSuchElementException("Could not find the family $familyName ")
    }

    override fun saveFamily(family: Family): Family {

      if (families.any { it.family_name == family.family_name  })  {
          throw IllegalArgumentException("Family ${family.family_name}  already exist")    }

        families.add(family)

        return family
    }

    override fun updateFamily(family: Family): Family {
        val currentFamily = families.firstOrNull{
            it.family_name == family.family_name
        } ?: throw NoSuchElementException("No family ${family.family_name} exist")

        families.remove(currentFamily)
        families.add(family)
        return family     }

    override fun deleteFamily(familyName: String) {
       val currentFamily = families.firstOrNull {
           it.family_name == familyName   } ?: throw NoSuchElementException("No such family")

        families.remove(currentFamily)
    }
}