package net.aymane.commentservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.aymane.commentservice.entity.Comment;
import net.aymane.commentservice.exception.CommentNotFoundException;
import net.aymane.commentservice.mapper.CommentMapper;
import net.aymane.commentservice.model.CommentDto;
import net.aymane.commentservice.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CommentServiceImp implements CommentService {
    private CommentRepository commentRepository;
    private CommentMapper commentMapper;
    @Override
    public void addComment(CommentDto commentDto) {
        log.info("comment posted");
        commentDto.setComment(commentDto.getComment());
        commentDto.setPublicationId(commentDto.getPublicationId());
        Comment comment = commentMapper.fromDtoToEntity(commentDto);
        commentRepository.save(comment);
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto) throws CommentNotFoundException {
        log.info("your comment is updated");
        Comment comment = commentMapper.fromDtoToEntity(commentDto);
        Comment comment1 = commentRepository.findById(comment.getId()).orElseThrow(()->new CommentNotFoundException("impossible"));
        comment1.setContent(comment.getContent());
        Comment comment2 = commentRepository.save(comment1);
        return commentMapper.fromEntityToDto(comment2);
    }

    @Override
    public List<CommentDto> allComments() {
        List<Comment> commentList = commentRepository.findAll();
        return commentList.stream().map(commentMapper::fromEntityToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteComment(Long id) throws CommentNotFoundException {
        log.info("your comment is deleted");
        Comment comment = commentRepository.findById(id).orElseThrow(()->new CommentNotFoundException("comment not found"));
        commentRepository.delete(comment);
    }

    @Override
    public CommentDto getComment(Long id) throws CommentNotFoundException {
        Comment comment = commentRepository.findById(id).orElseThrow(()->new CommentNotFoundException("comment not found"));
        return commentMapper.fromEntityToDto(comment);
    }
}
