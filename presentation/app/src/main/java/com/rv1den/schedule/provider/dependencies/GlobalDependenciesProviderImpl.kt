package com.rv1den.schedule.provider.dependencies

import com.rv1den.schedule.api.client.RestClientImpl
import com.rv1den.schedule.api.facades.GroupsFacadeRestClientImpl
import com.rv1den.schedule.api.facades.ScheduleFacadeRestClientImpl
import com.rv1den.schedule.api.mappers.*
import com.rv1den.schedule.api.mappers.factories.lesson.LessonFactoryImpl
import com.rv1den.schedule.api.mappers.factories.week.WeekFactoryImpl
import com.rv1den.schedule.async_framework_impl.JavaConcurrentExecutor
import com.rv1den.schedule.data.repositories.group.GroupRepositoryImpl
import com.rv1den.schedule.data.repositories.groups.GroupsRepositoryImpl
import com.rv1den.schedule.data.repositories.schedule.ScheduleRepositoryImpl
import com.rv1den.schedule.domain.usecases.group.SaveGroupUseCase
import com.rv1den.schedule.domain.usecases.groups.GetGroupsUseCaseImpl
import com.rv1den.schedule.domain.usecases.schedule.GetScheduleForSavedGroup
import com.rv1den.schedule.domain.usecases.schedule.SaveSchoolDayUseCase
import com.rv1den.schedule.lifecycle.FragmentLifeCycleCallbacks
import com.rv1den.schedule.mvp.factories.PresenterFactoryImpl
import com.rv1den.schedule.mvp.holders.presenter.PresenterHolderImpl
import com.rv1den.schedule.navigation.factory.FragmentsFactoryImpl
import com.rv1den.schedule.navigation.navigation.fragments.GroupsNavigatorImpl
import com.rv1den.schedule.navigation.navigation.fragments.WeeksNavigatorImpl
import com.rv1den.schedule.navigation.navigation.router.RouterImpl

class GlobalDependenciesProviderImpl : GlobalDependenciesProvider {
    //Navigation
    //Api
    private val restClient = RestClientImpl()

    //Api Mappers
    private val groupsParser = GroupsMapper()
    private val lessonFactory = LessonFactoryImpl()
    private val lessonResponseMapper = LessonResponseMapper(lessonFactory)
    private val schoolDayMapper = SchoolDayMapper(lessonResponseMapper)
    private val weekFactory = WeekFactoryImpl(schoolDayMapper)
    private val evenWeekMapper = EvenWeekMapper(weekFactory)
    private val oddWeekMapper = OddWeekMapper(weekFactory)
    private val scheduleMapper = ScheduleMapper(evenWeekMapper, oddWeekMapper)

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
    private val saveSchoolDay = SaveSchoolDayUseCase(scheduleRepository)

    //Navigation
    private val router = RouterImpl()
    private val groupsNavigator = GroupsNavigatorImpl(router)
    private val weeksNavigator = WeeksNavigatorImpl(router)

    //Presentation
    private val javaConcurrentExecutor = JavaConcurrentExecutor()

    private val presenterFactory = PresenterFactoryImpl(
        groupsUseCase,
        javaConcurrentExecutor,
        saveGroupUseCase,
        getScheduleForSavedGroup,
        groupsNavigator,
        saveSchoolDay,
        weeksNavigator
    )
    private val presenterHolder = PresenterHolderImpl(presenterFactory)
    private val fragmentFactory = FragmentsFactoryImpl()
    private val fragmentLifecycleCallbacks = FragmentLifeCycleCallbacks(presenterHolder)


    //Providers

    override fun provideFragmentLifecycleCallbacks() = fragmentLifecycleCallbacks
    override fun provideRouter() = router
    override fun provideFragmentFactory() = fragmentFactory
}