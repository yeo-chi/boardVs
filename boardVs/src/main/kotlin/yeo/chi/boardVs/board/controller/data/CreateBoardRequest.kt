package yeo.chi.boardVs.board.controller.data

import yeo.chi.boardVs.board.domain.Board

data class CreateBoardRequest(
    val userId: String,
    val nickName: String,
    val title: String,
    val content: String,
) {
    fun toDomain() = Board(
        userId = userId,
        title = title,
        content = content,
        createdBy = nickName,
    )
}
