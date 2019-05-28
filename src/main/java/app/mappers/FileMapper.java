package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import app.dto.FileDto;
import app.entities.File;

@Component
public class FileMapper implements Mapper<File, FileDto> {

	public FileDto toDTO(File file) {
		
		if(file == null) {
			return null;
		}
		
		FileDto retVal = new FileDto();
			retVal.setId(file.getId());
			retVal.setDescription(file.getDescription());
			retVal.setUrl(file.getUrl());
			return retVal;

	}
	
	public File toEntity(FileDto fileDto) {
		if(fileDto == null) {
			return null;	
		}
		
		File file = new File();
		
		file.setId(fileDto.getId());
		file.setUrl(fileDto.getUrl());
		file.setDescription(fileDto.getDescription());
		
		return file;
	}
	
	public List<FileDto> toDTO(List<File> file){
		if( file == null) {
			return null;
		}
		
		List<FileDto> retVal = new ArrayList<FileDto >();
		for (File files: file) {
			retVal.add(toDTO(files));
		}
		return retVal;
	}

	public Collection<File> toEntity(Collection<FileDto > fileDto){
		if(fileDto == null) {
			return null;
		}
		
		Collection<File> file = new ArrayList<File>(fileDto.size());
		for(FileDto fDto: fileDto) {
			file.add(toEntity(fDto));
		}
		
		return file;
	}

}
