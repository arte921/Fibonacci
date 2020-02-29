package arte921.fibonacci

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.abs
import java.math.BigInteger

const val cacheAmount: Int = 10

var binded: Int = 0

class MainActivity : AppCompatActivity() {

    var fibonacci = mutableListOf<String>()
    var f: BigInteger = 0.toBigInteger()
    var v: BigInteger = 1.toBigInteger()
    var t: BigInteger = 0.toBigInteger()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun calcFibonacci(amount: Int) {
            for (i in 1..amount) {
                f = v + t
                fibonacci.add(f.toString())
                t = v
                v = f
            }
        }

        calcFibonacci(100)

        var viewManager = LinearLayoutManager(this)

        rva.apply {
            layoutManager = viewManager
            adapter = RecyclerArrayAdapter(fibonacci)
        }

        rva.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0 && fibonacci.size - binded < 100) {
                    calcFibonacci(cacheAmount)
                    rva.adapter?.notifyItemRangeInserted(fibonacci.size, cacheAmount)
                }
            }
        })


    }
}
