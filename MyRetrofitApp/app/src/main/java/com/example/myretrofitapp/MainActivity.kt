package com.example.myretrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotesAPI = RetrofitHelper.getInstance().create(QuotesAPI::class.java)

        // Use lifecycleScope for coroutine
        lifecycleScope.launch {
            try {
                val result = quotesAPI.getQuotes(1)
                if (result.isSuccessful) {
                    val quoteList = result.body()
                    quoteList?.results?.forEach {
                        Log.d("WINTER", it.content)
                    }
                } else {
                    val errorCode = result.code()
                    Log.e("WINTER", "Error: $errorCode")
                }
            } catch (e: HttpException) {
                val errorCode = e.code() // Get HTTP status code from HttpException
                Log.e("WINTER", "HttpException: ${e.message()}, Code: $errorCode")
            } catch (e: Exception) {
                val errorCode = if (e is  HttpException) e.code() else -1 // If not HttpException, set error code to -1
                Log.e("WINTER", "Exception: ${e.message}, Code: $errorCode")
            }
        }
    }
}
