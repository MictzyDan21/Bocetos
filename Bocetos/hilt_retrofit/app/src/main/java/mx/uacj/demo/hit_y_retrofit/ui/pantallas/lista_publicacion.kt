package mx.uacj.demo.hit_y_retrofit.ui.pantallas

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import mx.uacj.demo.hit_y_retrofit.controladores.ControladorPublicaciones

@Composable
fun ListaPublicaciones(
    modificador: Modifier = Modifier,
    controlador_publicaciones: ControladorPublicaciones = hiltViewModel(),
    navegar_a_publicacion: () -> Unit = {}
) {

    Log.v("PantallaPublicacion", "Valor del controlador: ${controlador_publicaciones}")

    controlador_publicaciones.obtener_publicaciones()

    if(controlador_publicaciones.publicaciones.value.size > 0){

        Column(modificador){
            Column(
                modifier = Modifier
                    .background(color = Color.DarkGray)
                    .padding(5.dp)
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState()
                    ))
            {
                for(publicacion in controlador_publicaciones.publicaciones.value){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(color = Color.White)
                            .border(width = 3.dp, color = Color.Gray)
                            .padding(10.dp)
                            .clickable {
                                controlador_publicaciones.seleccionar_publicacion(id = publicacion.id)
                                navegar_a_publicacion()
                            } ){

                        Text("Publicacion: ${publicacion.title}",
                            color = Color.Blue,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace
                        )
                        Text("${publicacion.body}",
                            fontSize = 14.sp,
                            textAlign = TextAlign.Justify)

                    }
                }
            }
        }

    }
    else {
        Text("Disculpa las molestias, pero estamos obteniendo las ultimas publicacicones. Favor de esperar...")
    }
}

@Preview(showBackground = true)
@Composable
fun Previsualizacion(){
    ListaPublicaciones()
}

