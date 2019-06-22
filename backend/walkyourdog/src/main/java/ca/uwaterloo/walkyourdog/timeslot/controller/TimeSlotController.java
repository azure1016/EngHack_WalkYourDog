package ca.uwaterloo.walkyourdog.timeslot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import ca.uwaterloo.walkyourdog.common.entity.DataInfo;
import ca.uwaterloo.walkyourdog.common.entity.WalkResponseBody;
import ca.uwaterloo.walkyourdog.common.entity.WalkResponseStatus;
import ca.uwaterloo.walkyourdog.timeslot.service.TimeSlotService;

@RestController
@RequestMapping("/timeslot")
public class TimeSlotController {
  public TimeSlotService timeSlotService;
  @Inject
  public TimeSlotController(TimeSlotService timeSlotService){
    this.timeSlotService = timeSlotService;
  }
  @RequestMapping(value = "",method = RequestMethod.GET)
  public ResponseEntity<WalkResponseBody> getProfileInTheTimeSlot(
      @RequestParam(name = "time") String time,
      @RequestParam(name = "volunteerid", defaultValue = "")String volunteerid,
      @RequestParam(name = "dogid", defaultValue = "")String dogid)
      throws IOException {

    if (volunteerid!=""){
      List<DataInfo> timeSlotEntities = timeSlotService.getDogTimeSlotList(time);
      return new ResponseEntity<>(
          WalkResponseBody.builder()
              .status(WalkResponseStatus.MESSAGE_FOUND.getAppCode())
              .data(timeSlotEntities)
              .build(),
          HttpStatus.OK);
    }

    if(dogid!=""){
      List<DataInfo> timeSlotEntities = timeSlotService.getVolunteerTimeSlotList(time);
      return new ResponseEntity<>(
          WalkResponseBody.builder()
              .status(WalkResponseStatus.MESSAGE_FOUND.getAppCode())
              .data(timeSlotEntities)
              .build(),
          HttpStatus.OK);
    }

      return new ResponseEntity<>(
          WalkResponseBody.builder()
              .status(WalkResponseStatus.MESSAGE_NOT_FOUND.getAppCode())
              .build(),
          HttpStatus.BAD_REQUEST);

  }

  @RequestMapping(value = "",method = RequestMethod.POST)
  public ResponseEntity<WalkResponseBody> postTimeSlot(
      @RequestParam(name = "time") String time,
      @RequestParam(name = "volunteerid", defaultValue = "")String volunteerid,
      @RequestParam(name = "dogid", defaultValue = "")String dogid)
      throws IOException {

    if (volunteerid!=""){

    }

    if(dogid!=""){

    }

    return new ResponseEntity<>(
        WalkResponseBody.builder()
            .status(WalkResponseStatus.MESSAGE_NOT_FOUND.getAppCode())
            .build(),
        HttpStatus.BAD_REQUEST);

  }
}
