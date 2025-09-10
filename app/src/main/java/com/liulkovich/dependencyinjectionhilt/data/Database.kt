package com.liulkovich.dependencyinjectionhilt.data

import android.content.Context
import android.util.Log
import com.liulkovich.dependencyinjectionhilt.domain.Item
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Database @Inject constructor (
    @ApplicationContext private val context: Context
) {

    init {
        Log.d("ExampleTest", "Database created")
    }

    fun exampleMethod(item: Item) {

        Log.d("ExampleTest", "Database exampleMethod $item $context")
    }
}