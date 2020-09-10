package com.shijo.realmsearch.models
import io.realm.RealmList
import io.realm.RealmObject
import java.io.Serializable


open class Results (

	var block_name : String? = null,
	var units : RealmList<Units>? = null
) : RealmObject()