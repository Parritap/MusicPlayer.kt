package model

import model.logic.SongsProducer

object Singleton {

    init {
        SongsProducer.produce
    }
}