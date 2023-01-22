package suuper.sett.superboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public void createBoard(Principal principal,String title, String content){
        boardService.boardCreate(principal.getName(),title,content);

    }



}
