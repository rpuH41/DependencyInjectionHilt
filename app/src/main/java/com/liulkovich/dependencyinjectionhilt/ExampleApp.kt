package com.liulkovich.dependencyinjectionhilt

import android.app.Application
import com.liulkovich.dependencyinjectionhilt.di.Component

class ExampleApp: Application() {

    val component = Component(this)
}