package se.hellsoft.androiddebuggingtutorial

import android.arch.lifecycle.ViewModel

data class Person(val name: String, val age: Int)

class PersonViewModel : ViewModel() {
  var person: Person? = null
}