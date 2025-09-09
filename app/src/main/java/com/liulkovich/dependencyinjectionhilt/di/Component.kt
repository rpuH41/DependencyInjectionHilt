package com.liulkovich.dependencyinjectionhilt.di

import com.liulkovich.dependencyinjectionhilt.data.Database
import com.liulkovich.dependencyinjectionhilt.data.ExampleRepositoryImpl
import com.liulkovich.dependencyinjectionhilt.domain.ExampleUseCase
import com.liulkovich.dependencyinjectionhilt.presentation.ExampleViewModel
import com.liulkovich.dependencyinjectionhilt.presentation.MainActivity

class Component {

    val database = Database()

    val repository = ExampleRepositoryImpl(database)

    val exampleUseCase = ExampleUseCase(repository)

    val exampleViewModel = ExampleViewModel(exampleUseCase)

    fun inject(mainActivity: MainActivity) {
        mainActivity.exampleViewModel = exampleViewModel
    }
}