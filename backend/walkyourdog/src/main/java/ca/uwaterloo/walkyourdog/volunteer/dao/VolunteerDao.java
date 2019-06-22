package ca.uwaterloo.walkyourdog.volunteer.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import ca.uwaterloo.walkyourdog.common.entity.DataInfo;

@Mapper
public interface VolunteerDao {

  String volunteerSelect = "SELECT " +
      " * " +
      " FROM " +
      " Volunteer ";


  @Select(volunteerSelect + "WHERE volnid = #{id}")
  List<DataInfo> getVolunteerProfile(@Param("id")String id);

}
