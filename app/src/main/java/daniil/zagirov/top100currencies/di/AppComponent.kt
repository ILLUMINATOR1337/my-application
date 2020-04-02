package daniil.zagirov.top100currencies.di

import dagger.Component
import daniil.zagirov.top100currencies.activity.ChartActivity
import daniil.zagirov.top100currencies.activity.MainActivity
import daniil.zagirov.top100currencies.chart.LatestChart
import daniil.zagirov.top100currencies.fragments.CurrenciesListFragment
import daniil.zagirov.top100currencies.mvp.presenter.CurrenciesPresenter
import daniil.zagirov.top100currencies.mvp.presenter.LatestChartPresenter
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class, RestModule::class, MvpModule::class, ChartModule::class))
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(presenter: CurrenciesPresenter)
    fun inject(presenter: LatestChartPresenter)
    fun inject(fragment: CurrenciesListFragment)
    fun inject(activity: ChartActivity)
    fun inject(chart: LatestChart)
}