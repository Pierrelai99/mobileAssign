package com.example.assgntmobile0921.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(
    tableName = "orders",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["userId"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["userId"])]
)
data class Order(
    @PrimaryKey(autoGenerate = true) val orderId: Long = 0, // Primary key
    @ColumnInfo(name = "userId") val userId: Long, // Foreign key to OrderList entity

    @ColumnInfo(name = "orderType") val orderType: String, // E.g., "Pick up" or "Delivery"
    @ColumnInfo(name = "tableNo") val tableNo: Int? = null, // Nullable field for table number if dining in

    @ColumnInfo(name = "totalPrice") val totalPrice: Double, // Total price for the entire order
    @ColumnInfo(name = "status") val status: String, // E.g., "Pending", "Completed"
    @ColumnInfo(name = "createDate") val createDate: Date // Date the order was created
)