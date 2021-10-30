package com.example.flowapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowapp.model.Person
import com.example.flowapp.repository.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeFragmentViewModel@Inject constructor(
    private val personRepository: PersonRepository
) : ViewModel() {

    // Backing property to avoid state updates from other classes
    private val _personInfo = MutableStateFlow(Person())
    // The UI collects from this StateFlow to get its state updates
    val personInfo: StateFlow<Person> = _personInfo

    init {
        viewModelScope.launch {
            getOnePerson()
        }
    }

    private suspend fun getOnePerson() {
        _personInfo.value = personRepository.getOnePerson()
    }

}

