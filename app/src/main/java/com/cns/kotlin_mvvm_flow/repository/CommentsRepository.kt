package com.example.kotlin_flow_mvvm.repository

import com.example.kotlin_flow_mvvm.model.CommentModel
import com.example.kotlin_flow_mvvm.network.ApiService
import com.example.kotlin_flow_mvvm.network.CommentApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CommentsRepository(private val apiService: ApiService) {

    /***
     * Function which will call the api and it will return a Flow.
     * Return a flow, It asynchronously performs calculation or function
     * and the emit function emits the data to the receivers which are listening
     * to this flow.
     */
    suspend fun getComment(id: Int): Flow<CommentApiState<CommentModel>> {
        return flow {
            //get the comment Data from the api
            val comment=apiService.getComments(id)

            //Emit this data wrapped in the helper class [CommentApiState]
            emit(CommentApiState.success(comment))
        }.flowOn(Dispatchers.IO)
    }
}