package yeo.chi.boardVs.board.controller

import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import yeo.chi.boardVs.board.controller.data.BoardResponse
import yeo.chi.boardVs.board.service.BoardService

@RestController
@RequestMapping("api/v1/boards")
class BoardController(
    private val boardService: BoardService,
) {
    @GetMapping
    @ResponseBody
    suspend fun findAll() =
        boardService.findAll()
            .fold(
                ifLeft = { badRequest().body(Flux.empty()) },
                ifRight = { result -> ok().body(result.map { BoardResponse(it) }) },
            )
}
