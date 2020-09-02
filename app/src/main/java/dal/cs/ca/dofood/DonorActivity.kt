package dal.cs.ca.dofood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import dal.cs.ca.dofood.ui.DonorHome.DonorHomeFragment
import dal.cs.ca.dofood.ui.common.AboutUsFragment
import dal.cs.ca.dofood.ui.common.HelpFragment
import kotlinx.android.synthetic.main.activity_donor.*

import kotlinx.android.synthetic.main.app_bar_donor.*



class DonorActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var donorHomeFragment: DonorHomeFragment
    lateinit var aboutUsFragment: AboutUsFragment
    lateinit var helpFragment: HelpFragment




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor)
        setSupportActionBar(toolbar)
        var actionbar=supportActionBar
        actionbar?.title="DoFood"

        var drawerToggle:ActionBarDrawerToggle=object:ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ){

        }
        drawerToggle.isDrawerIndicatorEnabled=true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener (this)

        donorHomeFragment= DonorHomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout,donorHomeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when(menuItem.itemId){
            R.id.nav_home ->{
                donorHomeFragment= DonorHomeFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout,donorHomeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_profile->{
                var intent= Intent(this,DonorProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_donation_history->{
                var intent=Intent(this,DonationHistoryActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_about_us ->{
                aboutUsFragment= AboutUsFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout,aboutUsFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_help_and_documentation ->{
                helpFragment= HelpFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout,helpFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_logout->{
                var intent= Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
