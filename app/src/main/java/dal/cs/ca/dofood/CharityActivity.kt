package dal.cs.ca.dofood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import dal.cs.ca.dofood.ui.CharityHome.CharityHomeFragment
import dal.cs.ca.dofood.ui.CharityHome.VolunteerRequestFragment
import dal.cs.ca.dofood.ui.common.AboutUsFragment
import dal.cs.ca.dofood.ui.common.HelpFragment
import kotlinx.android.synthetic.main.activity_charity1.*
import kotlinx.android.synthetic.main.activity_donor.*
import kotlinx.android.synthetic.main.app_bar_charity.*

class CharityActivity : AppCompatActivity() , OnNavigationItemSelectedListener{

    lateinit var charityHomeFragment: CharityHomeFragment
    lateinit var helpFragment: HelpFragment
    lateinit var aboutUsFragment: AboutUsFragment
    lateinit var volunteerRequestFragment: VolunteerRequestFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charity1)
        setSupportActionBar(toolbar_charity)
        var actionbar=supportActionBar
        actionbar?.title="DoFood"



        var drawerToggle1:ActionBarDrawerToggle=object :ActionBarDrawerToggle(
            this,
            drawer_layout_charity,
            toolbar_charity,
            R.string.navigation_drawer_open1,
            R.string.navigation_drawer_close1
        ){}

        drawerToggle1.isDrawerIndicatorEnabled=true
        drawer_layout_charity.addDrawerListener(drawerToggle1)
        drawerToggle1.syncState()
        nav_charity.setNavigationItemSelectedListener(this)

        charityHomeFragment= CharityHomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout_charity,charityHomeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_about_us_charity ->{
                aboutUsFragment= AboutUsFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout_charity,aboutUsFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

            R.id.nav_help_and_documentation_charity ->{
                helpFragment= HelpFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout_charity,helpFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_logout_charity->{
                var intent= Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_profile_charity->{
                var intent= Intent(this,DonorProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_home_charity->{
                charityHomeFragment= CharityHomeFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout_charity,charityHomeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_volunteer_request->{
                volunteerRequestFragment= VolunteerRequestFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout_charity,volunteerRequestFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
        }
        drawer_layout_charity.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout_charity.isDrawerOpen(GravityCompat.START)) {
            drawer_layout_charity.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
