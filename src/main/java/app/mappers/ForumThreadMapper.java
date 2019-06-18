package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import app.dto.ThreadDto;
import app.entities.ForumReply;
import app.entities.ForumThread;

public class ForumThreadMapper implements Mapper<ForumThread, ThreadDto> {
	
	@Autowired
	ForumUserMapper userMapper;
	
	@Autowired
	ForumFileMapper fileMapper;
	
	@Autowired
	ForumSubForumMapper subMapper;
	
	@Autowired
	ForumReplyMapper replyMapper;
	

	@Override
	public ThreadDto toDTO(ForumThread e) {
		if(e == null) {
			return null;
		}
		
		ThreadDto retVal = new ThreadDto();
		retVal.setId(e.getId());
		retVal.setContent(e.getContent());
		retVal.setDateOfCreation(e.getDateOfCreation());
		retVal.setAuthor(userMapper.toDTO(e.getAuthor()));
		retVal.setFile(fileMapper.toDTO(e.getFile()));
		retVal.setReplyEndpoints(new ArrayList<String>());
		for (ForumReply r : e.getReplies()) {
			retVal.getReplyEndpoints().add("/"+r.getId());
		}
		
		
		return null;
	}

	@Override
	public Collection<ForumThread> toEntity(Collection<ThreadDto> edto) {
		if(edto == null) {
			return null;
		}
		
		Collection<ForumThread> thread = new ArrayList<ForumThread>(edto.size());
		for(ThreadDto tDto: edto) {
			thread.add(toEntity(tDto));
		}
		
		return thread;
	}

	@Override
	public List<ThreadDto> toDTO(List<ForumThread> es) {
		if(es == null) {
			return null;
		}
		
		List<ThreadDto> retVal = new ArrayList<ThreadDto>();
		for (ForumThread threads: es) {
			retVal.add(toDTO(threads));
		}
		return retVal;
	}

	@Override
	public ForumThread toEntity(ThreadDto edtos) {
		if (edtos==null) {
			return null;
		}
		
		ForumThread thread= new ForumThread();
		thread.setId(edtos.getId());
		thread.setAuthor(userMapper.toEntity(edtos.getAuthor()));
		thread.setContent(edtos.getContent());
		thread.setDateOfCreation(edtos.getDateOfCreation());
		thread.setFile(fileMapper.toEntity(edtos.getFile()));
//		ne znam kako da popravim ovo
//		thread.setReplies(replyMapper.toEntity(edtos.getReplies()));
		thread.setSubForum(subMapper.toEntity(edtos.getSubForum()));
		return thread;
	}

}
