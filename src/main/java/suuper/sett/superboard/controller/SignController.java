package suuper.sett.superboard.controller;

import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suuper.sett.superboard.data.dto.SignInResultDto;
import suuper.sett.superboard.data.dto.SignUpResultDto;
import suuper.sett.superboard.service.SignService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sign-api")
public class SignController {

    private final Logger LOGGER = LoggerFactory.getLogger(SignController.class);
    private final SignService signService;

    @Autowired
    public SignController(SignService signService) {
        this.signService = signService;
    }

    @PostMapping(value = "/sign-in")
    public SignInResultDto signIn(
            @ApiParam(value = "ID",required = true) @RequestParam String id,
            @ApiParam(value = "Password",required = true) @RequestParam String password
    ) throws RuntimeException{
        LOGGER.info("[SignIn] 로그인을 시도하고 있습니다. id :{},pw=****",id);
        SignInResultDto signInResultDto=signService.signIn(id,password);

        if (signInResultDto.getCode()==0){
            LOGGER.info("[SignIn] 로그인을 시도하고 있습니다. id :{}, token={}",id,
                    signInResultDto.getToken());
        }
        return signInResultDto;
    }

    @PostMapping(value = "/sign-up")
    public SignUpResultDto signUp(
            @ApiParam(value = "ID",required = true) @RequestParam String id,
            @ApiParam(value = "비밀번호",required = true) @RequestParam String password,
            @ApiParam(value = "이름",required = true) @RequestParam String name,
            @ApiParam(value = "권한",required = true) @RequestParam int status
    ){
        LOGGER.info("[SignUp] 회원가입을 수행합니다. id :{},pw={},name={}",id,password,name);
        SignUpResultDto signUpResultDto=signService.signUp(id,password,name,status);

        LOGGER.info("[SignUp] 회원가입을 완료했습니다. id :{},pw={},name={}",id,password,name);
        return signUpResultDto;
    }

    @GetMapping(value = "/exception")
    public void exceptionTest() throws RuntimeException{
        throw new RuntimeException("접근 금지");
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(RuntimeException e) {
        HttpHeaders responseHeaders = new HttpHeaders();
        //responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.error("ExceptionHandler 호출, {}, {}", e.getCause(), e.getMessage());

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }


}



















