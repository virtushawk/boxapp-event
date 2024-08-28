package com.virtushawk.boxappevent.service.feign;

import com.virtushawk.boxappevent.model.dto.controller.UserRegistrationCreateDTO;
import com.virtushawk.boxappevent.model.dto.controller.UserRegistrationDTO;
import com.virtushawk.boxappevent.model.service.BulkUserRequestDTO;
import java.util.List;
import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@FeignClient("user")
public interface UserFeignClient {

    @PostMapping(path = "v1/users/data", consumes = "application/json")
    List<UserRegistrationDTO> fetchUsersData(@RequestBody BulkUserRequestDTO userRequestDTO);
}
