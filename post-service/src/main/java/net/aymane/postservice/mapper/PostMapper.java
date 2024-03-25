package net.aymane.postservice.mapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.aymane.postservice.entity.Post;
import net.aymane.postservice.model.PostRequestDto;
import net.aymane.postservice.model.PostResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PostMapper {
//------------------------------------ transformer un objet entity a un objet de type dto ------------------------------
    public PostResponseDto fromEntityToDto(Post post){
        PostResponseDto responseDto = new PostResponseDto();
        BeanUtils.copyProperties(post,responseDto);
        return responseDto;
    }
    // -------------------------- transformer un objet Request dto à entity--------------------------------------------
    public  Post fromRequestDtoToEntity(PostRequestDto postRequestDto){
        Post post = new Post();
        BeanUtils.copyProperties(postRequestDto,post);
        return  post;
    }
}
