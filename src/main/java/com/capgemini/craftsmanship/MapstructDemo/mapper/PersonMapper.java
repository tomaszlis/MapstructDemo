package com.capgemini.craftsmanship.MapstructDemo.mapper;

import com.capgemini.craftsmanship.MapstructDemo.entity.PersonEntity;
import com.capgemini.craftsmanship.MapstructDemo.to.PersonEto;
import com.capgemini.craftsmanship.MapstructDemo.type.NewPosition;
import com.capgemini.craftsmanship.MapstructDemo.type.Position;
import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

import java.time.LocalDateTime;

@Mapper
public abstract class PersonMapper {

    @Mapping(target = "lastName", source = "surname")
    public abstract PersonEto mapToEto(PersonEntity entity);

    @Mappings({
            @Mapping(target = "lastUpdateTime", ignore = true),
            @Mapping(target = "surname", source = "lastName")
    })
    public abstract PersonEntity mapToEntity(PersonEto eto);

    @AfterMapping
    protected void mapAdditionally(PersonEto source, @MappingTarget PersonEntity target) {
        if (source.getDepartment().equals("RSPI")) {
            target.setLastUpdateTime(LocalDateTime.MAX);
        } else {
            target.setLastUpdateTime(LocalDateTime.MIN);
        }
    }


    protected String mapPositionType(Position source) {
        String result;
        if (source == Position.DEVELOPER) {
            result = "OK";
        } else {
            result = "Hmm...";
        }
        return result;
    }

    @ValueMappings({
            @ValueMapping(source = "A", target = "ARCHITECT"),
            @ValueMapping(source = "BA", target = "BA"),
            @ValueMapping(source = "M", target = "MANAGER"),
            @ValueMapping(source = "D", target = "DEVELOPER")
    })
    protected abstract Position toPosition(NewPosition source);

    @InheritInverseConfiguration
    protected abstract NewPosition toNewPosition(Position source);

}
