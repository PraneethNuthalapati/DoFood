package dal.cs.ca.dofood.ui.CharityHome

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

import dal.cs.ca.dofood.R
import kotlinx.android.synthetic.main.vreq_list.view.*

/**
 * A simple [Fragment] subclass.
 */
class VolunteerRequestFragment : Fragment() {
    lateinit var listView:ListView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vname = arrayOf<String>(
            "Percy Peeves", "Rubeus Black",
            "Dolores Donald", "Cho Chang", "Peter Pettigrew", "Dean Thomas", "Viktor Krum",
            "Vernon Dursley"
        )
        var adapter=VReqAdapter(this.activity!!,vname)
        var view= inflater.inflate(R.layout.fragment_volunteer_request, container, false)
        listView=view.findViewById<ListView>(R.id.volunteerRequestList)
        listView.adapter=adapter
        // Inflate the layout for this fragment
        return view
    }


    inner class VReqAdapter:BaseAdapter {
        var vname= arrayOf<String>()
        var context:Context?=null

        constructor(context:Context, vname:Array<String>):super(){
            this.vname=vname
            this.context=context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val volunteer=vname[position]
            val inflater=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflater.inflate(R.layout.vreq_list,null)
            myView.tvVolunteerName.text=vname[position]
            return  myView
        }

        override fun getItem(position: Int): Any {
            return vname[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return vname.size
        }
    }
}

