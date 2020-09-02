package dal.cs.ca.dofood

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import dal.cs.ca.dofood.ui.Classes.Stories
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.landing_page.view.*

class HomeActivity : AppCompatActivity() {
    var listOfStories=ArrayList<Stories>()
    var adapter:StoriesAdaptor?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listOfStories.add(
            //Stories("The Salvation Army","The Salvation army has received 200 donations for food from various Food organisations across Halifax", androidx.activity.R.drawable.c1)
            Stories(
                "The Salvation Army",
                "The Salvation army has received 200 donations for food from various Food organisations across Halifax",
                R.drawable.c1
            )

        )
        listOfStories.add(
            Stories(
                "Parker street food and furniture bank",
                "The Parker street food and furniture bank has received 150 donations for food from various Food organisations across Halifax",
                R.drawable.c2
            )
        )
        listOfStories.add(
            Stories(
                "Feed Nova Scotia",
                "The Feed Nova Scotia has received 200 donations for food from various Food organisations across Halifax",
                R.drawable.c3
            )
        )
        listOfStories.add(
            Stories(
                "Hope Cottage",
                "The Hope Cottage has received 200 donations for food from various Food organisations across Halifax",
                R.drawable.c4
            )
        )

        adapter= StoriesAdaptor(this,listOfStories)
        homePage.adapter=adapter
        btnJoinUs.setOnClickListener{
            val intent= Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }


    }

    class StoriesAdaptor: BaseAdapter {
        var listOfStories= ArrayList<Stories>()
        var context: Context?=null
        constructor(context: Context, listOfStories: ArrayList<Stories>):super(){
            this.listOfStories=listOfStories
            this.context=context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val story=listOfStories[position]
            var inflator= context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var viewStory= inflator.inflate(R.layout.landing_page,null)
            viewStory.storyName.text=story.name!!
            viewStory.storyDescription.text=story.story!!
            viewStory.imageView.setImageResource(story.image!!)
            viewStory.btnReadMore.setOnClickListener{
                val intent= Intent(context,StoryActivity::class.java)
                intent.putExtra("name",story.name!!)
                intent.putExtra("story",story.story!!)
                intent.putExtra("image",story.image!!)
                context!!.startActivity(intent)
            }
            return viewStory
        }

        override fun getItem(position: Int): Any {
            return position.toLong()
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfStories.size
        }

    }
}

