package com.example.vendingmachineapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vendingmachineapp.data.Product
import com.example.vendingmachineapp.databinding.ActivityMainBinding
import com.example.vendingmachineapp.utils.DummyDataHelper.getProduct

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: VendingViewModel by viewModels()
    private lateinit var adapter: ProductAdapter
    private lateinit var tempProduct : Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setupAdapterProduct()
        setupDataProduct()
        setupOnClick()
    }

    private fun setupAdapterProduct() {
        adapter = ProductAdapter()
        val linearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        with(binding.rvProduct) {
            adapter = adapter
            layoutManager = linearLayoutManager
        }
        adapter.onItemClicked = {
            tempProduct = it
            adapter.updateProduct(it)
        }
    }

    private fun setupDataProduct() {
        println(getProduct())
        viewModel.insertProduct()
        adapter.setData(getProduct())
    }

    private fun setupOnClick() {
        binding.apply {
            submit.setOnClickListener {
                if (tempProduct.qty >= etQty.text.toString().toInt()) {
                    val totapPayment = tempProduct.qty*tempProduct.price
                    if (etPayment.text.toString().toInt() < totapPayment) {
                        Toast.makeText(this@MainActivity, "Transaksi Berhasil, ", Toast.LENGTH_LONG)
                            .show()
                    } else {
                        Toast.makeText(this@MainActivity, "Transaksi Berhasil, Kembalian anda ${(etPayment.text.toString().toInt() - totapPayment)} ", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this@MainActivity,"Maap product yang anda pilih sedang kosong...",Toast.LENGTH_LONG).show()
//                    Snackbar.make(it, "Sorry ", Snackbar.LENGTH_SHORT)
//                        .setAction("Ok", null).show()
                }
            }
        }
    }
}