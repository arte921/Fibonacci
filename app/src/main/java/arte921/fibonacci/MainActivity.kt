package arte921.fibonacci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigInteger

class MainActivity : AppCompatActivity() {

    var fibonacci = mutableListOf<String>()
    var f: Long = 0
    var v: Long = 1
    var t: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in 0..5000){
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
    }
}
