package com.liulkovich.dependencyinjectionhilt.di

import android.content.Context
import com.liulkovich.dependencyinjectionhilt.data.Database
import com.liulkovich.dependencyinjectionhilt.data.ExampleRepositoryImpl
import com.liulkovich.dependencyinjectionhilt.domain.ExampleUseCase
import com.liulkovich.dependencyinjectionhilt.presentation.ExampleViewModel
import com.liulkovich.dependencyinjectionhilt.presentation.MainActivity

class Component(
    context: Context
) {

    val database = Database.getInstance(context)

    val repository = ExampleRepositoryImpl(database)

    val exampleUseCase = ExampleUseCase(repository)

    val exampleViewModel = ExampleViewModel(exampleUseCase)
    /*val exampleViewModel
     get()= ExampleViewModel(exampleUseCase) - если нужно чтобы при рекомпозиции вью модель создавалась заново*/

    fun inject(mainActivity: MainActivity) {
        mainActivity.exampleViewModel = exampleViewModel
    }
}