package dal.cs.ca.dofood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var loginLabel: TextView =findViewById(R.id.tvGoToRegister)
        loginLabel.setOnClickListener {
            var intent= Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
