package ru.d3rvich.androidtemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.d3rvich.ui.navigation.Screens
import ru.d3rvich.detail.DetailScreen
import ru.d3rvich.list.ListScreen
import ru.d3rvich.ui.theme.AndroidTemplateTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidTemplateTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = Screens.List) {
                    composable<Screens.List> {
                        ListScreen(navigateToDetail = { id ->
                            navController.navigate(Screens.Detail(id))
                        })
                    }
                    composable<Screens.Detail> {
                        DetailScreen(onBackClick = { navController.popBackStack() })
                    }
                }
            }
        }
    }
}