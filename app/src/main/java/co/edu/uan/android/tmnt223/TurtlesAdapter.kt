package co.edu.uan.android.tmnt223

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class TurtlesAdapter(val context: Activity, val layout: Int, val data: ArrayList<String>)
    : ArrayAdapter<String>(context, layout, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = context.layoutInflater.inflate(layout, null)
        val name = view.findViewById<TextView>(R.id.turtleName)
        name.text = data[position]
        val imageId = context.resources.getIdentifier(data[position].lowercase(),"drawable", context.packageName)
        val image = view.findViewById<ImageView>(R.id.turtleImage)
        image.setImageResource(imageId)
        return view
    }
}