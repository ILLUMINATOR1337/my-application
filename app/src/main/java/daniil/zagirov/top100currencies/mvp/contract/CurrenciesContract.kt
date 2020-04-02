package daniil.zagirov.top100currencies.mvp.contract

import daniil.zagirov.top100currencies.adapter.CurrenciesAdapter

//Интерфейс View содержит функции добавления новых валют в список, оповещения
//адаптера об изменениях списка, отображении /скрытии прогрессбара, отображения ошибки
//и функцию обновления. Презентер содержит функции создания и обновления списка
//криптовалют.

class CurrenciesContract {
    interface View : BaseContract.View {
        fun addCurrency(currency: CurrenciesAdapter.Currency)
        fun notifyAdapter()
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(error: String?)
        fun refresh()
    }

    abstract class Presenter : BaseContract.Presenter<View>() {
        abstract fun makeList()
        abstract fun refreshList()
    }
}