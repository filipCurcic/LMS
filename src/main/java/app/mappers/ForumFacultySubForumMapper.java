package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import app.dto.SubFacultyForumDto;

import app.entities.ForumSubFacultyForum;
import app.entities.ForumSubForum;

public class ForumFacultySubForumMapper implements Mapper<ForumSubFacultyForum, SubFacultyForumDto>  {
	
	@Autowired
	FacultyMapper facultyMaper;
	
	@Autowired
	ForumMapper forumMapper;

	@Override
	public SubFacultyForumDto toDTO(ForumSubFacultyForum e) {
		if(e == null) {
			return null;
		}
		
		SubFacultyForumDto retVal = new SubFacultyForumDto();
		retVal.setId(e.getId());
		retVal.setForumId(e.getForum().getId());
		retVal.setSubForumEndpoints(new ArrayList<>());
		
		for (ForumSubForum s : e.getSubForums()) {
			retVal.getSubForumEndpoints().add("/forum/facultySubForum/"+e.getId()+"/subForums/"+s.getId());
		}

		
		retVal.setFaculty(facultyMaper.toDTO(e.getFaculty()));
		
		return retVal;
	}

	@Override
	public Collection<ForumSubFacultyForum> toEntity(Collection<SubFacultyForumDto> facultySubForumDto) {
		if(facultySubForumDto == null) {
			return null;
		}
		Collection<ForumSubFacultyForum> subForum = new ArrayList<ForumSubFacultyForum>(facultySubForumDto.size());
		for(SubFacultyForumDto fDto: facultySubForumDto) {
			subForum.add(toEntity(fDto));
		}
		
		return subForum;
	}

	@Override
	public List<SubFacultyForumDto> toDTO(List<ForumSubFacultyForum> es) {
		
		if(es == null) {
			return null;
		}
		
		List<SubFacultyForumDto> retVal = new ArrayList<SubFacultyForumDto >();
		for (ForumSubFacultyForum subFacultyforums: es) {
			retVal.add(toDTO(subFacultyforums));
		}
		return retVal;

	}

	@Override
	public ForumSubFacultyForum toEntity(SubFacultyForumDto subForumDto) {
		if (subForumDto==null) {
			return null;
		}
		
		ForumSubFacultyForum subFacultyForum = new ForumSubFacultyForum();
		
		subFacultyForum.setId(subForumDto.getId());
		subFacultyForum.setForum(forumMapper.toEntity(subForumDto.getForum()));
		subFacultyForum.setFaculty(facultyMaper.toEntity(subForumDto.getFaculty()));
		//subforumi	
		return subFacultyForum;
	}

	

}
