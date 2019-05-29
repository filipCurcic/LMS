package app.mappers;

import java.util.Collection;
import java.util.List;

public interface Mapper<E, EDTO> {

	EDTO toDTO(E e);
	Collection<E> toEntity(Collection<EDTO> edto);
	List<EDTO> toDTO(List<E> es);
	E toEntity(EDTO edtos);

}
