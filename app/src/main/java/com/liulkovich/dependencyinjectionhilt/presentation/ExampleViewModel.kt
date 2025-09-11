package com.liulkovich.dependencyinjectionhilt.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.liulkovich.dependencyinjectionhilt.domain.ExampleUseCase
import com.liulkovich.dependencyinjectionhilt.domain.Item
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

class ExampleViewModel @AssistedInject constructor(
    private val exampleUserCase: ExampleUseCase,
    @Assisted("item") private val item: Item
): ViewModel() {
    fun exampleMethod() {
        Log.d("ExampleTest", "ExamoleViewModel exampleMethod $item")
        exampleUserCase(item)
    }

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("item") item: Item
        ): ExampleViewModel
    }
}

class ExampleViewModelFactory @Inject constructor(
    private val exampleUseCase: ExampleUseCase
) {

    fun create(item: Item): ExampleViewModel {
        return ExampleViewModel(exampleUseCase, item)
    }
}