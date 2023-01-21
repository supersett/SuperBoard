package suuper.sett.superboard.service.impl;

import org.springframework.stereotype.Service;
import suuper.sett.superboard.data.dto.SignInResultDto;
import suuper.sett.superboard.data.dto.SignUpResultDto;
import suuper.sett.superboard.service.SignService;
@Service
public class SignServiceImpl implements SignService {



    @Override
    public SignUpResultDto signUp(String id, String password, String name, int status) {
        return null;
    }

    @Override
    public SignInResultDto signIn(String id, String password) throws RuntimeException {
        return null;
    }
}
