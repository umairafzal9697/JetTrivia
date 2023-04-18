package top.umair.jettrivia.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import top.umair.jettrivia.data.DataOrException
import top.umair.jettrivia.model.Questions
import top.umair.jettrivia.model.QuestionsItem
import top.umair.jettrivia.repository.QuestionRepository
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val repository: QuestionRepository) :
    ViewModel() {
     val data: MutableState<DataOrException<ArrayList<QuestionsItem>, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))


    init {
        getAllQuestions()
    }


    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestions()
            if (data.value.data.toString().isNotEmpty()) {
                data.value.loading = false

            }

        }
    }

    fun getTotalQuestionCount():Int{
        return data.value.data?.toMutableList()?.size!!
    }
}