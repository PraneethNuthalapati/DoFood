package com.example.mydofood.ui.SignUp

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import dal.cs.ca.dofood.R
import dal.cs.ca.dofood.ui.Register.CharityFragment
import dal.cs.ca.dofood.ui.Register.DonorFragment
import dal.cs.ca.dofood.ui.Register.VolunteerFragment


private val TAB_TITLES = arrayOf(
    R.string.donor,
    R.string.charity,
    R.string.volunteer
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        when(position){
            0->{
                return DonorFragment()
            }
            1->{
                return CharityFragment()
            }
            else->{
                return VolunteerFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0->return "Donor"
            1->return "Charity"
            else->return "Volunteer"
        }
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }

//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        var view:View=LayoutInflater.from(container.context).inflate(R.layout.fragment_donar,container,false)
//        container.addView(view)
//    }
}