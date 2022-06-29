package com.muchbeer.start.firstapi.controller

import com.muchbeer.start.firstapi.model.Family
import com.muchbeer.start.firstapi.model.Status
import com.muchbeer.start.firstapi.servicevm.FamilyService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/family")
class FamilyController(private val service : FamilyService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun noElementFound(ex : NoSuchElementException) : ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)     }

    @ExceptionHandler(java.lang.IllegalArgumentException::class)
    fun handleBadRequest(ex : IllegalArgumentException) : ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)    }

    @GetMapping
    fun retrieveFamilies() : Collection<Family> = service.retrieveFamilies()

    @GetMapping("/{famName}")
    fun retrieveFamily(@PathVariable famName : String) = service.retrieveFamily(famName)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveFamily(@RequestBody family: Family) : Family = service.saveFaFamily(family)

    @PatchMapping
    fun updateFamily(@RequestBody family: Family) : Family = service.updateFamily(family)

    @DeleteMapping("/{familName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteFamily(@PathVariable familName: String) : Unit = service.deleteFamily(familName)
}