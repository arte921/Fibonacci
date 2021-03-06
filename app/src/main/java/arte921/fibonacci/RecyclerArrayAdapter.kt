package arte921.fibonacci

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.listitemlayout.view.*


class RecyclerArrayAdapter(private val inputData: MutableList<String>) : RecyclerView.Adapter<RecyclerArrayAdapter.MainViewHolder>() {

    class MainViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder = MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.listitemlayout,parent,false))

    override fun getItemCount(): Int = inputData.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.view.fibonacci.text = "$position | ${inputData[position]} \n"
        binded++

/*
        holder.view.random.text = random().toString()
        holder.view.rollButton.setOnClickListener(fun (_){
            holder.view.random.text = random().toString()
            inputData[position] = "pop!"
            this.notifyItemChanged(position)
        })

        holder.view.addButton.setOnClickListener((fun(_){
            inputData.add(position,"inserted")
            this.notifyItemInserted(position)
        }))

        holder.view.deleteButton.setOnClickListener((fun(_){
            inputData.removeAt(position)
            this.notifyItemRemoved(position)
        }))*/

    }
}