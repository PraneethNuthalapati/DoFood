package dal.cs.ca.dofood.ui.Register

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import dal.cs.ca.dofood.CharityActivity

import dal.cs.ca.dofood.LoginActivity

import dal.cs.ca.dofood.R
import kotlinx.android.synthetic.main.fragment_charity.*

/**
 * A simple [Fragment] subclass.
 */
class CharityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_charity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var txtCharityLoginText: TextView =txtGoToCharityLogin.findViewById(R.id.txtGoToCharityLogin)
        txtCharityLoginText.setOnClickListener {
            val intent= Intent(activity, LoginActivity::class.java)
            activity!!.startActivity(intent)
        }

        btnCharityRegister.setOnClickListener {
            var intent=Intent(activity,CharityActivity::class.java)
            startActivity(intent)
        }


    }
}
