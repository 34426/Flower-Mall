package com.mall.common.result;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@ApiModel(value = "全局统一返回结果")
public class R {

  @ApiModelProperty(value = "是否成功")
  private Boolean success;
  @ApiModelProperty(value = "返回码")
  private Integer code;
  @ApiModelProperty(value = "返回消息")
  private String message;
  @ApiModelProperty(value = "返回数据")
  private Map<String, Object> data = new HashMap<String, Object>();

  private R(){}

  public static R ok(){
    R r = new R();
    r.setSuccess(true);
    r.setCode(ResultCode.SUCCESS);
    r.setMessage("操作成功");
    return r;
  }
  public static R ok(String message){
    R r = new R();
    r.setSuccess(true);
    r.setCode(ResultCode.SUCCESS);
    r.setMessage(message);
    return r;
  }

  public static R error(int code,String message){
    R r = new R();
    r.setSuccess(false);
    r.setCode(code);
    r.setMessage(message);
    return r;
  }

  public static R error(){
    R r = new R();
    r.setSuccess(false);
    r.setCode(ResultCode.ERROR);
    r.setMessage("请求异常");
    return r;
  }

  public static R th(boolean is){
    R r = new R();
    r.setSuccess(is);
    if (is){
      r.setCode(ResultCode.SUCCESS);
      r.setMessage("请求成功");
    }else {
      r.setCode(ResultCode.ERROR);
      r.setMessage("请求异常");
    }

    return r;
  }


  public R success(Boolean success){
    this.setSuccess(success);
    return this;
  }

  public R message(String message){
    this.setMessage(message);
    return this;
  }

  public R code(Integer code){
    this.setCode(code);
    return this;
  }

  public R data(String key, Object value){
    this.data.put(key, value);
    return this;
  }

  public R data(Map<String, Object> map){
    this.setData(map);
    return this;
  }
}