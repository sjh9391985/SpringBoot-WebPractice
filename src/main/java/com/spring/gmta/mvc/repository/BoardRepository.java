package com.spring.gmta.mvc.repository;

import com.spring.gmta.mvc.domain.Board;
import com.spring.gmta.mvc.paramter.BoardParameter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository {

    List<Board> getList();

    Board get(int boardSeq);

    void save(BoardParameter board);

    void update(BoardParameter board);

    void delete(int boardSeq);

}
