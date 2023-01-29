package com.geektech.homework51.presenter

import com.geektech.homework51.view.View
import com.geektech.homework51.model.Model

class Presenter {
    private val model = Model()
    lateinit var view: View

    fun increment(){
        model.increment()
        view.changeCount(model.count)
        if(model.count == +10)
            view.showToastInc()
        if(model.count == +15)
            view.setColour()
    }
    fun attachView (view: View){
        this.view = view
    }
    fun decrement(){
        model.decrement()
        view.changeCount(model.count)
        if(model.count == -10)
            view.showToastDec()
    }


}