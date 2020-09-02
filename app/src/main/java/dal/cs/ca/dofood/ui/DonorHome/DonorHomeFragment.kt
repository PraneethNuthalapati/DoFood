package dal.cs.ca.dofood.ui.DonorHome

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import dal.cs.ca.dofood.DonorCharityActivity

import dal.cs.ca.dofood.R
import dal.cs.ca.dofood.ui.Classes.Charity
import kotlinx.android.synthetic.main.charity_requests.view.*

/**
 * A simple [Fragment] subclass.
 */
class DonorHomeFragment : Fragment() {

    var listOfCharity = ArrayList<Charity>()
    lateinit var listView: ListView
    var adapter:CharityRequestAdapter? =null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        listOfCharity.add(
            Charity(
                "World_Vision",
                "It is one of the best charity of Canada",
                R.drawable.world_vision
            )
        )

        listOfCharity.add(
            Charity(
                "Canada_Help",
                "Canada will help",
                R.drawable.canada_help
            )
        )

        listOfCharity.add(
            Charity(
                "Canadian Red Cross",
                "The Canadian Red Cross Society is a Canadian humanitarian charitable organization, and one of 190 national Red Cross and Red Crescent societies. The organization receives funding from both private donations and from Canadian government departments.",
                R.drawable.canadian_red_cross
            )
        )

        var adapter=CharityRequestAdapter(this.context!!,listOfCharity)

        var view= inflater.inflate(R.layout.app_bar_donor, container, false)

        listView=view.findViewById<ListView>(R.id.list_charity)

        listView.adapter=adapter
        return view
    }


    inner class CharityRequestAdapter: BaseAdapter {
        var listofCharity = ArrayList<Charity>()
        var context: Context?=null
        constructor(context: Context, listofCharity: ArrayList<Charity>):super() {
            this.listofCharity = listofCharity
            this.context = context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val charity = listofCharity[position]
            var inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflater.inflate(R.layout.charity_requests,null)
            myView.txt_view_name.text = charity.name!!
            myView.txt_view_desc.text = charity.desc!!
            myView.img_view.setImageResource(charity.image!!)

            myView.linear_1.setOnClickListener{
                val intent = Intent(context, DonorCharityActivity::class.java)
                intent.putExtra("name",charity.name!!)
                intent.putExtra( "desc", charity.desc!!)
                intent.putExtra("image", charity.image!!)
                context!!.startActivity(intent)
            }
            return myView
        }

        override fun getItem(position: Int): Any {
            return listofCharity[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listofCharity.size
        }

    }

}
