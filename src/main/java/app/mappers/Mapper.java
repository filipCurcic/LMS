package app.mappers;

import java.util.List;

public interface Mapper<E, EDTO> {

	EDTO toDTO(E e);
	E toEntity(EDTO edto);
	List<EDTO> toDTO(List<E> es);
	List<E> toEntity(List<EDTO> edtos);

}
