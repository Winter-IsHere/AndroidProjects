package com.example.quotesapplication

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.io.IOException
import java.lang.ref.WeakReference

class MainViewModel(context: Context) : ViewModel() {
    private var contextRef: WeakReference<Context> = WeakReference(context.applicationContext)
    private var quoteList: Array<Quote> = emptyArray()
    private var index = 0

    init {
        quoteList = loadQuoteFromAssets()
    }

    private fun loadQuoteFromAssets(): Array<Quote> {
        val context = contextRef.get()
        context?.let {
            try {
                it.assets.open("quotes.json").use { inputStream ->
                    val size: Int = inputStream.available()
                    val buffer = ByteArray(size)
                    inputStream.read(buffer)
                    val json = String(buffer, Charsets.UTF_8)
                    val gson = Gson()
                    return gson.fromJson(json, Array<Quote>::class.java)
                }
            } catch (e: IOException) {
                // Handle error loading quotes
                e.printStackTrace()
            }
        }
        return emptyArray()
    }

    fun getQuote(): Quote {
        return quoteList[index]
    }

    fun nextQuote(): Quote {
        index = (index + 1) % quoteList.size
        return quoteList[index]
    }

    fun previousQuote(): Quote {
        index = (index - 1 + quoteList.size) % quoteList.size
        return quoteList[index]
    }
}
