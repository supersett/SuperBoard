package suuper.sett.superboard.service;

import suuper.sett.superboard.data.dto.BoardDto;

public interface BoardService {
    void boardCreate(String writer,String title,String content);
    BoardDto boardRead(long id);
    void boardUpdate(long id,String title,String content);
    void boardDelete(long id);

}
