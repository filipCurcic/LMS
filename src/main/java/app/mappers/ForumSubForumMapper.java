package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import app.dto.SubForumDto;
import app.entities.ForumSubFacultyForum;
import app.entities.ForumSubForum;
import app.entities.ForumThread;

public class ForumSubForumMapper implements Mapper<ForumSubForum, SubForumDto> {
	
	@Autowired
	StudyCoureseMapper studyCourseMapper;
	
	@Autowired
	ForumThreadMapper threadMapper;
	
	@Autowired
	ForumFacultySubForumMapper subFacultyMapper;

	@Override
	public SubForumDto toDTO(ForumSubForum e) {
		if(e == null) {
			return null;
		}
		
		SubForumDto retVal = new SubForumDto();
		retVal.setId(e.getId());
		retVal.setName(e.getName());
		retVal.setStudyCourseId(e.getId());
		retVal.setSubFacultyForumId(e.getSubFacultyForum().getId());
		
		retVal.setThreadEndpoints(new ArrayList<>());
		for (ForumThread t : e.getThreads()) {
			retVal.getThreadEndpoints().add("/forum/facultySubForum/"+e.getSubFacultyForum().getFaculty().getId()+"/subForums/"+e.getId()+"/threads/"+t.getId());
		}
		
		return retVal;
	}

	@Override
	public Collection<ForumSubForum> toEntity(Collection<SubForumDto> edto) {
		if(edto == null) {
			return null;
		}
		
		Collection<ForumSubForum> subForum = new ArrayList<ForumSubForum>(edto.size());
		for(SubForumDto fDto: edto) {
			subForum.add(toEntity(fDto));
		}
		
		return subForum;

	}

	@Override
	public List<SubForumDto> toDTO(List<ForumSubForum> es) {
		
		if(es == null) {
			return null;
		}
		
		List<SubForumDto> retVal = new ArrayList<SubForumDto>();
		for (ForumSubForum subForums: es) {
			retVal.add(toDTO(subForums));
		}
		return retVal;
		
		
	}

	@Override
	public ForumSubForum toEntity(SubForumDto subForumDto) {
		if (subForumDto==null) {
			return null;
		}
		
		ForumSubForum subForum= new ForumSubForum();
		
		subForum.setId(subForumDto.getId());
		subForum.setName(subForumDto.getName());
		subForum.setStudyCourse(subForum.getStudyCourse());
		
		
		
		subForum.setSubFacultyForum(subFacultyMapper.toEntity(subForumDto.getSubFacultyForumDto()));
		
		//ne znam kako da popravim
		//subForum.setThreads(threadMapper.toEntity(subForumDto.getThreads()));
		return subForum;
	}

	
}
