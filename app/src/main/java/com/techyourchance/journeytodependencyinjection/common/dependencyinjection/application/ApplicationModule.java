package com.techyourchance.journeytodependencyinjection.common.dependencyinjection.application;

import com.techyourchance.journeytodependencyinjection.Constants;
import com.techyourchance.journeytodependencyinjection.networking.StackoverflowApi;
import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionDetailsUseCase;
import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionsListUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Where the services are defined that can be provided to client classes
@Module
public class ApplicationModule {

    // to make ApplicationComponent knows what services are composed in module
    // the drawback is we should never call service provided method directly
    // @Singleton is a scope that has the same functionality with the caching strategy
    // It instructs Dagger to cache the instance of a service and returns the same instance
    // every time the provider method is called.
    @Singleton
    @Provides
    Retrofit getRetrofit() {
        // Dagger convention is to get rid of caching to instantiate the instance
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // In order to supply the retrofit as the dependency, we can declare the retrofit as param.
    // Dagger will handle this under the hood automatically by the time we already declare the getRetrofit with @Provide annotation
    // as provided service
    @Singleton
    @Provides
    StackoverflowApi getStackoverflowApi(Retrofit retrofit) {
                // thus, this line which contains "getRetrofit()" should be removed
                //mStackoverflowApi = getRetrofit().create(StackoverflowApi.class);
        return retrofit.create(StackoverflowApi.class);
    }

    @Provides
    FetchQuestionsListUseCase getFetchQuestionsListUseCase(StackoverflowApi stackoverflowApi) {
        return new FetchQuestionsListUseCase(stackoverflowApi);
    }

    @Provides
    FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase(StackoverflowApi stackoverflowApi) {
        return new FetchQuestionDetailsUseCase(stackoverflowApi);
    }

}
