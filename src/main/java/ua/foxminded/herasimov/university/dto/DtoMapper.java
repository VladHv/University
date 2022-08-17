package ua.foxminded.herasimov.university.dto;

public interface DtoMapper<T extends Dto, S> {

    T toDto(S entity);

    S toEntity(T dto);
}
