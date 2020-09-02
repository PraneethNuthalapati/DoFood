package dal.cs.ca.dofood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_donor_profile.*

class DonorProfileActivity : AppCompatActivity() {

    lateinit var profile : CircleImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_profile)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // disabling view of edit and done
        etName.visibility = View.GONE
        etOrganization.visibility = View.GONE
        etContact.visibility = View.GONE
        etAddress.visibility = View.GONE
        ivDoneName.visibility = View.GONE
        ivDonePassword.visibility = View.GONE
        ivDoneOrg.visibility = View.GONE
        ivDoneContact.visibility = View.GONE
        ivDoneAddress.visibility = View.GONE

        profile = findViewById<View>(R.id.ivProfile) as CircleImageView

        profile.setOnClickListener{
            val intent = Intent(this, DonorProfileImageActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                profile, ViewCompat.getTransitionName(profile)!!
            )
            startActivity(intent, options.toBundle())
        }

        // responding to name change
        ivEditName.setOnClickListener{
            tvName.visibility = View.GONE
            etName.visibility = View.VISIBLE
            ivDoneName.visibility = View.VISIBLE
            ivEditName.visibility = View.GONE
        }
        ivDoneName.setOnClickListener{
            tvName.text = etName.text.toString()
            etName.visibility = View.GONE
            ivDoneName.visibility = View.GONE
            tvName.visibility = View.VISIBLE
            ivEditName.visibility = View.VISIBLE
        }

        // responding to password change
        imageView4.setOnClickListener{
            etPassword.visibility = View.VISIBLE
            ivDonePassword.visibility = View.VISIBLE
            imageView4.visibility = View.GONE
        }
        ivDonePassword.setOnClickListener{
            etPassword.visibility = View.VISIBLE
            ivDonePassword.visibility = View.GONE
            imageView4.visibility = View.VISIBLE
        }

        // responding to organization name change
        ivEditOrg.setOnClickListener{
            tvOrganization.visibility = View.GONE
            etOrganization.visibility = View.VISIBLE
            ivDoneOrg.visibility = View.VISIBLE
            ivEditOrg.visibility = View.GONE
        }
        ivDoneOrg.setOnClickListener{
            tvOrganization.text = etOrganization.text.toString()
            etOrganization.visibility = View.GONE
            ivDoneOrg.visibility = View.GONE
            tvOrganization.visibility = View.VISIBLE
            ivEditOrg.visibility = View.VISIBLE
        }

        // responding to contact information update
        ivEditContact.setOnClickListener{
            tvContact.visibility = View.GONE
            etContact.visibility = View.VISIBLE
            ivDoneContact.visibility = View.VISIBLE
            ivEditContact.visibility = View.GONE
        }
        ivDoneContact.setOnClickListener{
            tvContact.text = etContact.text.toString()
            etContact.visibility = View.GONE
            ivDoneContact.visibility = View.GONE
            tvContact.visibility = View.VISIBLE
            ivEditContact.visibility = View.VISIBLE
        }

        // responding to address update
        ivAddress.setOnClickListener{
            tvAddress.visibility = View.GONE
            etAddress.visibility = View.VISIBLE
            ivDoneAddress.visibility = View.VISIBLE
            ivAddress.visibility = View.GONE
        }
        ivDoneAddress.setOnClickListener{
            tvAddress.text = etAddress.text.toString()
            etAddress.visibility = View.GONE
            ivDoneAddress.visibility = View.GONE
            tvAddress.visibility = View.VISIBLE
            ivAddress.visibility = View.VISIBLE
        }
    }
}
