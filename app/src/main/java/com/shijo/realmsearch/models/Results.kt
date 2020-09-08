package com.shijo.realmsearch.models
import io.realm.RealmList
import io.realm.RealmObject


open class Results (

	var block_name : String? = null,
	var units : RealmList<Units>? = null
) : RealmObject()