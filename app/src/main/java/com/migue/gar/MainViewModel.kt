package com.migue.gar

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor():ViewModel(),LifecycleObserver

{

}