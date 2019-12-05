package ru.hokan.looker.proxy.providers.database.dto

import javax.persistence.*

@Entity
@Table(name = "proxyProvider")
data class ProxyProvider(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Int,

        @Column(nullable = false)
        @Enumerated
        val type : ProxyProviderType,

        @Column(nullable = false)
        val source : String,

        @Column(nullable = false)
        val name : String
)