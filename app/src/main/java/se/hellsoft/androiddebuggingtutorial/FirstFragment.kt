package se.hellsoft.androiddebuggingtutorial


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {
  var viewModel: PersonViewModel? = null

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    viewModel = ViewModelProviders.of(activity).get(PersonViewModel::class.java)
    return inflater!!.inflate(R.layout.fragment_first, container, false)
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    next.setOnClickListener {
      val person = viewModel!!.person
      val pName = name.text.toString()
      val pAge = Integer.parseInt(age.text.toString())

      viewModel!!.person = person!!.copy(name = pName, age = pAge)

      fragmentManager
          .beginTransaction()
          .replace(R.id.container, SecondFragment())
          .addToBackStack(null)
          .commit()
    }
  }
}
