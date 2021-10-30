package com.example.flowapp.repository

import com.example.flowapp.model.Person
import com.example.flowapp.service.PersonService
import javax.inject.Inject

class PersonRepository @Inject constructor (private val personService: PersonService) {

    suspend fun getOnePerson() : Person = personService.getOnePerson()
}