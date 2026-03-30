package ru.d3rvich.androidtemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import dagger.hilt.android.AndroidEntryPoint
import ru.d3rvich.detail.DetailScreen
import ru.d3rvich.list.ListScreen
import ru.d3rvich.ui.navigation.Screens
import ru.d3rvich.ui.theme.AndroidTemplateTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidTemplateTheme {
                val backStack = rememberSaveable { mutableStateListOf<NavKey>(Screens.List) }
                NavDisplay(
                    backStack = backStack,
                    onBack = {
                        backStack.removeLastOrNull()
                    },
                    entryDecorators = listOf(
                        rememberSaveableStateHolderNavEntryDecorator(),
                        rememberViewModelStoreNavEntryDecorator(),
                    ),
                    entryProvider = entryProvider {
                        entry<Screens.List> {
                            ListScreen(navigateToDetail = { id ->
                                backStack.add(Screens.Detail(id))
                            })
                        }
                        entry<Screens.Detail> {
                            DetailScreen(id = it.id, onBackClick = { backStack.removeLastOrNull() })
                        }
                    })
            }
        }
    }
}