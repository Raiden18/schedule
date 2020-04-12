package com.rv1den.schedule.provider.dependencies

import com.rv1den.schedule.api.client.RestClientImpl
import com.rv1den.schedule.api.facades.GroupsFacadeRestClientImpl
import com.rv1den.schedule.api.facades.ScheduleFacadeRestClientImpl
import com.rv1den.schedule.api.mappers.day.SchoolDayMapperImpl
import com.rv1den.schedule.api.mappers.group.GroupsMapperImpl
import com.rv1den.schedule.api.mappers.lesson.LessonResponseMapperImpl
import com.rv1den.schedule.api.mappers.lesson.factory.LessonFactoryImpl
import com.rv1den.schedule.api.mappers.schedule.ScheduleMapperImpl
import com.rv1den.schedule.api.mappers.weeks.even.EvenWeekMapperImpl
import com.rv1den.schedule.api.mappers.weeks.factory.WeekFactoryImpl
import com.rv1den.schedule.api.mappers.weeks.odd.OddWeekMapperImpl
import com.rv1den.schedule.async_framework_impl.JavaConcurrentExecutor
import com.rv1den.schedule.data.repositories.group.GroupRepositoryImpl
import com.rv1den.schedule.data.repositories.groups.GroupsRepositoryImpl
import com.rv1den.schedule.data.repositories.schedule.ScheduleRepositoryImpl
import com.rv1den.schedule.domain.usecases.group.SaveGroupUseCase
import com.rv1den.schedule.domain.usecases.groups.GetGroupsUseCaseImpl
import com.rv1den.schedule.domain.usecases.schedule.GetScheduleForSavedGroup
import com.rv1den.schedule.lifecycle.FragmentLifeCycleCallbacks
import com.rv1den.schedule.mvp.factories.PresenterFactoryImpl
import com.rv1den.schedule.mvp.holders.presenter.PresenterHolderImpl
import com.rv1den.schedule.navigation.factory.FragmentsFactoryImpl
import com.rv1den.schedule.navigation.navigator.FragmentNavigatorImpl

class GlobalDependenciesProviderImpl : GlobalDependenciesProvider {
    //Api
    private val restClient = RestClientImpl()

    //Api Mappers
    private val groupsParser = GroupsMapperImpl()
    private val lessonFactory = LessonFactoryImpl()
    private val lessonResponseMapper =  LessonResponseMapperImpl(lessonFactory)
    private val schoolDayMapper = SchoolDayMapperImpl(lessonResponseMapper)
    private val weekFactory = WeekFactoryImpl(schoolDayMapper)
    private val evenWeekMapper = EvenWeekMapperImpl(weekFactory)
    private val oddWeekMapper = OddWeekMapperImpl(weekFactory)
    private val scheduleMapper = ScheduleMapperImpl(evenWeekMapper, oddWeekMapper)

    //Facades
    private val groupsFacadeRestClient = GroupsFacadeRestClientImpl(restClient, groupsParser)
    private val scheduleFacadeRestClient = ScheduleFacadeRestClientImpl(restClient, scheduleMapper)

    //Repositories
    private val groupsRepository = GroupsRepositoryImpl(groupsFacadeRestClient)
    private val groupRepository = GroupRepositoryImpl()
    private val scheduleRepository = ScheduleRepositoryImpl(scheduleFacadeRestClient)

    //UseCases
    private val groupsUseCase = GetGroupsUseCaseImpl(groupsRepository)
    private val saveGroupUseCase = SaveGroupUseCase(groupRepository)
    private val getScheduleForSavedGroup = GetScheduleForSavedGroup(
        scheduleRepository,
        groupRepository
    )

    //Presentation
    private val javaConcurrentExecutor = JavaConcurrentExecutor()
    private val presenterFactory = PresenterFactoryImpl(groupsUseCase, javaConcurrentExecutor, saveGroupUseCase, getScheduleForSavedGroup)
    private val presenterHolder = PresenterHolderImpl(presenterFactory)
    private val fragmentNavigator = FragmentNavigatorImpl()
    private val fragmentFactory = FragmentsFactoryImpl()
    private val fragmentLifecycleCallbacks = FragmentLifeCycleCallbacks(presenterHolder)


    //Providers
    override fun provideFragmentLifecycleCallbacks() = fragmentLifecycleCallbacks
    override fun provideFragmentNavigator() = fragmentNavigator
    override fun provideFragmentFactory() = fragmentFactory
}