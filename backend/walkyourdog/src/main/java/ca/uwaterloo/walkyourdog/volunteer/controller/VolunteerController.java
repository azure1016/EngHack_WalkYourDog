package ca.uwaterloo.walkyourdog.volunteer.controller;

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
import ca.uwaterloo.walkyourdog.volunteer.service.VolunteerService;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {
  public VolunteerService volunteerService;
  @Inject
  public VolunteerController(VolunteerService volunteerService){
    this.volunteerService = volunteerService;
  }
  @RequestMapping(value = "",method = RequestMethod.GET)
  public ResponseEntity<WalkResponseBody> getVolunteerProfile(@RequestParam(name = "id", defaultValue = "") String id)
      throws IOException {

    List<DataInfo> volunteerEntities =
        volunteerService.getVolunteerProfile(id);

    return new ResponseEntity<>(
        WalkResponseBody.builder()
            .status(WalkResponseStatus.MESSAGE_FOUND.getAppCode())
            .data(volunteerEntities)
            .build(),
        HttpStatus.OK);
  }
}
