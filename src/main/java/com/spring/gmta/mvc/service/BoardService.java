package com.spring.gmta.mvc.service;

import com.spring.gmta.mvc.domain.Board;
import com.spring.gmta.mvc.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> getList(){
        return boardRepository.getList();
    };

    public Board get(int boardSeq){
        return boardRepository.get(boardSeq);
    };

    public int save(Board parameter){
        Board board = boardRepository.get(parameter.getBoardSeq());
        if (board == null) {
            boardRepository.save(parameter);
        } else {
            boardRepository.update(parameter);
        }
        return board.getBoardSeq();
    };


    public boolean delete(int boardSeq){
        boardRepository.delete(boardSeq);
        return true;
    };

}
