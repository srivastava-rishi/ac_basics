package com.rishi.androicomponents.presentation

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class MyLiveData<T> {
    private var dataHolder : T?= null
    private val hashMapOfObservers : HashMap<(T?) -> Unit, LifeCycleObserverWrapper> = HashMap()

    fun postValue(value : T){
        dataHolder = value
        hashMapOfObservers.values.forEach {
            if(it.lifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)){
                it.observer.invoke(dataHolder)
            }
        }
    }

    fun getValue() = dataHolder

    fun addObserver(lifecycleOwner: LifecycleOwner, observerAction : (T?) -> Unit){
        LifeCycleObserverWrapper(lifecycleOwner, observerAction)
            .apply {
                this.lifecycleOwner.lifecycle.addObserver(this)
                hashMapOfObservers[observerAction] = this
            }
    }

    fun removeObserver(observer: (T?) -> Unit){
        hashMapOfObservers[observer]?.run {
            this.lifecycleOwner.lifecycle.removeObserver(this)
        }
    }

    fun updateValue(observer: (T?) -> Unit){
        observer.invoke(dataHolder)
    }

    private inner class LifeCycleObserverWrapper(
        val lifecycleOwner: LifecycleOwner,
        val observer: (T?) -> Unit
    ) : DefaultLifecycleObserver {

        override fun onStart(owner: LifecycleOwner) {
            updateValue(observer)
        }

        override fun onResume(owner: LifecycleOwner) {
            updateValue(observer)
        }

        override fun onDestroy(owner: LifecycleOwner) {
            removeObserver(observer)
        }
    }
}