package top.umair.jettrivia.network

import retrofit2.http.GET
import top.umair.jettrivia.model.Questions
import top.umair.jettrivia.model.QuestionsItem
import javax.inject.Singleton

@Singleton
interface QuestionApi {

    @GET("world.json")
    suspend fun getAllQuestions():ArrayList<QuestionsItem>
}