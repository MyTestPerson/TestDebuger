package com.testdebuger.security;

import com.testdebuger.model.User;
import com.testdebuger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetail implements UserDetailsService {


    @Autowired
    UserRepository userRepository;


    /**
     * @param email Имя пользователя из формы ввода данных логина
     * @return - Возвращаем в UserDetails пользователя из БД
     * @throws UsernameNotFoundException - Исключения
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        // Получаем User из БД для проверки
        User user = userRepository.getUserDetailEmailPasswordEnabled(email);

        if (user == null){
            throw new UsernameNotFoundException("User with this name " + email + " does not exist");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                user.getEnabled(), true, true, true, getAuthorities());

    }



    private Collection<? extends GrantedAuthority> getAuthorities(){

        List<SimpleGrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return authList;

    }


}