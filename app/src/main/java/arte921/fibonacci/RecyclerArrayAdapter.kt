package arte921.fibonacci

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.listitemlayout.view.*
import java.lang.Math.random

class RecyclerArrayAdapter(private val inputData: MutableList<String>) : RecyclerView.Adapter<RecyclerArrayAdapter.MainViewHolder>() {

    class MainViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.listitemlayout,parent,false)
        return MainViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.view.fibonacci.text = inputData[position]
        holder.view.random.text = random().toString()
        holder.view.rollButton.setOnClickListener(fun (_: View){
            holder.view.random.text = random().toString()
        })
    }

    override fun getItemCount(): Int = inputData.size


}