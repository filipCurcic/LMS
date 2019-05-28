package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import app.dto.CountryDto;
import app.dto.FileDto;
import app.entities.City;
import app.entities.Country;
import app.entities.File;

@Component
public class FileMapper implements Mapper<File, FileDto> {

	public FileDto toDTO(File file) {
		FileDto retVal = new FileDto();
			retVal.setId(file.getId());
			retVal.setDescription(file.getDescription());
			retVal.setUrl(file.getUrl());
			return retVal;

	}
	
	public File toEntity(FileDto fileDto) {
		return null;		
	}
	
	public List<FileDto> toDTO(List<File> file){
		List<FileDto> retVal = new ArrayList<FileDto >();
		for (File files: file) {
			retVal.add(toDTO(files));
		}
		return retVal;
	}

	public List<File> toEntity(List<FileDto > fileDto){
		return null;
	}

}
