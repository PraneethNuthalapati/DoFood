package dal.cs.ca.dofood.ui.Register

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import dal.cs.ca.dofood.LoginActivity

import dal.cs.ca.dofood.R

import dal.cs.ca.dofood.VolunteerActivity

import kotlinx.android.synthetic.main.fragment_volunteer.*

/**
 * A simple [Fragment] subclass.
 */
class VolunteerFragment : Fragment() {
    lateinit var emailAddress: EditText
    lateinit var volunteerName: EditText
    lateinit var password: EditText
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_volunteer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var volunteerLoginText: TextView =
            tvGoToVolunteerLogin.findViewById(R.id.tvGoToVolunteerLogin)

        volunteerLoginText.setOnClickListener {
            var intent = Intent(activity, LoginActivity::class.java)
            activity!!.startActivity(intent)
        }
        volunteerName = etUserNameV.findViewById(R.id.etUserNameV)
        emailAddress = etEmailV.findViewById(R.id.etEmailV)
        password = etPasswordV.findViewById(R.id.etPasswordV)

        btnVolunteerRegister.setOnClickListener {
            var intent=Intent(activity,VolunteerActivity::class.java)
            activity!!.startActivity(intent)
        }

//        var btnvolunteer: Button = btnVolunteerRegister.findViewById(R.id.btnVolunteerRegister)
    }
}
