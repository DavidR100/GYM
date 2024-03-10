package com.davidr10.gym.navigation

sealed class NavigationRoute(val route: String){
    object Home: NavigationRoute("home")
    object Workout: NavigationRoute("workout")
}