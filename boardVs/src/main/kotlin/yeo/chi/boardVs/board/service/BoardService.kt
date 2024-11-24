package yeo.chi.boardVs.board.service

import org.springframework.stereotype.Service
import yeo.chi.boardVs.board.persistent.BoardRepository

@Service
class BoardService(
    private val boardRepository: BoardRepository,
) {
    suspend fun findAll() = boardRepository.findAll()
}
