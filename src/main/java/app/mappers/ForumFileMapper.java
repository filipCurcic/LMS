package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import app.dto.ForumFileDto;
import app.dto.SubForumDto;
import app.entities.ForumFile;
import app.entities.ForumSubForum;

public class ForumFileMapper implements Mapper<ForumFile, ForumFileDto> {

	@Override
	public ForumFileDto toDTO(ForumFile e) {
		if(e == null) {
			return null;
		}
		ForumFileDto retVal = new ForumFileDto();
		retVal.setId(e.getId());
		retVal.setDescription(e.getDescription());
		retVal.setUrl(e.getUrl());
		return null;
	}

	@Override
	public Collection<ForumFile> toEntity(Collection<ForumFileDto> edto) {
		if(edto == null) {
			return null;
		}
		
		Collection<ForumFile> forumFile = new ArrayList<ForumFile>(edto.size());
		for(ForumFileDto fDto: edto) {
			forumFile.add(toEntity(fDto));
		}
		
		return forumFile;

	}

	@Override
	public List<ForumFileDto> toDTO(List<ForumFile> es) {
		if(es == null) {
			return null;
		}
		
		List<ForumFileDto> retVal = new ArrayList<ForumFileDto>();
		for (ForumFile file: es) {
			retVal.add(toDTO(file));
		}
		return retVal;
		
	}

	@Override
	public ForumFile toEntity(ForumFileDto edtos) {
		if (edtos==null) {
			return null;
		}
		
		ForumFile file= new ForumFile();
		file.setId(edtos.getId());
		file.setDescription(edtos.getDescription());
		file.setUrl(edtos.getUrl());
		return null;
	}

}
