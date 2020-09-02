package dal.cs.ca.dofood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_charity_feedback.*

class CharityFeedback : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charity_feedback)

        redirect_to_home_page.setOnClickListener {
            Toast.makeText(applicationContext,"Feedback Sent!", Toast.LENGTH_SHORT).show()
            var intent= Intent(this, CharityActivity::class.java)
            startActivity(intent)
        }
    }
}
