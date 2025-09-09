package com.liulkovich.dependencyinjectionhilt.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.liulkovich.dependencyinjectionhilt.domain.ExampleUseCase
import com.liulkovich.dependencyinjectionhilt.domain.Item

class ExampleViewModel(
    private val exampleUserCase: ExampleUseCase
): ViewModel() {
    fun exampleMethod(item: Item) {
        Log.d("ExampleTest", "ExamoleViewModel exampleMethod $item")
        exampleUserCase(item)
    }
}