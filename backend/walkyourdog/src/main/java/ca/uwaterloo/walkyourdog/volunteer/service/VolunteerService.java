package ca.uwaterloo.walkyourdog.volunteer.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ca.uwaterloo.walkyourdog.common.entity.DataInfo;
import ca.uwaterloo.walkyourdog.volunteer.dao.VolunteerDao;
import ca.uwaterloo.walkyourdog.volunteer.entity.VolunteerEntity;

@Named
public class VolunteerService {
  VolunteerDao volunteerDao;
  @Inject
  public VolunteerService(VolunteerDao volunteerDao){
    this.volunteerDao = volunteerDao;
  }

  public List<DataInfo> getVolunteerProfile(String id){
    List<DataInfo> volunteerEntity = volunteerDao.getVolunteerProfile(id);
    return volunteerEntity;
  }

}
