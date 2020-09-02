package dal.cs.ca.dofood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_volunteer_enroll.*

class VolunteerEnroll : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volunteer_enroll)
        val bundle: Bundle? = intent.extras
        val name = bundle?.getString("name")
        val desc = bundle?.getString("desc")
        val maxHours = bundle?.getString("maxHours")
        val minHours = bundle?.getString("minHours")
        val jobRole = bundle?.getString("jobRole")
        val image = bundle?.getInt("image")
        if (image != null) {
            img_charity.setImageResource(image)
        }
        txt_JobRole_value.text = jobRole
        txt_maxHours_value.text = maxHours
        txt_minHours_value.text = minHours
        text_JobDescription_value.text = desc


        Enroll_Button.setOnClickListener {
            val build_alert = AlertDialog.Builder(this)
            build_alert.setTitle("Confirmation")
            build_alert.setMessage("Are you sure you want to enroll with " + name + "?")
            build_alert.setCancelable(true)
            build_alert.setPositiveButton(
                "Confirm"
            ) { dialog, which ->
                Toast.makeText(applicationContext,"Enrollment Successfull",Toast.LENGTH_SHORT).show()
                var intent=Intent(this, VolunteerActivity::class.java)
                startActivity(intent)
            }
            build_alert.setNegativeButton(
                android.R.string.cancel
            ) { dialog, which -> }

            val create_dialog = build_alert.create()
            create_dialog.show()

        }
    }



}