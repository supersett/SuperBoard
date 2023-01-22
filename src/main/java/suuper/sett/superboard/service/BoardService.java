package suuper.sett.superboard.service;

public interface BoardService {
    void boardCreate(String writer,String title,String content);
    void boardRead(long id);
    void boardUpdate(long id,String title,String content);
    void boardDelete(long id);

}
