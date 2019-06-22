package ca.uwaterloo.walkyourdog.timeslot.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import ca.uwaterloo.walkyourdog.common.entity.DataInfo;

@Mapper
public interface TimeSlotDao {

  String volnTimeSlotSelect = "SELECT "
      + " v.name, v.img, v.rating, v.volnid as id "
      + " FROM Volunteer AS v "
      + " LEFT JOIN TimeSlot AS t "
      + " ON v.volnid = t.volnid ";

  String dogTimeSlotSelect = "SELECT "
      + " d.name, d.img, d.rating, d.dogid as id "
      + " FROM Dog AS d "
      + " LEFT JOIN TimeSlot AS t "
      + " ON d.dogid=t.dogid ";

  String volnTimeSlotInsert = "INSERT "
      + " INTO "
      + " TimeSlot (`time`, volnid) ";

  @Select(volnTimeSlotSelect + " WHERE `time` = #{time} " )
  List<DataInfo> getVolunteerProfiles(@Param("time") String time);

  @Select(dogTimeSlotSelect + " WHERE `time` = #{time} ")
  List<DataInfo> getDogProfiles(@Param("time") String time);

}

