package home.pokeman.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import home.pokeman.AppConstants
import home.pokeman.data.api.ApiService
import home.pokeman.data.dataSource.PokeManDataSourceImpl
import home.pokeman.data.repository.PokeManRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

	@Provides
	@Singleton
	fun providesRetrofit(): Retrofit {
		val httpLoggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
		
		val httpClient = OkHttpClient().newBuilder().apply { addInterceptor(httpLoggingInterceptor) }
		
		httpClient.apply { readTimeout(60, TimeUnit.SECONDS) }
		
		val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
		
		return Retrofit.Builder()
			.baseUrl(AppConstants.BASE_URL)
			.client(httpClient.build())
			.addConverterFactory(MoshiConverterFactory.create(moshi))
			.build()
	}
	
	@Provides
	@Singleton
	fun providesApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
	
	@Provides
	@Singleton
	fun providesPokeManDataSource(apiService: ApiService) = PokeManDataSourceImpl(apiService)
	
	@Provides
	@Singleton
	fun providesPokeManRepository(pokeManDataSource: PokeManDataSourceImpl) = PokeManRepository(pokeManDataSource)
}