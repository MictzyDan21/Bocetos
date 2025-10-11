package mx.uacj.demo.hit_y_retrofit.api

import mx.uacj.demo.hit_y_retrofit.modelos.Comentario
import mx.uacj.demo.hit_y_retrofit.modelos.Publicacion
import retrofit2.http.GET
import retrofit2.http.Path

interface JSONPlaceholder{
    @GET("/posts")
    suspend fun obtener_publicaciones(): List<Publicacion> 

    @GET("/post/{id}/comments")
    suspend fun obtener_comentarios_publicacion(@Path("id") id: Int): List<Comentario>
}

