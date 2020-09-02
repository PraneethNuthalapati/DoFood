package dal.cs.ca.dofood

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_donor_profile_image.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class DonorProfileImageActivity : AppCompatActivity() {

    private var CurrentPath: String? = null
    private val TAKE_PICTURE = 1
    private val SELECT_PICTURE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_profile_image)

        ivPickImage.setOnClickListener{
            dispatchGalleryIntent()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == TAKE_PICTURE && resultCode == Activity.RESULT_OK){
            try{
                val file = File(CurrentPath)
                val uri = Uri.fromFile(file)
                ivProfileImage.setImageURI(uri)
            }
            catch (e: IOException){
                e.printStackTrace()
            }
        }

        if(requestCode == SELECT_PICTURE && resultCode == Activity.RESULT_OK){
            try{
                val uri = data!!.data
                ivProfileImage.setImageURI(uri)
            }
            catch (e: IOException){
                e.printStackTrace()
            }
        }
    }

    fun dispatchGalleryIntent(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select_Image"), SELECT_PICTURE)
    }

}
