package com.muchbeer.start.firstapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Family(
    @JsonProperty("family_name")
    val family_name : String,
    @JsonProperty("family_no")
    val family_no : String,
    @JsonProperty("religin")
    val religin : String
)
