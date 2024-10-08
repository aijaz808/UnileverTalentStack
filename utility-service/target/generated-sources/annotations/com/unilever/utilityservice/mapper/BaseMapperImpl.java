package com.unilever.utilityservice.mapper;

import com.unilever.utilityservice.dto.BaseDto;
import com.unilever.utilityservice.model.AbstractEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-27T13:46:55+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class BaseMapperImpl implements BaseMapper {

    @Override
    public AbstractEntity convert(BaseDto dto) {

        AbstractEntity abstractEntity = new AbstractEntity();

        if ( dto != null ) {
            abstractEntity.setId( dto.getId() );
        }

        return abstractEntity;
    }

    @Override
    public BaseDto convert(AbstractEntity entity) {

        BaseDto baseDto = new BaseDto();

        if ( entity != null ) {
            baseDto.setId( entity.getId() );
        }

        return baseDto;
    }
}
