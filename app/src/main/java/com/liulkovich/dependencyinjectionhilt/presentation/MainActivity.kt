package com.liulkovich.dependencyinjectionhilt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.liulkovich.dependencyinjectionhilt.ExampleApp
import com.liulkovich.dependencyinjectionhilt.domain.Item
import com.liulkovich.dependencyinjectionhilt.presentation.ui.theme.DependencyInjectionHiltTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var exampleViewModel: ExampleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val component = (application as ExampleApp).component
//        component.inject(this)

        enableEdgeToEdge()
        setContent {
            DependencyInjectionHiltTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ExampleScreen(
                        modifier = Modifier.padding(innerPadding),
                        exampleViewModel = viewModel {
                            exampleViewModel
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ExampleScreen(
    modifier: Modifier = Modifier,
    exampleViewModel: ExampleViewModel
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = {
                exampleViewModel.exampleMethod(Item(0))
            }
        ) {
            Text("Click Me!!!")
        }
    }
}