Feature: 1001-用户中心-SC
  1. 登录 2. 校验

  @get
  Scenario Outline:  心跳(SC0101)
    When I send a GET request to "/api/sc/heartbeat"
    Then the response status should be "200"
    Then the JSON response "<jsonPath>" equals "<value>"
    Examples:
      | jsonPath     | value             |
      | result       | 000000             |
