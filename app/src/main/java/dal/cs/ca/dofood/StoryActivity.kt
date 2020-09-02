package dal.cs.ca.dofood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_story.*

class StoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)
        val bundle: Bundle? = intent.extras
        val name= bundle?.getString("name")
        val des=bundle?.getString("story")
        val image=bundle?.getInt("image")
        image?.let { ivDetails.setImageResource(it) }
        tvStoryDisplyName.text=name
        tvDesctiptionStory.text=des
        btnBackHome.setOnClickListener{
            val intent= Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
    }
}