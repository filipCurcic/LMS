package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import app.dto.ForumReplyDto;
import app.dto.ForumUserDto;
import app.entities.ForumReply;
import app.entities.ForumUser;

public class ForumUserMapper implements Mapper<ForumUser, ForumUserDto> {
	
	@Autowired
	RegisteredUserMapper regMapper;
	
	@Autowired
	ForumReplyMapper replyMapper;

	@Override
	public ForumUserDto toDTO(ForumUser e) {
		if (e == null) {
			return null;
		}
		
		ForumUserDto retVal = new ForumUserDto();
		retVal.setId(e.getId());
		retVal.setRegisteredUser(regMapper.toDTO(e.getRegisteredUser()));
		retVal.setReplyIds(new ArrayList<>());
		for (ForumReply r : e.getReplies()) {
			retVal.getReplyIds().add(r.getId());
		}
		retVal.setRoles(e.getRoles().stream().map(r -> r.getId()).collect(Collectors.toSet()));
		retVal.setReplies(e.getReplies().stream().map(r -> r.getId()).collect(Collectors.toSet()));
		retVal.setStartedThreads(e.getStartedThreads().stream().map(r -> r.getId()).collect(Collectors.toSet()));
		
		return retVal;
	}

	@Override
	public Collection<ForumUser> toEntity(Collection<ForumUserDto> edto) {
		if(edto == null) {
			return null;
		}
		
		Collection<ForumUser> user = new ArrayList<ForumUser>(edto.size());
		for(ForumUserDto uDto: edto) {
			user.add(toEntity(uDto));
		}
		
		return user;
	}

	@Override
	public List<ForumUserDto> toDTO(List<ForumUser> es) {
		if(es == null) {
			return null;
		}
		
		List<ForumUserDto> retVal = new ArrayList<ForumUserDto>();
		for (ForumUser user: es) {
			retVal.add(toDTO(user));
		}
		return retVal;
	}

	@Override
	public ForumUser toEntity(ForumUserDto edtos) {
		if (edtos==null) {
			return null;
		}
		
		ForumUser user = new ForumUser();
		user.setId(edtos.getId());
		user.setRegisteredUser(regMapper.toEntity(edtos.getRegisteredUser()));
//		Mora da se napravi servis prvo
//		user.setReplies(edtos.getReplies().stream().map(id -> roleService.findOne(id)).collect(Collectors.toSet()));
		

		return null;
		
	}

}
