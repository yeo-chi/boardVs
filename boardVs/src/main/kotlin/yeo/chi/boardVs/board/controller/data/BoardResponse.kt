package yeo.chi.boardVs.board.controller.data

import java.time.LocalDateTime
import yeo.chi.boardVs.board.domain.Board

data class BoardResponse(
    val id: Long,
    val userId: String,
    val title: String,
    val content: String? = null,
    val createdAt: LocalDateTime,
    val createdBy: String,
    val updatedAt: LocalDateTime,
    val deletedAt: LocalDateTime? = null,
) {
    constructor(board: Board) : this(
        id = requireNotNull(board.id),
        userId = board.userId,
        title = board.title,
        content = board.content,
        createdAt = board.createdAt,
        createdBy = board.createdBy,
        updatedAt = board.updatedAt,
        deletedAt = board.deletedAt,
    )
}