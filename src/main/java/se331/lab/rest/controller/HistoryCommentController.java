package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.HistoryComment;
import se331.lab.rest.service.HistoryCommentService;
import se331.lab.rest.util.LabMapper;

@Controller
@RequiredArgsConstructor
public class HistoryCommentController {
    final HistoryCommentService historyCommentService;
    @GetMapping("history")
    public ResponseEntity<?> getCommentHistoryLists(@RequestParam(value ="_limit", required = false) Integer perPage,
                                                    @RequestParam(value = "_page", required = false) Integer page,
                                                    @RequestParam(value = "id", required = false) Long id)
    {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<HistoryComment> pageOutput;
        if (id == null) {
            pageOutput = historyCommentService.getHistoryComment(page-1,perPage);
        } else {
            pageOutput = historyCommentService.getHistoryComments(id, id, PageRequest.of(page-1,perPage));
        }

        HttpHeaders responseHeader = new HttpHeaders();
        return new ResponseEntity<>(LabMapper.INSTANCE.getHistoryCommentDTO(pageOutput.getContent()),responseHeader, HttpStatus.OK);

    }
    @GetMapping("history/{id}")
    public ResponseEntity<?> getCommentHistory(@PathVariable("id") Long id) {
        HistoryComment output = historyCommentService.getHistoryCommentById(id);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getHistoryCommentDTO(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/history")
    public ResponseEntity<?> addCommentHistory(@RequestBody HistoryComment CommentHistory){
        HistoryComment output = historyCommentService.save(CommentHistory);
        return ResponseEntity.ok(LabMapper.INSTANCE.getHistoryCommentDTO(output));
    }

}
