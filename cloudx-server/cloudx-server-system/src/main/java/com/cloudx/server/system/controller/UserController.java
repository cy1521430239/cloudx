package com.cloudx.server.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cloudx.common.core.base.QueryParam;
import com.cloudx.common.core.base.R;
import com.cloudx.common.core.entity.dto.SystemUserDTO;
import com.cloudx.common.core.entity.system.SystemUser;
import com.cloudx.common.core.util.PageUtil;
import com.cloudx.server.system.service.IUserService;
import java.util.Map;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息控制层
 *
 * @author chachae
 * @since 2020/4/30 19:56
 */

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  private final IUserService userService;

  @GetMapping("/page")
  @PreAuthorize("hasAuthority('user:view')")
  public R<Map<String, Object>> pageUser(QueryParam queryParam, SystemUserDTO user) {
    IPage<SystemUserDTO> result = userService.pageSystemUser(queryParam, user);
    Map<String, Object> pageResult = PageUtil.toPage(result);
    return R.ok(pageResult);
  }

  @GetMapping("/check/{userName}")
  public boolean checkUserName(@PathVariable("userName") String userName) {
    SystemUser result = userService.selectByUserName(userName);
    return result != null;
  }

  @PostMapping("/add")
  @PreAuthorize("hasAuthority('user:add')")
  public void add(@Valid SystemUserDTO user) {
    userService.insert(user);
  }

  @PutMapping("/update/{userId}")
  @PreAuthorize("hasAuthority('user:update')")
  public void update(@PathVariable("userId") Long id, @Valid SystemUserDTO user) {
    userService.update(id, user);
  }

  @DeleteMapping("/delete/{userId}")
  @PreAuthorize("hasAuthority('user:delete')")
  public void delete(@PathVariable("userId") Long id) {
    userService.delete(id);
  }

}
