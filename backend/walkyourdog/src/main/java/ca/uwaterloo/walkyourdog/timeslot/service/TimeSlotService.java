package ca.uwaterloo.walkyourdog.timeslot.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ca.uwaterloo.walkyourdog.common.entity.DataInfo;
import ca.uwaterloo.walkyourdog.timeslot.dao.TimeSlotDao;

@Named
public class TimeSlotService {
  public TimeSlotDao timeSlotDao;
  @Inject
  public TimeSlotService(TimeSlotDao timeSlotDao){
    this.timeSlotDao = timeSlotDao;
  }

  public List<DataInfo> getVolunteerTimeSlotList(String time){
    List<DataInfo> volunteers = timeSlotDao.getVolunteerProfiles(time);
    return volunteers;
  }

  public List<DataInfo> getDogTimeSlotList(String time){
    List<DataInfo> dogs = timeSlotDao.getDogProfiles(time);
    return dogs;
  }
}
