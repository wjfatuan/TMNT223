package co.edu.uan.android.tmnt223

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.uan.android.tmnt223.databinding.ActivityTurtleInfoBinding

class TurtleInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityTurtleInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTurtleInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val turtleName = intent.getStringExtra("PARAM_TURTLE_NAME")
        showTurtle(turtleName!!)
    }

    fun showTurtle(name: String) {
        val id = resources.getIdentifier(name, "drawable", packageName)
        binding.turtleImage.setImageResource(id)
        binding.turtleName.text = name
    }
}