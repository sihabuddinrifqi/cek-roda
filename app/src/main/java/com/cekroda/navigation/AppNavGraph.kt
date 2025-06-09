package com.cekroda.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cekroda.presentation.route.HomeRoute
import com.cekroda.presentation.route.InspectionRoute
import com.cekroda.ui.screen.splash.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController)
        }

        composable("home") {
            HomeRoute(
                onAddInspectionClick = {
                    navController.navigate("add-inspection")
                    // TODO: navigasi ke form tambah inspection
                },
                onInspectionClick = {
                    throw RuntimeException("Test Crash")
                    // TODO: navigasi ke detail inspection
                }
            )
        }

        composable("add-inspection") {
            InspectionRoute(onAddInspectionOnBoardingClick = { inspection ->
                navController.popBackStack()
                navController.navigate("home")
            })
        }
    }
}
