package dal.cs.ca.dofood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import dal.cs.ca.dofood.ui.Register.VolunteerFragment
import dal.cs.ca.dofood.ui.VolunteerHome.VolunteerHistoryFragment
import dal.cs.ca.dofood.ui.VolunteerHome.VolunteerHomeFragment
import dal.cs.ca.dofood.ui.common.AboutUsFragment
import dal.cs.ca.dofood.ui.common.HelpFragment
import kotlinx.android.synthetic.main.activity_charity1.*
import kotlinx.android.synthetic.main.activity_volunteer.*
import kotlinx.android.synthetic.main.app_bar_volunteer.*

class VolunteerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var volunteerHomeFragment: VolunteerHomeFragment
    lateinit var aboutUsFragment: AboutUsFragment
    lateinit var helpFragment: HelpFragment
    lateinit var volunteerHistoryFragment: VolunteerHistoryFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volunteer)
        setSupportActionBar(toolbar_volunteer)

        var actionbar=supportActionBar
        actionbar?.title="DoFood"

        var toggle: ActionBarDrawerToggle=object :ActionBarDrawerToggle(
            this,
            drawer_layout_volunteer,
            toolbar_volunteer,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ){}

        toggle.isDrawerIndicatorEnabled=true
        drawer_layout_volunteer.addDrawerListener(toggle)
        toggle.syncState()

        nav_volunteer.setNavigationItemSelectedListener (this)

        volunteerHomeFragment= VolunteerHomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout_volunteer,volunteerHomeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.nav_home_volunteer->{
//                System.out.println("Is clicked nav_home_volunteer")
                volunteerHomeFragment= VolunteerHomeFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout_volunteer,volunteerHomeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

            R.id.nav_logout_volunteer->{
//                Log.d("TAG","Is clicked nav_logout_volunteer")
                var intent= Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_about_us_volunteer->{
//                Log.v("AboutUsFragment", "enter message here")
                aboutUsFragment= AboutUsFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout_volunteer,aboutUsFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_help_and_documentation_volunteer ->{
//                Log.d("TAG","Is clicked nav_help_and_documentation_volunteer")
                helpFragment= HelpFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout_volunteer,helpFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

            R.id.nav_profile_volunteer->{
//                Log.d("TAG","Is clicked nav_profile_volunteer")
                var intent= Intent(this,DonorProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_volunteer_history->{
//                System.out.println("Is clicked nav_volunteer_history")
                volunteerHistoryFragment= VolunteerHistoryFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout_volunteer,volunteerHistoryFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

        }
        drawer_layout_volunteer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout_volunteer.isDrawerOpen(GravityCompat.START)) {
            drawer_layout_volunteer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
