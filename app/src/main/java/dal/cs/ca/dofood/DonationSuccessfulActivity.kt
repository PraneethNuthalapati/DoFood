package dal.cs.ca.dofood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_donation_successful.*

class DonationSuccessfulActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donation_successful)
        val bundle: Bundle? = intent.extras
        val image=bundle?.getInt("image")
        image?.let { imageView.setImageResource(it) }
        redirect_to_home_page.setOnClickListener {
            var intent= Intent(this,DonorActivity::class.java)
            startActivity(intent)
        }
    }
}
