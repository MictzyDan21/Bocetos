package mx.uacj.demo.hit_y_retrofit.ui.pantallas

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import mx.uacj.demo.hit_y_retrofit.controladores.ControladorPublicaciones

@Composable
fun PantalladePublicacion(
    modificador: Modifier = Modifier,
    controlador_publicaciones: ControladorPublicaciones = hiltViewModel()

){
    controlador_publicaciones.obtener_publicaciones()
    controlador_publicaciones.seleccionar_publicacion(1)

    val publicacion = controlador_publicaciones.publicacion_seleccionada.value
    val comentarios by controlador_publicaciones.comentarios

    Log.v("PantallaPublicacion", "Valor del controlador: ${controlador_publicaciones}")

    Column (modificador){
        Column(modifier = Modifier
            .fillMaxHeight()
            .background(color = Color.DarkGray)
            .padding(10.dp)
        )
        {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                .background(color = Color.White)
                    .padding(5.dp)
            ){
                Text("Titulo: ${publicacion.title}",
                    color = Color.Blue,
                    fontSize = 24.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily.Serif
                )
                Text("Cuerpo:${publicacion.body}",
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,

                )

                for(comentario in comentarios){
                    Text("Comentario:${comentario.body}",
                        fontSize = 12.sp,
                        fontFamily = FontFamily.SansSerif,
                        modifier = Modifier
                            .border(width = 1.dp, color = Color.Gray)
                            .padding(5.dp)
                    )
                }
            }

        }

    }
}