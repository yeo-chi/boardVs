package yeo.chi.boardVs.board.domain

import java.time.LocalDateTime
import java.time.LocalDateTime.now
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
class Board(
    @Id
    val id: Long? = null,
    val userId: String,
    var title: String,
    var content: String?,
    val createdAt: LocalDateTime = now(),
    val createdBy: String,
    val updatedAt: LocalDateTime = now(),
    val deletedAt: LocalDateTime? = null,
)
