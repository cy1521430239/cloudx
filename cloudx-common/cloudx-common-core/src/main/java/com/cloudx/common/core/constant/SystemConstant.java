package com.cloudx.common.core.constant;

/**
 * 系统常量
 *
 * @author chachae
 * @since 2020/4/24 18:18
 */
public class SystemConstant {

  private SystemConstant() {
  }

  /**
   * OAUTH 2 令牌类型 https://oauth.net/2/bearer-tokens/
   */
  public static final String OAUTH2_TOKEN_TYPE = "bearer";

  /**
   * 验证码 key前缀
   */
  public static final String CAPTCHA_PREFIX = "cloudx:captcha:";
}
