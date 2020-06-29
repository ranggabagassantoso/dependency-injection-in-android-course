package com.techyourchance.journeytodependencyinjection.common.dependencyinjection.presentation;

import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionDetailsUseCase;
import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionsListUseCase;
import com.techyourchance.journeytodependencyinjection.questions.Question;
import com.techyourchance.journeytodependencyinjection.screens.common.dialogs.DialogsManager;
import com.techyourchance.journeytodependencyinjection.screens.common.mvcviews.ViewMvcFactory;
import com.techyourchance.journeytodependencyinjection.screens.questiondetails.QuestionDetailsActivity;
import com.techyourchance.journeytodependencyinjection.screens.questionslist.QuestionsListActivity;

import dagger.Component;

@Component(modules = PresentationModule.class)
public interface PresentationComponent {
//    DialogsManager getDialogsManager();
//    ViewMvcFactory getViewMvcFactory();
//    FetchQuestionsListUseCase getFetchQuestionsListUseCase();
//    FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase();

    // injection method to a client specified in param
    void inject(QuestionsListActivity activity);

    // the name of "inject" is not a must. Below is the example of random name 
    void blabla(QuestionDetailsActivity activity);
}
