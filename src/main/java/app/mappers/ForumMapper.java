package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import app.dto.CityDto;
import app.dto.ForumDto;
import app.entities.City;
import app.entities.Forum;
import app.entities.ForumSubFacultyForum;
import app.entities.ForumUser;

public class ForumMapper implements Mapper<Forum, ForumDto> {
	
	
	@Autowired
	

	@Override
	public ForumDto toDTO(Forum e) {
		if(e == null) {
			return null;
		}
		ForumDto retVal = new ForumDto();
		retVal.setId(e.getId());
		retVal.setPublicForum(e.isPublicForum());
		retVal.setSubForums(new ArrayList<>());
		
		
		for (ForumSubFacultyForum s : e.getSubForums()) {
			retVal.getSubForums().add("/forum/facultySubForum/"+s.getId());
		}
		
		retVal.setUsers(new ArrayList<>());
		for (ForumUser u : e.getUsers()) {
			retVal.getUsers().add("/forum/users/"+u.getId());
		}
		

		retVal.setSubForumsObjects(e.getSubForums());
		
		
		return null;
	}

	@Override
	public Collection<Forum> toEntity(Collection<ForumDto> forumDto) {
		if(forumDto == null) {
			return null;
		}
		Collection<Forum> forum = new ArrayList<Forum>(forumDto.size());
		for(ForumDto fDto: forumDto) {
			forum.add(toEntity(fDto));
		}
		
		return forum;
		
	}

	@Override
	public List<ForumDto> toDTO(List<Forum> forum) {
		if(forum == null) {
			return null;
		}
		
		List<ForumDto> retVal = new ArrayList<ForumDto >();
		for (Forum forums: forum) {
			retVal.add(toDTO(forums));
		}
		return retVal;

	}

	@Override
	public Forum toEntity(ForumDto forumDto) {
		if(forumDto == null) {
			return null;
		}
		Forum forum = new Forum();
		forum.setId(forumDto.getId());
		forum.setPublicForum(forumDto.isPublicForum());
//		forum.setSubForums(forum.getSubForums());
//		forum.setUsers(forum.getUsers());
		return forum;
		
	}
	
	
}
