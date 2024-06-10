package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Users;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.repository.UsersRepository;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public boolean getLogicUserByUsername(String username){

//        boolean logic = false;
//        if(!usersRepository.findAllByUsername(username).isEmpty()){
//            logic = true;
//        } else {
//            logic = false;
//        }
//        return logic;

        return (!usersRepository.findAllByUsername(username).isEmpty()) ? true : false;
    }

    public boolean getLogicUserByUsernameAndPassword(String username, String password){


        return usersRepository.findAllByUsernameAndPassword(username, password).isEmpty() ? true : false;
    }

    public Users getUserByUsernameAndPassword(String username, String password){

//        Users user = usersRepository.findAllByUsernameAndPassword(username, password).get(0);
//        if(user == null) {
//            return null;
//        } else  {
//            return user;
//        }


        return usersRepository.findAllByUsernameAndPassword(username, password).get(0);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = usersRepository.findByUsername(username);
        if(users == null) {
            throw new UsernameNotFoundException("Not found: " + username);
        }

        return users;
    }
}
