package suuper.sett.superboard.controller;

import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import suuper.sett.superboard.data.dto.BoardDto;
import suuper.sett.superboard.service.BoardService;

import java.security.Principal;

@RestController
@RequestMapping("/api/board")
public class BoardController {
    private final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping(value = "/create")
    public void createBoard(Principal principal, @RequestBody BoardDto boardDto){
        boardService.boardCreate(principal.getName(), boardDto.getTitle(), boardDto.getContent());
        LOGGER.info("[토큰에서 정보빼오기] 로그인유저 이름 :{}",principal.getName());
    }

    @GetMapping(value = "/{id}")
    public BoardDto getBoard(@PathVariable(value = "id") long id){
        BoardDto whatIWant = boardService.boardRead(id);
        return whatIWant;
    }


}
