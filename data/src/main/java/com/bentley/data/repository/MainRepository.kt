package com.bentley.data.repository

import com.bentley.data.state.DataState
import com.project.noticeme.data.room.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber

class MainRepository
constructor(
    private val consumableDao: ConsumableDao,
    private val userConsumableDao: UserConsumableDao,
    private val searchHistoryDao: SearchHistoryDao
) {
    suspend fun insertConsumable(consumables: List<ConsumableEntity>): Flow<DataState<Boolean>> =

        flow {
            emit(DataState.Loading)
            delay(1000)

            try {
                for (consumable in consumables) {
                    consumableDao.insert(consumable)
                }
                emit(DataState.Success(true))
            } catch (e: Exception) {
                emit(DataState.Error(e))
//                Sentry.captureException(java.lang.Exception("Exception - $e"))
            }
        }

    suspend fun findConsumableWithCategory(search: String): Flow<DataState<List<ConsumableEntity>>> =
        flow {

            emit(DataState.Loading)
            delay(1000)
            try {
                val resultList = consumableDao.findConsumableWithCategory(search)
                emit(DataState.Success(resultList))
            } catch (e: Exception) {
                emit(DataState.Error(e))
//                Sentry.captureException(java.lang.Exception("Exception - $e"))
            }
        }

    suspend fun findConsumableWithTitle(title: String): Flow<DataState<List<ConsumableEntity>>> =
        flow {

            emit(DataState.Loading)
            delay(1000)
            try {
                val result = consumableDao.findConsumableWithTitle(title)
                Timber.d("${result.size}")
                emit(DataState.Success(result))
            } catch (e: Exception) {
                emit(DataState.Error(e))
//                Sentry.captureException(java.lang.Exception("Exception - $e"))
            }
        }

    suspend fun insertUserConsumable(userConsumables: UserConsumableEntity): Flow<DataState<Boolean>> =
        flow {
            emit(DataState.Loading)
            delay(1000)
            try {
                userConsumableDao.insert(userConsumables)
                emit(DataState.Success(true))
            } catch (e: Exception) {
                emit(DataState.Error(e))
//                Sentry.captureException(java.lang.Exception("Exception - $e"))
            }
        }

    suspend fun getUserConsumable(): Flow<DataState<List<UserConsumableEntity>>> =
        flow {
            emit(DataState.Loading)
            delay(1000)
            try {
                val resultList = userConsumableDao.get()
                emit(DataState.Success(resultList))
            } catch (e: Exception) {
                emit(DataState.Error(e))
//                Sentry.captureException(java.lang.Exception("Exception - $e"))
            }
        }

    suspend fun getUserConsumableFromDetail(): Flow<List<UserConsumableEntity>> =
        flow {
            delay(1000)
            try {
                val resultList = userConsumableDao.get()
                emit(resultList)
            } catch (e: Exception) {
                Timber.e(e)
//                Sentry.captureException(java.lang.Exception("Exception - $e"))
            }
        }

    suspend fun delete(item: UserConsumableEntity): Flow<DataState<Boolean>> =
        flow {
            emit(DataState.Loading)
            delay(1000)
            try {
                userConsumableDao.delete(item)
                emit(DataState.Success(true))
            } catch (e: Exception) {
                emit(DataState.Error(e))
//                Sentry.captureException(java.lang.Exception("Exception - $e"))
            }
        }

    suspend fun deleteFromDetail(item: UserConsumableEntity): Flow<DataState<Boolean>> =
        flow {
            emit(DataState.Loading)
            delay(1000)
            try {
                userConsumableDao.delete(item)
                emit(DataState.Success(true))
            } catch (e: Exception) {
                emit(DataState.Error(e))
            }
        }

    suspend fun getUserConsumableWithTitle(input: String): Flow<DataState<UserConsumableEntity>> =
        flow {
            emit(DataState.Loading)
            delay(1000)
            try {
                val resultList = userConsumableDao.getWithTitle(input)
                emit(DataState.Success(resultList))
            } catch (e: Exception) {
                emit(DataState.Error(e))
//                Sentry.captureException(java.lang.Exception("Exception - $e"))
            }
        }

    suspend fun update(item: UserConsumableEntity): Flow<DataState<Boolean>> =
        flow {
            emit(DataState.Loading)
            delay(1000)
            try {
                userConsumableDao.update(item)
                emit(DataState.Success(true))
            } catch (e: Exception) {
                emit(DataState.Error(e))
//                Sentry.captureException(java.lang.Exception("Exception - $e"))
            }
        }

    suspend fun insertCustomConsumable(consumable: ConsumableEntity): Flow<DataState<Boolean>> =
        flow {
            emit(DataState.Loading)
            delay(1000)

            try {
                consumableDao.insert(consumable)
                emit(DataState.Success(true))
            } catch (e: Exception) {
                emit(DataState.Error(e))
//                Sentry.captureException(java.lang.Exception("Exception - $e"))
            }
        }

    suspend fun insertSearchHistory(userHistory: SearchHistoryEntity): Flow<DataState<Boolean>> =
        flow {
            emit(DataState.Loading)
            delay(1000)

            try {
                searchHistoryDao.insert(userHistory)
                emit(DataState.Success(true))
            } catch (e: Exception) {
                emit(DataState.Error(e))
//                Sentry.captureException(java.lang.Exception("Exception - $e"))
            }
        }

    suspend fun getSearchHistory(): Flow<DataState<List<SearchHistoryEntity>>> =
        flow {
            emit(DataState.Loading)
            delay(1000)
            try {
                val resultList = searchHistoryDao.get()
                emit(DataState.Success(resultList))
            } catch (e: Exception) {
                emit(DataState.Error(e))
//                Sentry.captureException(java.lang.Exception("Exception - $e"))
            }
        }

    suspend fun deleteAllHistory(): Flow<DataState<Boolean>> =
        flow {
            emit(DataState.Loading)
            delay(1000)
            try {
                searchHistoryDao.deleteAll()
                emit(DataState.Success(true))
            } catch (e: Exception) {
                emit(DataState.Error(e))
//                Sentry.captureException(java.lang.Exception("Exception - $e"))
            }
        }

    suspend fun deleteHistory(userHistory: SearchHistoryEntity): Flow<DataState<Boolean>> =
        flow {
            emit(DataState.Loading)
            delay(1000)
            try {
                searchHistoryDao.delete(userHistory)
                emit(DataState.Success(true))
            } catch (e: Exception) {
                emit(DataState.Error(e))
//                Sentry.captureException(java.lang.Exception("Exception - $e"))
            }
        }

    suspend fun getLastItem(): ConsumableEntity {
        return consumableDao.getLastItem()
    }
}

