package co.edu.uan.android.tmnt223

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import co.edu.uan.android.tmnt223.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val turtleNames = arrayListOf<String>("Michelangelo", "Leonardo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // manage buton events
        binding.btnRaph.setOnClickListener {
            showTurtle("raphael")
        }
        binding.btnLeo.setOnClickListener {
            showTurtle("leonardo")
        }
        binding.btnDon.setOnClickListener {
            showTurtle("donatello")
        }
        binding.btnMike.setOnClickListener {
            showTurtle("michelangelo")
        }
        binding.listTurtles.setOnItemClickListener { parent, view, position, id ->
            println("parent: $parent,\nview: $view,\nposition: $position,\nid: $id")
            showTurtle(turtleNames[position].lowercase())
        }

        val adapter = TurtlesAdapter(this, R.layout.list_turtles, turtleNames)
        binding.listTurtles.adapter = adapter
    }

    fun showTurtle(name: String) {
        val id = resources.getIdentifier(name, "drawable", packageName)
        binding.ivTurtle.setImageResource(id)
    }
}