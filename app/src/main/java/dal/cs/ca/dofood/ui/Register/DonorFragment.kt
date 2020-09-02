package dal.cs.ca.dofood.ui.Register

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dal.cs.ca.dofood.DonorActivity
import dal.cs.ca.dofood.LoginActivity

import dal.cs.ca.dofood.R
import kotlinx.android.synthetic.main.fragment_donor.*

/**
 * A simple [Fragment] subclass.
 */
class DonorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var textLoginDonar: TextView =txtGoToDonorLogin.findViewById(R.id.txtGoToDonorLogin)
        textLoginDonar.setOnClickListener {
            val intent= Intent(activity, LoginActivity::class.java)
            activity!!.startActivity(intent)
        }
        btnDonarRegister.setOnClickListener{
            //System.out.println("Donr clicked")
            var intent= Intent(activity, DonorActivity::class.java)
            startActivity(intent)

        }
    }
}
