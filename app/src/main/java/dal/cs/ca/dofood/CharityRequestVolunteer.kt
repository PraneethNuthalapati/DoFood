package dal.cs.ca.dofood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_charity_request_volunteer.*

class CharityRequestVolunteer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charity_request_volunteer)
        btnReqVol.setOnClickListener {
            Toast.makeText(this, "Volunteer request submitted", Toast.LENGTH_SHORT).show()
            val intent= Intent(this,CharityActivity::class.java)
            startActivity(intent)
        }
    }
}
