package ru.mirea.lab5.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class BreedJsonModel(
    @JsonProperty("name") val name: String,
    @JsonProperty("id") val id: String
)