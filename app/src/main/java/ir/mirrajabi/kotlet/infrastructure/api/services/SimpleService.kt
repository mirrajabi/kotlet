package ir.mirrajabi.kotlet.infrastructure.api.services

import io.reactivex.Observable
import ir.mirrajabi.kotlet.infrastructure.api.models.CommentModel
import ir.mirrajabi.kotlet.infrastructure.api.models.PostModel
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleService {
    @GET("/posts")
    fun getPosts() : Observable<ArrayList<PostModel>>
    @GET("/posts/{id}")
    fun getPost(@Path("id") postId: Int) : Observable<PostModel>
    @GET("/posts/{id}/comments")
    fun getCommentsForPost(@Path("id") postId: Int) : Observable<ArrayList<CommentModel>>
}