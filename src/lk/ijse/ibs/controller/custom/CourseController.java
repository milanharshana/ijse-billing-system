package lk.ijse.ibs.controller.custom;

import lk.ijse.ibs.controller.SuperController;
import lk.ijse.ibs.dto.CourseDto;

import java.util.ArrayList;

public interface CourseController extends SuperController<CourseDto> {
    @Override
    default boolean add(CourseDto dto) throws Exception {
        return false;
    }

    @Override
    default boolean update(CourseDto dto) throws Exception {
        return false;
    }

    @Override
    default boolean delete(String name) throws Exception {
        return false;
    }

    @Override
    default CourseDto search(String name) throws Exception {
        return null;
    }

    @Override
    default ArrayList<CourseDto> getSearched(CourseDto dto) throws Exception {
        return null;
    }

    @Override
    default ArrayList<CourseDto> getAll() throws Exception {
        return null;
    }
}
