package mx.uacj.demo.hit_y_retrofit.ui.controladores

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.uacj.demo.hit_y_retrofit.ui.pantallas.ListaPublicaciones
import mx.uacj.demo.hit_y_retrofit.ui.pantallas.PantalladePublicacion

@Composable
fun NavegacionPrincipal(modificador: Modifier = Modifier ) {
    val control_navegacion = rememberNavController()

    NavHost(navController = control_navegacion, startDestination = PantallaListaPublicaciones) {
        composable<PantallaListaPublicaciones> {
            ListaPublicaciones(modificador, navegar_a_publicacion = {control_navegacion.navigate(PantallaPublicacion)})
        }

        composable<PantallaPublicacion>{
            PantalladePublicacion(modificador)
        }
    }
}