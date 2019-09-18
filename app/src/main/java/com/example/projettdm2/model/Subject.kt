package com.example.projettdm2.model

import com.example.projettdm2.view.Observer

interface Subject {
    abstract var observers : ArrayList<Observer>
    fun addSubject(o:Observer){
        observers.add(o)
    }
    fun update()
}