package arte921.fibonacci

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.listitemlayout.view.*

class RecyclerArrayAdapter(private val inputData: MutableList<String>) : RecyclerView.Adapter<RecyclerArrayAdapter.MainViewHolder>() {

    class MainViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.textviewa,parent,false) as TextView
        return MainViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.textView.text = inputData[position].toString()
    }

    override fun getItemCount(): Int = inputData.size
}