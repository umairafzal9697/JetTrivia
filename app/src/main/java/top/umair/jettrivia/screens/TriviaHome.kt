package top.umair.jettrivia.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import top.umair.jettrivia.Questions

@Composable
fun TriviaHome(viewModel: QuestionViewModel = hiltViewModel()){

    Questions(viewModel)

}