package com.all.inone.users.service;

import com.all.inone.users.entity.User;
import com.all.inone.users.repository.UserRespository;
import com.all.inone.users.vo.Department;
import com.all.inone.users.vo.ResponseTemplateVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRespository userRespository;
    private final RestTemplate restTemplate;

    /*public UserService(UserRespository userRespository, RestTemplate restTemplate) {
        this.userRespository = userRespository;
        this.restTemplate = restTemplate;
    }*/

    public User save(User user) {
        log.info("Inside save of UserService.");
        return userRespository.save(user);
    }

    public User findUserById(Long id) {
        log.info("Inside findUserById of UserService.");
        return userRespository.findUserByUserId(id);
    }

    public ResponseTemplateVO findUserByIdWhitDepartment(Long userId) {
        log.info("Inside findUserByIdWhitDepartment of UserService.");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRespository.findUserByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }

}
