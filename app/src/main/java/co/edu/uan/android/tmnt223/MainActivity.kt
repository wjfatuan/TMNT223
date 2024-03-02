package co.edu.uan.android.tmnt223

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import co.edu.uan.android.tmnt223.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: TurtlesAdapter

    val turtleNames = arrayListOf<String>("Michelangelo", "Leonardo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // manage buton events
        binding.btnRaph.setOnClickListener {
            addTurtle("raphael")
        }
        binding.btnLeo.setOnClickListener {
            addTurtle("leonardo")
        }
        binding.btnDon.setOnClickListener {
            addTurtle("donatello")
        }
        binding.btnMike.setOnClickListener {
            addTurtle("michelangelo")
        }
        binding.listTurtles.setOnItemClickListener { parent, view, position, id ->
            println("parent: $parent,\nview: $view,\nposition: $position,\nid: $id")
            // ir a la actividad de informacion
            val i = Intent(this, MainActivity::class.java)
            i.putExtra("PARAM_TURTLE_NAME", turtleNames[position].lowercase())
            startActivity(i)
        }

        adapter = TurtlesAdapter(this, R.layout.list_turtles, turtleNames)
        binding.listTurtles.adapter = adapter
    }


    fun addTurtle(name: String) {
        turtleNames.add(name)
        adapter.notifyDataSetChanged()
    }
}