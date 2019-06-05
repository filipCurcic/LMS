package app.mappers;

import java.util.Collection;
import java.util.List;

import app.dto.ForumDto;
import app.entities.Forum;

public class ForumMapper implements Mapper<Forum, ForumDto> {

	@Override
	public ForumDto toDTO(Forum e) {
		if(e == null) {
			return null;
		}
		
		ForumDto retVal = new ForumDto();
		retVal.setId(e.getId());
		retVal.setPublicForum(e.isPublicForum());
		return null;
	}

	@Override
	public Collection<Forum> toEntity(Collection<ForumDto> edto) {
		
		return null;
	}

	@Override
	public List<ForumDto> toDTO(List<Forum> es) {
		
		return null;
	}

	@Override
	public Forum toEntity(ForumDto edtos) {
		
		return null;
	}
	
	
}
