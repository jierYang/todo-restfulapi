package com.tw.train.restfulapi.Controller.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "UnAuthorized")
public class AuthorizedException extends Exception{
}
