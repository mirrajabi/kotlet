package ir.mirrajabi.kotlet.infrastructure.di.modules

import android.app.Application
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetModule(private val mBaseUrl: String) {
    @Provides
    @Singleton
    fun provideOkHttpCache(application: Application) =
            Cache(application.cacheDir, DEFAULT_OK_HTTP_CACHE_SIZE.toLong())

    @Provides
    @Singleton
    fun provideOkHttp(cache: Cache) : OkHttpClient =
            OkHttpClient.Builder()
                .cache(cache)
                .readTimeout(DEFAULT_OK_HTTP_REQUEST_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_OK_HTTP_RESPONSE_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
                .connectTimeout(DEFAULT_OK_HTTP_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
                .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build()

    companion object {
        internal var DEFAULT_OK_HTTP_CACHE_SIZE = 10 * 1024 * 1024
        internal var DEFAULT_OK_HTTP_TIMEOUT_SECONDS = 30
        internal var DEFAULT_OK_HTTP_REQUEST_TIMEOUT_SECONDS = DEFAULT_OK_HTTP_TIMEOUT_SECONDS
        internal var DEFAULT_OK_HTTP_RESPONSE_TIMEOUT_SECONDS = DEFAULT_OK_HTTP_TIMEOUT_SECONDS
    }
}