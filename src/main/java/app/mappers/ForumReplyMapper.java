package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import app.dto.ForumReplyDto;
import app.entities.ForumReply;

public class ForumReplyMapper implements Mapper<ForumReply, ForumReplyDto> {
	
	@Autowired
	ForumUserMapper userMapper;

	
	@Autowired
	ForumThreadMapper threadMapper;
	
	@Override
	public ForumReplyDto toDTO(ForumReply e) {
		if(e==null) {
			return null;
		}
		ForumReplyDto retVal = new ForumReplyDto();
		retVal.setId(e.getId());
		retVal.setForumThreadId(e.getForumThread().getId());
		retVal.setContent(e.getContent());
		retVal.setAuthor(userMapper.toDTO(e.getAuthor()));
		return null;
	}

	@Override
	public Collection<ForumReply> toEntity(Collection<ForumReplyDto> edto) {
		if(edto == null) {
			return null;
		}
		
		Collection<ForumReply> reply = new ArrayList<ForumReply>(edto.size());
		for(ForumReplyDto rDto: edto) {
			reply.add(toEntity(rDto));
		}
		
		return reply;

	}

	@Override
	public List<ForumReplyDto> toDTO(List<ForumReply> es) {
		if(es == null) {
			return null;
		}
		
		List<ForumReplyDto> retVal = new ArrayList<ForumReplyDto>();
		for (ForumReply reply: es) {
			retVal.add(toDTO(reply));
		}
		return retVal;
	}

	@Override
	public ForumReply toEntity(ForumReplyDto edtos) {
		if (edtos==null) {
			return null;
		}
		
		ForumReply reply = new ForumReply();
		
		reply.setId(edtos.getId());
		reply.setAuthor(userMapper.toEntity(edtos.getAuthor()));
		reply.setContent(edtos.getContent());
		reply.setForumThread(threadMapper.toEntity(edtos.getThread()));
		
		
		return reply;
	
	}
	
	

}
