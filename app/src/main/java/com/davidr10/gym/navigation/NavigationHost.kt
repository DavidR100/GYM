package com.davidr10.gym.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.davidr10.gym.home.presentacion.HomeScreen
import com.davidr10.gym.workout.presentacion.WorkoutScreen

@Composable
fun NavigationHost(
    navHostController: NavHostController
){
    NavHost(navController = navHostController, startDestination = NavigationRoute.Home.route) {
        composable(NavigationRoute.Home.route){
            HomeScreen{
                navHostController.navigate(NavigationRoute.Workout.route + "routineId=$it")
            }
        }
        composable(NavigationRoute.Workout.route + "routineId={routineId}",
            arguments = listOf(
                navArgument("routineId"){
                    this.type = NavType.LongType
                    nullable = false
                    defaultValue = -1L
                }
            )
        ){
            WorkoutScreen()
        }
    }
}