package com.spring.gmta.mvc.controller;

import com.spring.gmta.mvc.domain.Board;
import com.spring.gmta.mvc.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board") // 시작 시 "/board" 주소를 타고 들어와야합니다.
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public List<Board> getList(){
        return boardService.getList();
    };

    @GetMapping("/{boardSeq}")
    public Board get(@PathVariable int boardSeq){
        return boardService.get(boardSeq);
    };

    @GetMapping("/save")
    public int save(Board parameter){
        boardService.save(parameter);
        return parameter.getBoardSeq();
    };

    @GetMapping("/delete/{boardSeq}")
    public boolean delete(@PathVariable int boardSeq){
        Board board = boardService.get(boardSeq);
        // 없는 데이터 삭제할 경우 false return 합니다.
        if(board == null){
            return false;
        }
        boardService.delete(boardSeq);
        return true;
    };
}
