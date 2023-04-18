package top.umair.jettrivia.repository

import top.umair.jettrivia.data.DataOrException
import top.umair.jettrivia.model.Questions
import top.umair.jettrivia.model.QuestionsItem
import top.umair.jettrivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor( private val api : QuestionApi) {

    private val dataOrException = DataOrException<ArrayList<QuestionsItem>,Boolean,Exception>()

        suspend fun getAllQuestions():DataOrException<ArrayList<QuestionsItem>,Boolean,Exception>{

            try {
                dataOrException.loading = true
                dataOrException.data = api.getAllQuestions()
                if (dataOrException.data.toString().isNotEmpty())
                    dataOrException.loading = false
            }catch (ex :Exception){
                dataOrException.e =ex
            }

            return dataOrException
        }

}