package net.aymane.commentservice.mapper;

import net.aymane.commentservice.entity.Comment;
import net.aymane.commentservice.model.CommentDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CommentMapper {


    public CommentDto fromEntityToDto (Comment comment){
        CommentDto commentDto = new CommentDto();
        BeanUtils.copyProperties(comment,commentDto);
    return commentDto;
    }

    public Comment fromDtoToEntity(CommentDto commentDto){
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto,comment);
        return comment;
    }
}
