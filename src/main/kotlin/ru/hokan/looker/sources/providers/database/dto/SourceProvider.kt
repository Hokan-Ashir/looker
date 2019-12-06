package ru.hokan.looker.sources.providers.database.dto

import javax.persistence.*

@Entity
@Table(name = "sourceProvider")
data class SourceProvider(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable = false)
        @Enumerated
        val sourceProviderType: SourceProviderType,

        @Column(nullable = false)
        val name: String,

        @Column(nullable = false)
        val source: String
)