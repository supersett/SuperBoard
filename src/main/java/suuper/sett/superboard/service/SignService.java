package suuper.sett.superboard.service;

import suuper.sett.superboard.data.dto.SignInResultDto;
import suuper.sett.superboard.data.dto.SignUpResultDto;

public interface SignService {

    SignUpResultDto signUp(String id, String password, String name, int status);

    SignInResultDto signIn(String id, String password) throws RuntimeException;

}
