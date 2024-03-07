package com.example.pricingpal.model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.util.UUID

/**
 * Object: UUIDSerializer
 * @author Connor Murdock
 * @author Abdoulie NJie
 * @version 2
 * @written 03/06/2024
 * This object acts as a custom serializer that allows instances of the UUID class to be serialized and deserialized using
 * Kotlin Serialization framework to handle UUID data types
 */

object UUIDSerializer : KSerializer<UUID> {
    override val descriptor = PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): UUID {
        return UUID.fromString(decoder.decodeString())
    }

    override fun serialize(encoder: Encoder, value: UUID) {
        encoder.encodeString(value.toString())
    }
}