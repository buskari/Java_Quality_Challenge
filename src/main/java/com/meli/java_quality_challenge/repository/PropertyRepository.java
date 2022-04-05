package com.meli.java_quality_challenge.repository;

import com.meli.java_quality_challenge.model.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PropertyRepository implements IRepository<Property> {
    List<Property> propertyList = new ArrayList<>();

    @Override
    public List<Property> create(List<Property> propertys) {
        propertyList.addAll(propertys);
        return propertys;
    }

    @Override
    public List<Property> read() {
        return propertyList;
    }

    @Override
    public Property read(UUID id) {
        List<Property> list = propertyList
                .stream()
                .filter(
                        property -> property.getId().equals(id)
                ).collect(Collectors.toList());

        if (list.size() == 1) {
            return list.get(0);
        }

        throw new RuntimeException("There is no property with id " + id);
    }

    @Override
    public Property update(Property propertyToUpdate) {
        UUID id = propertyToUpdate.getId();
        List<Property> list = propertyList.stream().filter(property -> property.getId().equals(id)).collect(Collectors.toList());

        if (list.size() == 1) {
            propertyList.set(propertyList.indexOf(list.get(0)), propertyToUpdate);
            return propertyToUpdate;
        }

        throw new RuntimeException("There is no property with id " + id + ". Please, create a new one");
    }

    @Override
    public String delete(UUID id) {
        List<Property> list = propertyList.stream().filter(property -> property.getId().equals(id)).collect(Collectors.toList());

        if (list.size() == 1) {
            propertyList.remove(list.get(0));
            return "The property of id " + id + " was successfully deleted";
        }

        throw new RuntimeException("There is no property with id " + id + "to delete");
    }
}
