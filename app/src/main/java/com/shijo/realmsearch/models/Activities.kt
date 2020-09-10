package com.shijo.realmsearch.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable


open class Activities(

	var activity_name : String? = null,
	var activity_status : String? =null,
	var current_user_name : String? = null,
	@PrimaryKey var id : String? = null,
	var step_name : String? = null,
	var progress : Int? = null,
	var wf : String? = null
) : RealmObject()