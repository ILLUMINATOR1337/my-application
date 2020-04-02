package daniil.zagirov.top100currencies.di

import dagger.Module
import dagger.Provides
import daniil.zagirov.top100currencies.mvp.presenter.CurrenciesPresenter
import daniil.zagirov.top100currencies.mvp.presenter.LatestChartPresenter
import javax.inject.Singleton

@Module
class MvpModule {
    @Provides
    @Singleton
    fun provideCurrenciesPresenter(): CurrenciesPresenter = CurrenciesPresenter()

    @Provides
    @Singleton
    fun provideLatestChartPresenter(): LatestChartPresenter = LatestChartPresenter()
}