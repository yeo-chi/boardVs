package yeo.chi.boardVs.board.persistent

import arrow.core.right
import java.time.LocalDateTime
import java.time.LocalDateTime.*
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.*
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository
import yeo.chi.boardVs.board.domain.Board

@Repository
class BoardRepository(
    private val databaseClient: DatabaseClient,
) {
    fun findAll() = databaseClient
        .sql("select * from board")
        .fetch()
        .all()
        .map { it.toDomain() }
        .right()
}

fun Map<String, Any>.toDomain() = Board(
    id = this["id"] as Long,
    userId = this["userId"] as String,
    title = this["title"] as String,
    content = this["content"] as String?,
    createdAt = this["created_at"] as LocalDateTime,
    createdBy = this["created_by"] as String,
    updatedAt = this["updated_at"] as LocalDateTime,
    deletedAt = this["deleted_at"] as LocalDateTime?,
)
