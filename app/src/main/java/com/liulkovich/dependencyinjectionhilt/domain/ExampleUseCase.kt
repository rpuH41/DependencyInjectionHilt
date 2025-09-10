package com.liulkovich.dependencyinjectionhilt.domain

import android.util.Log
import com.liulkovich.dependencyinjectionhilt.data.ExampleRepositoryImpl
import javax.inject.Inject

class ExampleUseCase @Inject constructor (
    private val repository: ExampleRepositoryImpl
) {

    operator fun invoke(item: Item) {
        Log.d("ExampleTest", "ExampleUseCase invoke $item")
        repository.exampleMethod(item)
    }
}