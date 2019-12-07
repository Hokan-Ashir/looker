package ru.hokan.looker.sources.providers.database.dto

import javax.persistence.*

@Entity
@Table(name = "source")
data class Source(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable = false)
        val baseUrl: String,

        @Column(nullable = false)
        val regexp: String,

        @Column(nullable = false)
        var sourceProviderId: Int
)
