package com.tecace.retail.kotlinpractice

import org.koin.dsl.module

val appModule = module {

    single<HelloRepository> { HelloRepositoryImpl()}

    factory { MySimplePresenter(get())}
}