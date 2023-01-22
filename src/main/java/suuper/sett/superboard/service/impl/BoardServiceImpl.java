package suuper.sett.superboard.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suuper.sett.superboard.config.security.JwtTokenProvider;
import suuper.sett.superboard.data.entity.Board;
import suuper.sett.superboard.data.repository.BoardRepository;
import suuper.sett.superboard.data.repository.UserRepository;
import suuper.sett.superboard.service.BoardService;
@Service
public class BoardServiceImpl implements BoardService {

    private final Logger LOGGER = LoggerFactory.getLogger(BoardServiceImpl.class);

    //public UserRepository userRepository;
    //public JwtTokenProvider jwtTokenProvider;
    public BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void boardCreate(String writer, String title, String content) {
        LOGGER.info("[boardCreate] 글 저장 시작");
        Board board;
        board=Board.builder()
                .writer(writer)
                .title(title)
                .content(title)
                .build();

        Board savedBoard =boardRepository.save(board);
        if(!savedBoard.getTitle().isEmpty()){
            LOGGER.info("[boardCreate] 정상 처리 완료");
        } else{
            LOGGER.info("[boardCreate] 실패!!");
        }
    }

    @Override
    public void boardRead(long id) {

    }

    @Override
    public void boardUpdate(long id, String title, String content) {

    }

    @Override
    public void boardDelete(long id) {

    }
}
