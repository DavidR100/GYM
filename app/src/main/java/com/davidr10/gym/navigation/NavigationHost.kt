package com.davidr10.gym.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.davidr10.gym.home.presentacion.HomeScreen
import com.davidr10.gym.workout.WorkoutScreen

@Composable
fun NavigationHost(
    navHostController: NavHostController
){
    NavHost(navController = navHostController, startDestination = NavigationRoute.Home.route) {
        composable(NavigationRoute.Home.route){
            HomeScreen{
                navHostController.navigate(NavigationRoute.Workout.route + "workoutid=$it")
            }
        }
        composable(NavigationRoute.Workout.route + "workoutid={workoutid}",
            arguments = listOf(
                navArgument("workoutid"){
                    this.type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ){
            WorkoutScreen()
        }
    }
}