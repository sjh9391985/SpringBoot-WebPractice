package com.spring.gmta.mvc.controller;

import com.spring.gmta.mvc.domain.Board;
import com.spring.gmta.mvc.paramter.BoardParameter;
import com.spring.gmta.mvc.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/board") // 시작 시 "/board" 주소를 타고 들어와야합니다.
@Api(tags = "게시판 API") // swagger 문서
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    @ApiOperation(value = "목록 조회", notes = "게시물 목록 정보를 조회할 수 있습니다.")
    public List<Board> getList(){
        return boardService.getList();
    };

    @GetMapping("/{boardSeq}")
    @ApiOperation(value = "상세 조회", notes = "게시물 번호에 해당하는 상세 정보를 조회할 수 있습니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1")
    })
    public Board get(@PathVariable int boardSeq){
        return boardService.get(boardSeq);
    };


    @PutMapping("/save")
    @ApiOperation(value = "등록 / 수정 처리", notes = "신규 게시물 저장 및 기존 게시물 업데이트가 가능합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1"),
            @ApiImplicitParam(name = "title", value = "제목", example = "spring"),
            @ApiImplicitParam(name = "contents", value = "내용", example = "spring 강좌"),
    })
    public int save(BoardParameter parameter){
        boardService.save(parameter);
        return parameter.getBoardSeq();
    };

    @DeleteMapping("/{boardSeq}")
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
