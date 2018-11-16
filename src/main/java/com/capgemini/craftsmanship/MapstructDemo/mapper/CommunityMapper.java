package com.capgemini.craftsmanship.MapstructDemo.mapper;

import com.capgemini.craftsmanship.MapstructDemo.entity.CommunityEntity;
import com.capgemini.craftsmanship.MapstructDemo.service.PersonService;
import com.capgemini.craftsmanship.MapstructDemo.to.CommunityCto;
import com.capgemini.craftsmanship.MapstructDemo.to.CommunityEto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(uses = {PersonMapper.class})
public abstract class CommunityMapper {

    @Autowired
    private PersonService personService;

    @Mapping(target = "personId", source = "coordinator.id")
    public abstract CommunityEto mapEntityToEto(CommunityEntity source);

    @Mapping(target = "coordinator", ignore = true) //resolved with aftermapping
    public abstract CommunityEntity mapEtoToEntity(CommunityEto source);

    @AfterMapping
    protected void resolveCoordinator(CommunityEto source, @MappingTarget CommunityEntity target) {
        target.setCoordinator(personService.findById(source.getPersonId()));
    }

    @Mappings({
            @Mapping(target = "community", source = "entity"),
            @Mapping(target = "person", source = "coordinator"),
    })
    public abstract CommunityCto mapEntityToCto(CommunityEntity entity);

    @Mappings({
            @Mapping(target = "id", source = "community.id"),
            @Mapping(target = "version", source = "community.version"),
            @Mapping(target = "name", source = "community.name"),
            @Mapping(target = "coordinator", source = "person"),
    })
    public abstract CommunityEntity mapCtoToEntity(CommunityCto cto);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "version", ignore = true),
            @Mapping(target = "coordinator", ignore = true)
    })
    public abstract void copyAttributes(CommunityEto source, @MappingTarget CommunityEntity target);


}
