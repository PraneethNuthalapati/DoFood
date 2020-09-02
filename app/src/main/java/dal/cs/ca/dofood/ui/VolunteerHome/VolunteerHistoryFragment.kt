package dal.cs.ca.dofood.ui.VolunteerHome

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView

import dal.cs.ca.dofood.R
import dal.cs.ca.dofood.ui.Classes.History
import kotlinx.android.synthetic.main.volunteer_history.view.*

/**
 * A simple [Fragment] subclass.
 */
class VolunteerHistoryFragment : Fragment() {
    lateinit var listView: ListView
    var History = ArrayList<History>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        History.add(History("Canada Helps", "Food Transporter", "20", R.drawable.canada_help, "2020-01 to 2020-02"))
        History.add(History("World Vision", "Serving Food", "50", R.drawable.world_vision,"2019-08 to 2019-06"))
        History.add(History("Canada Helps", "Food Transporter", "30", R.drawable.canada_help, "2018-03 to 2018-05"))
        // Inflate the layout for this fragment
        var adapter=HistoryAdapter(this.context!!,History)
        var view= inflater.inflate(R.layout.fragment_volunteer_history, container, false)
        listView=view.findViewById<ListView>(R.id.list_history)
        listView.adapter=adapter
        return view

    }
    inner class HistoryAdapter: BaseAdapter {
        var History =ArrayList<History>()
        var context: Context?=null
        constructor(context: Context, History : ArrayList<History>):super() {
            this.History = History
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val History = History[position]
            var inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflater.inflate(R.layout.volunteer_history,null)
            myView.txt_view_name.text = History.name!!
            myView.txt_view_job_value.text = History.jobPosition!!
            myView.txt_hoursWorked_value.text = History.hoursWorked!!
            myView.img_view.setImageResource(History.image!!)
            myView.txt_timeFrame_value.text = History.timeFrame!!

            return myView
        }

        override fun getItem(position: Int): Any {
            return History[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return History.size
        }
    }

}
