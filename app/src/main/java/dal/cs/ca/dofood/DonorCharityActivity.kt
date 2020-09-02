package dal.cs.ca.dofood

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_donor_charity.*

class DonorCharityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_charity)
        val bundle: Bundle? = intent.extras
        val name = bundle?.getString("name")
        val desc = bundle?.getString("desc")
        val image = bundle?.getInt("image")

        Button_Browse.setOnClickListener{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){
                    //permission denied

                    val permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE)
                }
                else{
                    //permission already granted
                    pickImageFromGallery()

                }
            }
            else{
                //system OS is < Marshmallow

                pickImageFromGallery()

            }
        }

        if (image != null) {
            img_charity.setImageResource(image)
        }

        btnDonate.setOnClickListener {
            var intent= Intent(this,DonationSuccessfulActivity::class.java)
            intent.putExtra("image",image)
            startActivity(intent)
        }


    }
    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        private val IMAGE_PICK_CODE = 1000
        private val PERMISSION_CODE = 1001

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size >0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    //permission from popup granted
                    pickImageFromGallery()
                }
                else{
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            img_browse.setImageURI(data?.data)
        }

    }
}
