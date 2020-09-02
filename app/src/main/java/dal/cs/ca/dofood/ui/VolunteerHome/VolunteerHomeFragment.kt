package dal.cs.ca.dofood.ui.VolunteerHome

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView

import dal.cs.ca.dofood.R
import dal.cs.ca.dofood.VolunteerEnroll
import dal.cs.ca.dofood.ui.Classes.CharityRequests
import kotlinx.android.synthetic.main.volunteer_charity_request.view.*

/**
 * A simple [Fragment] subclass.
 */
class VolunteerHomeFragment : Fragment() {
    var charityRequests = ArrayList<CharityRequests>()
    lateinit var listView: ListView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        charityRequests.add(
            CharityRequests("Canada Helps",
                "Food Transportation",
                "Food Drivers transport food items from donors areas to charity location. This " +
                "Job requires a DL level of 5. ",
                R.drawable.canada_help,
                "20", "5" ))
        charityRequests.add(
            CharityRequests("Canadian Red Cross",
                "Serving Food",
                "Any place with food has a food server. Food servers perform a variety of tasks, from preparing the food, stocking supplies," +
                " serving, cleaning tables and counters, resetting tables, greeting customers and answering questions. ",
                R.drawable.canadian_red_cross,
                "25", "3" ))
        charityRequests.add(
            CharityRequests("World Vision",
                "Food Transportation",
                "Food Drivers transport food items from donors areas to charity location. This " +
                "Job requires a DL level of 5. ",
                R.drawable.world_vision,
                "30", "3" ))

        var adapter=charityRequestsAdapter(this.context!!,charityRequests)
        var view= inflater.inflate(R.layout.app_bar_volunteer, container, false)
        listView=view.findViewById<ListView>(R.id.list_volunteer)
        listView.adapter=adapter
        return view
    }


    inner class charityRequestsAdapter: BaseAdapter {
        var charityRequests = ArrayList<CharityRequests>()
        var context: Context?=null
        constructor(context: Context, charityRequests: ArrayList<CharityRequests>):super() {
            this.charityRequests = charityRequests
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val charity = charityRequests[position]
            var inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflater.inflate(R.layout.volunteer_charity_request,null)
            myView.txt_view_name.text = charity.name!!
            myView.txt_view_job_value.text = charity.jobRole!!
            myView.img_view.setImageResource(charity.image!!)
            myView.txt_max_hours_value.text = charity.maxHours!!
            myView.txt_min_hours_value.text = charity.minHours!!
            myView.linear_1.setOnClickListener{
                val intent = Intent(context, VolunteerEnroll::class.java)
                intent.putExtra("name",charity.name!!)
                intent.putExtra( "desc", charity.desc!!)
                intent.putExtra("image", charity.image!!)
                intent.putExtra("jobRole", charity.jobRole!!)
                intent.putExtra("maxHours", charity.maxHours!!)
                intent.putExtra("minHours", charity.minHours!!)
                context!!.startActivity(intent)
            }
            return myView
        }

        override fun getItem(position: Int): Any {
            return charityRequests[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }


        override fun getCount(): Int {
            return charityRequests.size
        }

    }
}
