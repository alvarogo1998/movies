package com.agalobr.app.data.local.mem

class MemDataStore<M> {

    private val dataStore: MutableMap<String, M> = mutableMapOf()

    fun put(id: String, model: M) {
        dataStore.put(id, model)
    }

    fun getAll() = dataStore.map { entry ->
        entry.value
    }

    fun get(id: String) = dataStore[id]
}