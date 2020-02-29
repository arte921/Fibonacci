package arte921.fibonacci

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var fibonacci = mutableListOf<String>()
    var f: Long = 0
    var v: Long = 1
    var t: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in 0..50){
            f = v + t
            fibonacci.add(f.toString())
            t = v
            v = f
        }

        var viewManager = LinearLayoutManager(this)

        rva.apply{
            layoutManager = viewManager
            adapter = RecyclerArrayAdapter(fibonacci)
        }

        rva.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN) && dy > 0) {
                    for(i in 1..5){
                        fibonacci.add(dy.toString())
                        rva.adapter?.notifyItemInserted(fibonacci.size)
                    }
                    fibonacci.add(dy.toString())
                    rva.adapter?.notifyItemInserted(fibonacci.size)
                }
            }
        })
    }
}
