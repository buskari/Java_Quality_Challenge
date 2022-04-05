package com.meli.java_quality_challenge.repository;

import com.meli.java_quality_challenge.model.District;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DistrictRepository implements IRepository<District> {
    List<District> districtList = new ArrayList<>();

    @Override
    public List<District> create(List<District> districts) {
        districtList.addAll(districts);
        return districts;
    }

    @Override
    public List<District> read() {
        return districtList;
    }

    @Override
    public District read(UUID id) {
        List<District> list = districtList
                .stream()
                .filter(
                        district -> district.getId().equals(id)
                ).collect(Collectors.toList());

        if (list.size() == 1) {
            return list.get(0);
        }

        throw new RuntimeException("There is no district with id " + id);
    }

    @Override
    public District update(District districtToUpdate) {
        UUID id = districtToUpdate.getId();
        List<District> list = districtList.stream().filter(district -> district.getId().equals(id)).collect(Collectors.toList());

        if (list.size() == 1) {
            districtList.set(districtList.indexOf(list.get(0)), districtToUpdate);
            return districtToUpdate;
        }

        throw new RuntimeException("There is no district with id " + id + ". Please, create a new one");
    }

    @Override
    public String delete(UUID id) {
        List<District> list = districtList.stream().filter(district -> district.getId().equals(id)).collect(Collectors.toList());

        if (list.size() == 1) {
            districtList.remove(list.get(0));
            return "The district of id " + id + " was successfully deleted";
        }

        throw new RuntimeException("There is no district with id " + id + "to delete");
    }
}
