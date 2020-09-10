package com.shijo.realmsearch.models
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

open class Units (

	var activities : RealmList<Activities>? = null,
	var apt : Int? = null,
	var block_id : String? = null,
	var block_name : String? = null,
	var floor : Int? = null,
	@PrimaryKey var id : String? = null,
	var property_id : String? = null,
	var title : String?= null,
	var unit_type : String? = null
) : RealmObject()