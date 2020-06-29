package com.techyourchance.journeytodependencyinjection.common.dependencyinjection.application;

import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionDetailsUseCase;
import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionsListUseCase;

import javax.inject.Singleton;

import dagger.Component;

// Dagger Components is CompositionRoots
@Singleton // since one of the provider is annotated with @Singleton, thus the ApplicationComponent should also be annotated with @Singleton
@Component(modules = ApplicationModule.class) // integrate between ApplicationModule and ApplicationComponent
public interface ApplicationComponent {
    // To make the services exposed from the ApplicationComponent, the services should be mentioned here
    // using public modifier
    public FetchQuestionsListUseCase getFetchQuestionsListUseCase();
    public FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase();
}
