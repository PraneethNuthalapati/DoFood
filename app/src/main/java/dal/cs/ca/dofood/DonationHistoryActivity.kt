package dal.cs.ca.dofood

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import dal.cs.ca.dofood.ui.Classes.Donation
import kotlinx.android.synthetic.main.activity_donation_history.*
import kotlinx.android.synthetic.main.my_donations.view.*

class DonationHistoryActivity : AppCompatActivity() {

    var listOfDonation=ArrayList<Donation>()
    var adapter:DonationAdaptor?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donation_history)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        listOfDonation.add(
            Donation("The Salvation Army",R.drawable.canada_help,"1st Jan, 2020","Thank you very much")
        )
        listOfDonation.add(
            Donation("Parker street food and furniture bank",R.drawable.world_vision,"14th Jan, 2020","Thank you very much")
        )
        listOfDonation.add(
            Donation("Feed Nova Scotia",R.drawable.canadian_red_cross,"1st Feb, 2020","Thank you very much")
        )
        listOfDonation.add(
            Donation("Hope Cottage",R.drawable.canada_help,"1st March, 2020","Thank you very much")
        )

        adapter= DonationAdaptor(this,listOfDonation)
        donationHistoryList.adapter=adapter
    }

    class DonationAdaptor: BaseAdapter {
        var listOfDonation= ArrayList<Donation>()
        var context: Context?=null
        constructor(context: Context, listOfDonation: ArrayList<Donation>):super(){
            this.listOfDonation=listOfDonation
            this.context=context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val donation=listOfDonation[position]
            var inflator= context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var viewStory= inflator.inflate(R.layout.my_donations,null)
            viewStory.charityName.text=donation.charity_name!!
            viewStory.date_of_donation.text=donation.date!!
            viewStory.charityImage.setImageResource(donation.image!!)
            return viewStory
        }

        override fun getItem(position: Int): Any {
            return position.toLong()
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfDonation.size
        }

    }
}
