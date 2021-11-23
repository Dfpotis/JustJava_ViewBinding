package com.potis.honorsmobileapps.JustJava_ViewBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.potis.honorsmobileapps.JustJava_ViewBinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var quantity= 0
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val rootView= binding.root
        setContentView(rootView)

        binding.plus.setOnClickListener{updateQuantity(1) }
        binding.minus.setOnClickListener{ updateQuantity(-1)}
        binding.order.setOnClickListener{
            submitOrder()
        }

    }
    fun updateQuantity(value: Int){
        if(quantity<2&&value<0)
            Toast.makeText(this, R.string.warning, Toast.LENGTH_SHORT).show()
        else if(quantity>9&&value>0)
            Toast.makeText(this, R.string.warning2, Toast.LENGTH_SHORT).show()
        else
            quantity+=value
        binding.num.text = quantity.toString()

    }
    fun submitOrder(){
        var total=quantity*5
        val names=binding.name.text
        var order="Thanks, $names!"
        if(quantity==1)
            order+="\n$quantity Coffee"
        else
            order+="\n$quantity Coffees"
        if(binding.whippedCream.isChecked) {
            total += quantity
            order += "\n+Whipped Cream"
        }
        if (binding.choclate.isChecked) {
            total+=quantity*2
            order+="\n+Chocolate"
        }
            order+="\nTotal:$$total.00"
        binding.total.text=order

    }
}