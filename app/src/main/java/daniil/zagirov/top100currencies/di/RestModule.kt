package daniil.zagirov.top100currencies.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import daniil.zagirov.top100currencies.rest.CoinGeckoApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class RestModule {

    //Функция provideGson() создает конвертер для сериализации данных типа Gson
    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder()
            .setLenient()
            .create()

    //Функция provideOkHttpClient() создает клиент OkHttpClient, используемый библиотекой
    //Retrofit для HTTP-запросов
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

    //Функция provideGeckoRetrofit() создает Retrofit клиент, передает базовый адрес запроса,
    //расширен адаптерами для взаимодействия с другими библиотеками, такими как RxJava, с
    //помощью вызова метода addCallAdapterFactory билдера. При использовании адаптера
    //RxJava2CallAdapterFactory интерфейсы Retrofit могут возвращать типы RxJava 2.x,
    //например, Observable, Flowable или Single и т. д.
    @Provides
    @Singleton
    @Named("COINGECKO_API")
    fun provideGeckoRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

    //Функция provideGeckoApiService() предоставляет подготовленный объект CoinGeckoApi
    @Provides
    @Singleton
    fun provideGeckoApiService(@Named("COINGECKO_API") retrofit: Retrofit): CoinGeckoApi =
        retrofit.create(CoinGeckoApi::class.java)
}