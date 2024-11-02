package ma.ensa.projet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val data=findViewById<TextView>(R.id.data)
        data.text = intent.getStringExtra("data")
        val backBtn = findViewById<Button>(R.id.back_button)
        backBtn.setOnClickListener {
            val intent  = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}