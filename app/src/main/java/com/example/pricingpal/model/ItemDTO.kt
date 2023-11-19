package com.example.pricingpal.model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.util.UUID

/**
 * Class: CategoryDTO
 * @author Connor Murdock
 * @version 1
 * @written 11/08/2023
 * This data class acts as an interface to transfer data of our Item objects to and from the database.
 */
@Serializable
data class ItemDTO(
    @SerialName("id")
    val itemId: Int,
    @SerialName("name")
    val itemName: String,
    @SerialName("price")
    val price: Float,
    @SerialName("category_id")
    val categoryId: Int,
    @SerialName("organization_id")
    @Serializable(with = UUIDSerializer::class)
    val organizationId: UUID
)


object UUIDSerializer : KSerializer<UUID> {
    override val descriptor = PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): UUID {
        return UUID.fromString(decoder.decodeString())
    }

    override fun serialize(encoder: Encoder, value: UUID) {
        encoder.encodeString(value.toString())
    }
}