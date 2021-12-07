package com.example.titresresto.listanddetails.di

import android.app.Application
import androidx.room.Room
import com.example.titresresto.BuildConfig
import com.example.titresresto.listanddetails.feature.data.locale.TransactionDataBase
import com.example.titresresto.listanddetails.feature.data.remote.TransactionDataSource
import com.example.titresresto.listanddetails.feature.data.remote.TransactionService
import com.example.titresresto.listanddetails.feature.data.repository.TransactionRepositoryImpl
import com.example.titresresto.listanddetails.feature.domain.repository.TransactionRepository
import com.example.titresresto.listanddetails.feature.domain.usecases.GetTransactionUseCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson : Gson): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideUserService(retrofit: Retrofit): TransactionService =
        retrofit.create(TransactionService::class.java)

    @Singleton
    @Provides
    fun provideUserRemoteDataSource(transactionService: TransactionService) =
        TransactionDataSource(transactionService)

    @Singleton
    @Provides
    fun provideTransactionDataBase(app:Application) : TransactionDataBase {
        return Room.databaseBuilder(
            app,
            TransactionDataBase::class.java,
            TransactionDataBase.DATABASE_NAME
        ).build()
    }


    @Provides
    @Singleton
    fun provideAlbumRepository(db: TransactionDataBase, transactionDataSource: TransactionDataSource): TransactionRepository {
        return TransactionRepositoryImpl(
            db,
            transactionDataSource
        )
    }

    @Provides
    @Singleton
    fun provideGetAlbumsUseCase(repository: TransactionRepository): GetTransactionUseCase {
        return GetTransactionUseCase(repository)
    }
}