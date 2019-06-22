package ca.uwaterloo.walkyourdog.volunteer.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import ca.uwaterloo.walkyourdog.common.entity.DataInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({"id", "name", "rating", "img"})
public class VolunteerEntity  {
  private String id;
  private String name;
  private String rating;
  private String img;
}
