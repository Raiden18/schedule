package com.rv1den.schedule.provider.dependencies

import com.rv1den.schedule.api.client.RestClientImpl
import com.rv1den.schedule.api.facades.GroupsFacadeRestClientImpl
import com.rv1den.schedule.api.parsers.group.GroupParserImpl
import com.rv1den.schedule.api.parsers.groups.GroupsParserImpl
import com.rv1den.schedule.data.repositories.groups.GroupsRepositoryImpl
import com.rv1den.schedule.domain.usecases.groups.GetGroupsUseCaseImpl
import com.rv1den.schedule.mvp.factories.PresenterFactoryImpl
import com.rv1den.schedule.mvp.holders.presenter.PresenterHolder
import com.rv1den.schedule.mvp.holders.presenter.PresenterHolderImpl
import com.rv1den.schedule.navigation.factory.FragmentsFactory
import com.rv1den.schedule.navigation.factory.FragmentsFactoryImpl
import com.rv1den.schedule.navigation.navigator.FragmentNavigator
import com.rv1den.schedule.navigation.navigator.FragmentNavigatorImpl

class GlobalDependenciesProviderImpl : GlobalDependenciesProvider {
    private val restClient = RestClientImpl()
    private val groupParser =  GroupParserImpl()
    private val groupsParser = GroupsParserImpl(groupParser)
    private val groupsFacadeRestClient = GroupsFacadeRestClientImpl(restClient, groupsParser)
    private val groupsRepository = GroupsRepositoryImpl(groupsFacadeRestClient)
    private val groupsUseCase = GetGroupsUseCaseImpl(groupsRepository)
    private val presenterFactory = PresenterFactoryImpl(groupsUseCase)
    private val presenterHolder = PresenterHolderImpl(presenterFactory)
    private val fragmentNavigator = FragmentNavigatorImpl()
    private val fragmentFactory = FragmentsFactoryImpl()

    override fun providePresenterHolder(): PresenterHolder = presenterHolder
    override fun provideFragmentNavigator(): FragmentNavigator = fragmentNavigator
    override fun provideFragmentFactory(): FragmentsFactory = fragmentFactory
}