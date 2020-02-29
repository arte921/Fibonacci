package arte921.fibonacci

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigInteger

val cacheAmount: Int = 100

class MainActivity : AppCompatActivity() {

    var fibonacci = mutableListOf<String>()
    var f: BigInteger = 0.toBigInteger()
    var v: BigInteger = 1.toBigInteger()
    var t: BigInteger = 0.toBigInteger()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun calcFibonacci(amount: Int){
            for(i in 1..amount){
                f = v + t
                fibonacci.add(f.toString())
                t = v
                v = f
            }
        }

        calcFibonacci(1000)

        var viewManager = LinearLayoutManager(this)

        rva.apply{
            layoutManager = viewManager
            adapter = RecyclerArrayAdapter(fibonacci)
        }

        rva.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN) && dy > 0) {
                    calcFibonacci(cacheAmount)
                    rva.adapter?.notifyItemRangeInserted(fibonacci.size,cacheAmount)
                }
            }
        })


    }
}
