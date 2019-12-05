package ru.hokan.looker.proxy.providers.database.dto

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "proxy")
data class Proxy(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable = false)
        val IP: String,

        @Column(nullable = false)
        val proxyProviderId : Int,

        @Column(nullable = false)
        val timeAdded : Timestamp
)