package ca.uwaterloo.walkyourdog.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WalkResponseBody {
    private String status;
    private List<DataInfo> data;
}
