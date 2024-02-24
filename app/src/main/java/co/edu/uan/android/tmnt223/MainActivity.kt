package co.edu.uan.android.tmnt223

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.uan.android.tmnt223.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // manage buton events
        binding.btnRaph.setOnClickListener {
            showTurtle("raph")
        }
        binding.btnLeo.setOnClickListener {
            showTurtle("leo")
        }
        binding.btnDon.setOnClickListener {
            showTurtle("donatello")
        }
        binding.btnMike.setOnClickListener {
            showTurtle("mike")
        }
    }

    fun showTurtle(name: String) {
        when (name) {
            "leo" -> binding.ivTurtle.setImageResource(R.drawable.leonardo)
            "raph" -> binding.ivTurtle.setImageResource(R.drawable.raphael)
            "donatello" -> binding.ivTurtle.setImageResource(R.drawable.donatello)
            else -> binding.ivTurtle.setImageResource(R.drawable.michelangelo)
        }
    }
}