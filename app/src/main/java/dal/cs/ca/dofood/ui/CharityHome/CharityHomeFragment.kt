package dal.cs.ca.dofood.ui.CharityHome

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import dal.cs.ca.dofood.CharityFeedback
import dal.cs.ca.dofood.CharityRequestVolunteer

import dal.cs.ca.dofood.R
import dal.cs.ca.dofood.ui.Classes.PastDonor
import kotlinx.android.synthetic.main.app_bar_charity.*
import kotlinx.android.synthetic.main.charity_history.view.*

/**
 * A simple [Fragment] subclass.
 */
class CharityHomeFragment : Fragment() {

    var listOfPastDonor=ArrayList<PastDonor>()
    lateinit var listView: ListView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listOfPastDonor.add(
            PastDonor("Joshua Kent",R.drawable.d1,"Rock Bottom","Nova Food")
        )
        listOfPastDonor.add(
            PastDonor("Martha Latham",R.drawable.d2,"Lower Sackville","Hill nation")
        )
        listOfPastDonor.add(
            PastDonor("Susan Gomes",R.drawable.d3,"Spring Garden Road","Fish Got Mad!")
        )
        listOfPastDonor.add(
            PastDonor("Peter Haltner",R.drawable.d4,"Lacewood Terminal","The Peanut")
        )

        var adapter=PastDonorAdaptor(this.context!!,listOfPastDonor)
        var view= inflater.inflate(R.layout.app_bar_charity, container, false)
        listView=view.findViewById<ListView>(R.id.view_charity_list)
        listView.adapter=adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabAddVolunteer.setOnClickListener {
            val intent=Intent(activity, CharityRequestVolunteer::class.java)
            activity!!.startActivity(intent)
        }
    }
    inner class PastDonorAdaptor: BaseAdapter {
        var listOfPastDonor= ArrayList<PastDonor>()
        var context: Context?=null
        constructor(context: Context, listOfPastDonor: ArrayList<PastDonor>):super(){
            this.listOfPastDonor=listOfPastDonor
            this.context=context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val PastDonor=listOfPastDonor[position]
            var inflator= context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var view= inflator.inflate(R.layout.charity_history,null)
            view.charityName.text=PastDonor.donor_name!!
            view.date_of_donation.text=PastDonor.Area!!
            view.feedback_obtained.text=PastDonor.Restaurant_Name!!
            view.charityImage.setImageResource(PastDonor.image!!)
            view.setOnClickListener{
                var intent=Intent(activity,CharityFeedback::class.java)
                activity!!.startActivity(intent)
            }
            return view
        }

        override fun getItem(position: Int): Any {
            return position.toLong()
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfPastDonor.size
        }

    }
}
